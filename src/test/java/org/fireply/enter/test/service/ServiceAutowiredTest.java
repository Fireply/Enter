package org.fireply.enter.test.service;

import static org.junit.Assert.*;

import org.fireply.enter.service.BaseService;
import org.fireply.enter.service.LoginService;
import org.fireply.enter.test.BaseSpringJunit4Test;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class ServiceAutowiredTest extends BaseSpringJunit4Test {

    @Autowired
    @Qualifier("baseServiceImpl")
    BaseService baseService;
    
    @Autowired
    @Qualifier("loginServiceImpl")
    LoginService loginService;
    
    @Test
    public void baseServiceAutowiredTest() {
        assertNotNull(baseService);
    }
    
    @Test
    public void loginServiceAutowiredTest() {
        assertNotNull(loginService);
    }
    
}
