package org.fireply.enter.action;

import static org.fireply.enter.constant.ResultConstants.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;
import org.fireply.enter.model.Authorization;
import org.fireply.enter.model.User;
import org.fireply.enter.security.Md5;
import org.fireply.enter.security.Sign;
import org.fireply.enter.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

@Controller
public class LoginAction extends ActionSupport implements ServletRequestAware, ServletResponseAware, SessionAware {
    
    @Autowired
    @Qualifier("loginServiceImpl")
    private LoginService loginService;
    
    private HttpServletRequest request;
    private HttpServletResponse response;
    private Map<String, Object> session;

    private String userId;          // 登录页面填写的 userId
    private String userPassword;    // 登录页面填写的 userPassword
    
    @Override
    public String execute() throws Exception {

        Cookie[] cookies = request.getCookies();
        String remoteAddr = request.getRemoteAddr();
        String actionPath = request.getServletPath();
        boolean success = false;
        
        if (userId != null && userPassword != null) {
            String signedPassword = Md5.sign(userPassword);
            success = loginService.loginByPassword(userId, signedPassword, remoteAddr);
            if (success) {
                // 数据库是否有 sequence, token 记录，如果有更新 session, 否则生成后存入 session
                List<Authorization> authorizations = loginService.onceLogined(userId);
                if (authorizations == null) {
                    List<String> unEncrypted = new ArrayList<>();
                    unEncrypted.add(userId);
                    unEncrypted.add(userPassword);

                    String sequence = Sign.encrypt(unEncrypted);
                    String token = Sign.encrypt(unEncrypted);
                    
                    User user = (User) loginService.get(User.class, userId);
                    Authorization authorization = new Authorization();
                    authorization.setUser(user);
                    authorization.setSequence(sequence);
                    authorization.setToken(token);
                    authorization.setLastTime(new Date());
                    
                    loginService.persist(authorization);
                    
                    session.put("userId", userId);
                    session.put("sequence", sequence);
                    session.put("token", token);
                } else {
                    String value;
                    for (Authorization auth : authorizations) {
                        value = auth.getUser().getId();
                        if (value != null && value.length() > 0) {
                            session.put("userId", value);
                        }
                        value = auth.getSequence();
                        if (value != null && value.length() > 0) {
                            session.put("sequence", value);
                        }
                        value = auth.getToken();
                        if (value != null && value.length() > 0) {
                            session.put("token", value);
                        }
                    }
                } 
            }
        } else if (cookies != null) {
            String cookieUserId = null;
            String cookieSequence = null;
            String cookieToken = null;
            boolean found = false;
            
            for (Cookie cookie : cookies) {
                if (cookie != null) {
                    if ("userId".equals(cookie.getName())) {
                        cookieUserId = cookie.getValue();
                        found = true;
                    } else if ("sequence".equals(cookie.getName())) {
                        cookieSequence = cookie.getValue();
                        found = true;
                    } else if ("token".equals(cookie.getName())) {
                        cookieToken= cookie.getValue();
                        found = true;
                    }
                }
            }
            
            if (found) {    // 使用 Cookie 登陆
                success = loginService.loginByCookie(cookieUserId, cookieSequence, cookieToken, remoteAddr);
            } else {
                return LOGIN;
            }
        }
        
        // 如果登录成功
        if (success) {
            if (actionPath != null && actionPath.length() > 0 && !"/login".equals(actionPath)) {
                return actionPath;
            } else {
                return PROFILE_USER;
            }
        } else {
            return LOGIN_FAILURE;
        }
    }

    @Override
    public void setServletRequest(HttpServletRequest request) {
        this.request = request;        
    }
    
    @Override
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }

    @Override
    public void setServletResponse(HttpServletResponse response) {
        this.response = response;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

}
