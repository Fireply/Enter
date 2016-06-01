package org.fireply.enter.service.impl;

import org.fireply.enter.dao.UserDao;
import org.fireply.enter.model.User;
import org.fireply.enter.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class UserServiceImpl extends BaseServiceImpl implements UserService {

    @Autowired
    @Qualifier("userDaoImpl")
    private UserDao userDaoImpl;
    
    @Override
    public User getUserById(String userId) {
        // TODO Auto-generated method stub
        return null;
    }

}
