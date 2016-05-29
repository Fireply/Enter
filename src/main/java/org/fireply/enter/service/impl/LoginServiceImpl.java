package org.fireply.enter.service.impl;

import static org.fireply.enter.constant.ResultConstants.LOGIN_FAILURE;
import static org.fireply.enter.constant.ResultConstants.SUCCESS_ADMIN;
import static org.fireply.enter.constant.ResultConstants.SUCCESS_COOKIE_ADMIN;
import static org.fireply.enter.constant.ResultConstants.SUCCESS_COOKIE_USER;
import static org.fireply.enter.constant.ResultConstants.SUCCESS_USER;

import java.util.List;

import org.fireply.enter.dao.Dao;
import org.fireply.enter.model.Admin;
import org.fireply.enter.model.AdminAuthorization;
import org.fireply.enter.model.User;
import org.fireply.enter.model.UserAuthorization;
import org.fireply.enter.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class LoginServiceImpl extends BaseServiceImpl implements LoginService {

    @Autowired
    @Qualifier("daoImpl")
    private Dao dao;

    @Override
    public String loginByPassword(String userId, String signedPassword, String remoteAddr) {
        // 先查找 admin 表，如果密码正确，视为管理员登录（注册时 admin 表 id 与 user 表 id 唯一）
        Admin admin = (Admin) dao.get(Admin.class, userId);
        if (signedPassword != null && admin != null && signedPassword.equals(admin.getPassword())) {
            return SUCCESS_ADMIN;
        }

        // 再查找 user 表，如果密码正确，视为普通用户登录
        User user = (User) dao.get(User.class, userId);
        if (signedPassword != null && user != null && signedPassword.equals(user.getPassword())) {
            return SUCCESS_USER;
        }

        // 否则登录失败
        return LOGIN_FAILURE;
    }

    // TODO 暂时只判断 sequence 是否正确，未判断 token, 待完成
    @Override
    public String loginByCookie(String userId, String sequence, String token, String remoteAddr) {
        // 先查找 admin_authorization 表，如果 sequence 正确，视为管理员登录
        List<AdminAuthorization> adminAuths = (List<AdminAuthorization>) dao.get(AdminAuthorization.class, "adminId",
                userId);
        for (AdminAuthorization adminAuth : adminAuths) {
            if (adminAuth != null && adminAuth.getSequence().equals(sequence)) {
                return SUCCESS_COOKIE_ADMIN;
            }
        }

        // 再查找 user_authorization 表，如果 sequence 正确，视为普通用户登录
        List<UserAuthorization> userAuths = (List<UserAuthorization>) dao.get(UserAuthorization.class, "userId",
                userId);
        for (UserAuthorization userAuth : userAuths) {
            if (userAuth != null && userAuth.getSequence().equals(sequence)) {
                return SUCCESS_COOKIE_USER;
            }
        }

        // 否则登录失败
        return LOGIN_FAILURE;
    }

    @Override
    public boolean allowsLogin(String userId, String remoteAddr) {
        return true;
    }

    @Override
    public List<UserAuthorization> userLoginHistory(String userId) {
        List<UserAuthorization> list = (List<UserAuthorization>) dao.get(UserAuthorization.class, "userId", userId);
        if (list != null && !list.isEmpty()) {
            return list;
        } else {
            return null;
        }
    }

    @Override
    public List<AdminAuthorization> adminLoginHistory(String adminId) {
        List<AdminAuthorization> list = (List<AdminAuthorization>) dao.get(AdminAuthorization.class, "adminId",
                adminId);
        if (list != null && !list.isEmpty()) {
            return list;
        } else {
            return null;
        }
    }

}
