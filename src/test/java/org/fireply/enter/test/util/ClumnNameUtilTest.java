package org.fireply.enter.test.util;

import static org.junit.Assert.assertEquals;

import org.fireply.enter.util.ClumnNameUtil;
import org.junit.Test;

public class ClumnNameUtilTest {
    
    @Test
    public void getUnderlineCaseTest() {
        assertEquals("user_id", ClumnNameUtil.getUnderlineCase("userId"));
        assertEquals("user_id", ClumnNameUtil.getUnderlineCase("UserId"));
        assertEquals("userid", ClumnNameUtil.getUnderlineCase("USERID"));
        assertEquals("user_id", ClumnNameUtil.getUnderlineCase("USErId"));
        assertEquals("user_id", ClumnNameUtil.getUnderlineCase("userID"));
        assertEquals("u_ser_id", ClumnNameUtil.getUnderlineCase("uSErId"));
        assertEquals("userid", ClumnNameUtil.getUnderlineCase("USERId"));
        assertEquals("useri_d", ClumnNameUtil.getUnderlineCase("useriD"));
    }

}
