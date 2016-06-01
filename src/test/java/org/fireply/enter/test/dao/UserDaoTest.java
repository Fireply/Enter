package org.fireply.enter.test.dao;

import org.fireply.enter.dao.UserDao;
import org.fireply.enter.dao.impl.UserDaoImpl;
import org.fireply.enter.model.User;
import org.fireply.enter.test.BaseSpringJunit4Test;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly=true)
public class UserDaoTest extends BaseSpringJunit4Test {

    @Autowired
    @Qualifier("userDaoImpl")
    private UserDao userDao;
    
    @Test
    public void userDaoTest() {
        User user = userDao.getUserById("user");
        Assert.assertNotNull(user);
    }
}
