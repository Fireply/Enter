package org.fireply.enter.dao;

import org.fireply.enter.model.User;

public interface UserDao {

    User getUserById(String userId);
    
    void persistUser(User user);
    
}
