package org.fireply.enter.test.service;

import static org.junit.Assert.*;

import org.fireply.enter.model.Admin;
import org.fireply.enter.service.BaseService;
import org.fireply.enter.test.BaseSpringJunit4Test;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class AdminServiceTest extends BaseSpringJunit4Test {

    @Autowired
    @Qualifier("baseServiceImpl")
    BaseService baseService;
    
    @Test
    public void getAdminTest() {
        String adminId = "admin";
        Admin admin = (Admin) baseService.get(Admin.class, adminId);
        assertNotNull(admin);
        System.out.println(admin);
    }
}
