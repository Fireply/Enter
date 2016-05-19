package org.fireply.enter.service.impl;

import org.fireply.enter.dao.Dao;
import org.fireply.enter.model.User;
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
    public boolean loginByPassword(String userId, String signedPassword, String remoteAddr) {
        User user = (User) dao.get(User.class, userId);
        if (signedPassword != null && user != null && signedPassword.equals(user.getPassword())) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean loginByCookie(String userId, String sequence, String token, String remoteAddr) {
        // TODO loginByCookie
        /*if (loginService != null && user != null && signedPassword.equals(user.getPassword())) {
            List<String> unEncrypted = new ArrayList<>();
            unEncrypted.add(userId);
            unEncrypted.add(signedPassword);

            sequence = Sign.encrypt(unEncrypted);
            token = Sign.encrypt(unEncrypted);
        }*/
        return true;
    }

    @Override
    public boolean allowsLogin(String userId, String remoteAddr) {
        return true;
    }

}
