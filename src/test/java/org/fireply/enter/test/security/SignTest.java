package org.fireply.enter.test.security;

import java.util.ArrayList;
import java.util.List;

import org.fireply.enter.security.Sign;
import org.fireply.enter.test.BaseSpringJunit4Test;
import org.junit.Test;
import static org.junit.Assert.assertNotNull;

public class SignTest {

    @Test
    public void signTest() {
        List<String> unEncrypt = new ArrayList<>();
        unEncrypt.add("userId");
        unEncrypt.add("userPassword");
        
        String token = Sign.encrypt(unEncrypt);
        System.out.println(token);
        assertNotNull(token);
    }
}
