package org.fireply.enter.service;

import org.fireply.enter.model.User;

public interface UserService extends BaseService {
    
    User getUserById(String userId);

}
