package org.fireply.enter.service;

import java.io.Serializable;
import java.util.List;

import javax.servlet.http.Cookie;

public interface LoginService extends BaseService {

    boolean loginByPassword(String userId, String signedPassword, String remoteAddr);
    
    boolean loginByCookie(String userId, String sequence, String token, String remoteAddr);
    
    boolean allowsLogin(String userId, String remoteAddr);
    
    /** 
     * 是否曾经登陆过
     * @param userId 用户 ID
     * @return boolean 如果曾经登陆过返回 {@code true}, 否则返回 {@code false}
     */
    <T> List<T> onceLogined(String userId);
    
}
