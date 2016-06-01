package org.fireply.enter.service;

import org.fireply.enter.model.User;

public interface UserService {
    
    User getUserById(String userId);

    void persistUser(User user);
    
    boolean hasExisted(String userId);
    
}
