package org.fireply.enter.dao.impl;

import org.fireply.enter.dao.AbstractDao;
import org.fireply.enter.dao.UserDao;
import org.fireply.enter.model.User;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl extends AbstractDao<String, User> implements UserDao {

    @Override
    public User getUserById(String id) {
        return getById(id);
    }

}
