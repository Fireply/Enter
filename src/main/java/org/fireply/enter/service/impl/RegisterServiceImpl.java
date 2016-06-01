package org.fireply.enter.service.impl;

import org.fireply.enter.model.User;
import org.fireply.enter.service.RegisterService;
import org.fireply.enter.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class RegisterServiceImpl implements RegisterService {

    @Autowired
    @Qualifier("userServiceImpl")
    private UserService userService;
    
    private static final Logger logger = LoggerFactory.getLogger(RegisterServiceImpl.class);
    
    @Override
    public String register(User user) {
        if (user == null) {
            return "error";
        }
        
        boolean hasExisted = userService.hasExisted(user.getId());
        if (hasExisted) {
            return "error";
        }
        
        try {
            userService.persistUser(user);
            logger.info("{} 注册成功", user.getId());
        } catch (Exception e) {
            logger.warn("{} 注册失败", user.getId());
            e.printStackTrace();
        }
        
        return "success";
    }
    
}
