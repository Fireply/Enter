package org.fireply.enter.action;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.fireply.enter.model.User;
import org.fireply.enter.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

@Controller
public class RegisterAction extends ActionSupport {

    @Autowired
    @Qualifier("registerServiceImpl")
    private RegisterService registerService;
    
    // 登录页面填写的 userId, 不止是和 数据库里 user 表的 id 挂钩，还和 admin 表的 id 挂钩
    private String userId;
    private String userPassword;    // 登录页面填写的 userPassword
    private String result;
    private InputStream isUnique;
    
    @Override
    public String execute() throws Exception {
        User user = new User();
        user.setId(userId);
        user.setPassword(userPassword);
        
        result = registerService.register(user);
        if (SUCCESS.equals(result)) {
            isUnique = new ByteArrayInputStream("可以使用√".getBytes("UTF-8"));
        } else {
            isUnique = new ByteArrayInputStream("已被注册".getBytes("UTF-8"));
        }
        
        return SUCCESS;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public InputStream getIsUnique() {
        return isUnique;
    }

    public void setIsUnique(InputStream isUnique) {
        this.isUnique = isUnique;
    }

}
