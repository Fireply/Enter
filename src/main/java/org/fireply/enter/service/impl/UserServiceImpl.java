package org.fireply.enter.service.impl;

import org.fireply.enter.dao.UserDao;
import org.fireply.enter.model.User;
import org.fireply.enter.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly=true)
public class UserServiceImpl implements UserService {

    @Autowired
    @Qualifier("userDaoImpl")
    private UserDao userDao;
    
    @Override
    public User getUserById(String userId) {
         return userDao.getUserById(userId);
    }

    @Override
    @Transactional
    public void persistUser(User user) {
        userDao.persistUser(user);
    }

    @Override
    public boolean hasExisted(String userId) {
        User user = getUserById(userId);
        if (user != null) {
            return true;
        } else {
            return false;            
        }
    }

}
