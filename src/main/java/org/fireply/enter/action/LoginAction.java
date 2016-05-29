package org.fireply.enter.action;

import static org.fireply.enter.constant.ResultConstants.PROFILE_ADMIN;
import static org.fireply.enter.constant.ResultConstants.PROFILE_USER;
import static org.fireply.enter.constant.ResultConstants.SUCCESS_ADMIN;
import static org.fireply.enter.constant.ResultConstants.SUCCESS_COOKIE_ADMIN;
import static org.fireply.enter.constant.ResultConstants.SUCCESS_COOKIE_USER;
import static org.fireply.enter.constant.ResultConstants.SUCCESS_USER;

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
import org.fireply.enter.model.Admin;
import org.fireply.enter.model.AdminAuthorization;
import org.fireply.enter.model.User;
import org.fireply.enter.model.UserAuthorization;
import org.fireply.enter.security.Md5;
import org.fireply.enter.security.Sign;
import org.fireply.enter.service.LoginService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    // 登录页面填写的 userId, 不止是和 数据库里 user 表的 id 挂钩，还和 admin 表的 id 挂钩
    private String userId;
    private String userPassword; // 登录页面填写的 userPassword
    
    private static final Logger logger = LoggerFactory.getLogger(LoginAction.class);

    @Override
    public String execute() throws Exception {

        Cookie[] cookies = request.getCookies();
        String remoteAddr = request.getRemoteAddr();
        String actionPath = request.getServletPath();
        String loginResult = null;
        
        String cookieUserId = null;
        String cookieAdminId = null;
        String cookieSequence = null;
        String cookieToken = null;

        if (userId != null && userPassword != null) {
            logger.debug("用户/管理员 {} 使用密码登录", userId);
            String signedPassword = Md5.md5(userPassword);
            loginResult = loginService.loginByPassword(userId, signedPassword, remoteAddr);
        } else if (cookies != null) {
            boolean found = false;

            for (Cookie cookie : cookies) {
                if (cookie != null) {
                    if ("userId".equals(cookie.getName())) {
                        cookieUserId = cookie.getValue();
                        found = true;
                    } else if ("adminId".equals(cookie.getName())) {
                        cookieAdminId = cookie.getValue();
                        found = true;
                    } else if ("sequence".equals(cookie.getName())) {
                        cookieSequence = cookie.getValue();
                        found = true;
                    } else if ("token".equals(cookie.getName())) {
                        cookieToken = cookie.getValue();
                        found = true;
                    }
                }
            }

            if (found) { // 使用 Cookie 登陆
                if (cookieAdminId != null && cookieAdminId.length() > 0) {
                    logger.debug("管理员 {} 使用 Cookie 登录", cookieAdminId);
                    loginResult = loginService.loginByCookie(cookieAdminId, cookieSequence, cookieToken,
                            remoteAddr);
                } else {
                    logger.debug("用户 {} 使用 Cookie 登录", cookieUserId);
                    loginResult = loginService.loginByCookie(cookieUserId, cookieSequence, cookieToken,
                            remoteAddr);
                }
            } else {
                return LOGIN;
            }
        } else {
            return LOGIN;
        }

        // 如果登录成功
        if (SUCCESS_USER.equals(loginResult)) {
            logger.info("用户 {} 通过密码登录成功", userId);     
            updateUserAuthorization(userId);
            //TODO 
            if (actionPath != null && actionPath.length() > 0 && !"/login".equals(actionPath)) {
                return actionPath.startsWith("/") ? actionPath.substring(1) : actionPath;
            } else {
                return PROFILE_USER;
            }
        } else if (SUCCESS_COOKIE_USER.equals(loginResult)) {
            logger.info("用户 {} 通过 Cookie 登录成功", cookieUserId);
            updateUserAuthorization(cookieUserId);
            //TODO 
            if (actionPath != null && actionPath.length() > 0 && !"/login".equals(actionPath)) {
                return actionPath.startsWith("/") ? actionPath.substring(1) : actionPath;
            } else {
                return PROFILE_USER;
            }
        }else if (SUCCESS_ADMIN.equals(loginResult)) {
            logger.info("管理员 {} 通过密码登录成功", userId);
            updateAdminAuthorization(userId);   // 前台页面 userId 与 adminId 共用一个 name="userId" 的 <input> 标签
            if (actionPath != null && actionPath.length() > 0 && !"/login".equals(actionPath)) {
                return actionPath;//TODO 
            } else {
                return PROFILE_ADMIN;
            }
        } else if (SUCCESS_COOKIE_ADMIN.equals(loginResult)) {
            logger.info("管理员 {} 通过 Cookie 登录成功", cookieAdminId);
            updateAdminAuthorization(cookieAdminId);
            if (actionPath != null && actionPath.length() > 0 && !"/login".equals(actionPath)) {
                return actionPath;//TODO 
            } else {
                return PROFILE_ADMIN;
            }
        } else {
            deleteAuthorization();
            return LOGIN;
        }
    }

    // 查询数据库是否有 sequence, token 记录，如果有更新 Cookie 和 Session, 否则生成后存入 Cookie 和 session
    private void updateUserAuthorization(String userId) {
        List<UserAuthorization> userAuths = loginService.userLoginHistory(userId);
        if (userAuths == null) {
            List<String> unSinged = new ArrayList<>();
            if (userId != null) {
                unSinged.add(userId);
            }
            if (userPassword != null) {
                unSinged.add(userPassword);
            }
            String sequence = Sign.sign(unSinged);      // 登录序列，每个用户只有一个序列实例
            String token = Sign.sign(unSinged);         // 登录令牌

            //将 userId, sequence, token 存入数据库
            User user = (User) loginService.get(User.class, userId);
            if (user != null) {
                UserAuthorization userAuthorization = new UserAuthorization();
                userAuthorization.setUser(user);
                userAuthorization.setSequence(sequence);
                userAuthorization.setToken(token);
                userAuthorization.setLastTime(new Date());
                loginService.persist(userAuthorization);
            }
            // 将 userId, sequence, token 存入 Cookie
            Cookie cookie = new Cookie("userId", userId);
            response.addCookie(cookie);
            cookie = new Cookie("sequence", sequence);
            response.addCookie(cookie);
            cookie = new Cookie("token", token);
            response.addCookie(cookie);
            
            // 删除 Cookie adminId
            cookie = new Cookie("adminId", "");
            response.addCookie(cookie);

            // 将 userId, sequence, token 存入 Session
            session.put("userId", userId);
            session.put("sequence", sequence);
            session.put("token", token);
        } else {
            String value;
            Cookie cookie;
            
            for (UserAuthorization auth : userAuths) {
                value = auth.getUser().getId();
                if (value != null && value.length() > 0) {
                    cookie = new Cookie("userId", value);
                    response.addCookie(cookie);
                    session.put("userId", value);
                }
                value = auth.getSequence();
                if (value != null && value.length() > 0) {
                    cookie = new Cookie("sequence", value);
                    response.addCookie(cookie);
                    session.put("sequence", value);
                }
                value = auth.getToken();
                if (value != null && value.length() > 0) {
                    cookie = new Cookie("token", value);
                    response.addCookie(cookie);
                    session.put("token", value);
                }
            }
        }
    }
    
    // 查询数据库是否有 sequence, token 记录，如果有更新 Cookie 和 Session, 否则生成后存入 Cookie 和 session
    private void updateAdminAuthorization(String adminId) {
        List<AdminAuthorization> adminAuths = loginService.adminLoginHistory(adminId);
        if (adminAuths == null) {
            List<String> unSigned = new ArrayList<>();
            if (adminId != null) {
                unSigned.add(adminId);
            }
            if (userPassword != null) {
                unSigned.add(userPassword);
            }
            String sequence = Sign.sign(unSigned);
            String token = Sign.sign(unSigned);
            
            //将 adminId, sequence, token 存入数据库
            Admin admin = (Admin) loginService.get(Admin.class, adminId);
            if (admin != null) {
                AdminAuthorization adminAuthorization = new AdminAuthorization();
                adminAuthorization.setAdmin(admin);
                adminAuthorization.setSequence(sequence);
                adminAuthorization.setToken(token);
                adminAuthorization.setLastTime(new Date());
                loginService.persist(adminAuthorization);
            }
            
            // 将 adminId, sequence, token 存入 Cookie
            Cookie cookie = new Cookie("adminId", adminId);
            response.addCookie(cookie);
            cookie = new Cookie("sequence", sequence);
            response.addCookie(cookie);
            cookie = new Cookie("token", token);
            response.addCookie(cookie);

            // 删除 Cookie userId
            cookie = new Cookie("userId", "");
            response.addCookie(cookie);
            
            // 将 adminId, sequence, token 存入 Session
            session.put("adminId", adminId);
            session.put("sequence", sequence);
            session.put("token", token);
        } else {
            String value;
            Cookie cookie;
            
            for (AdminAuthorization auth : adminAuths) {
                value = auth.getAdmin().getId();
                if (value != null && value.length() > 0) {
                    cookie = new Cookie("adminId", value);
                    response.addCookie(cookie);
                    session.put("adminId", value);
                }
                value = auth.getSequence();
                if (value != null && value.length() > 0) {
                    cookie = new Cookie("sequence", value);
                    response.addCookie(cookie);
                    session.put("sequence", value);
                }
                value = auth.getToken();
                if (value != null && value.length() > 0) {
                    cookie = new Cookie("token", value);
                    response.addCookie(cookie);
                    session.put("token", value);
                }
            }
        }
    }
    
    private void deleteAuthorization() {

        // 清空 Session
        session.clear();
        
        // 清空 Cookie 里的 userId, adminId, sequence, token
        Cookie cookie = new Cookie("userId", "");
        response.addCookie(cookie);
        cookie = new Cookie("adminId", "");
        response.addCookie(cookie);
        cookie = new Cookie("sequence", "");
        response.addCookie(cookie);
        cookie = new Cookie("token", "");
        response.addCookie(cookie);
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
