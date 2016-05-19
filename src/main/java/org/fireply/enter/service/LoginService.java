package org.fireply.enter.service;

import javax.servlet.http.Cookie;

public interface LoginService extends BaseService {

    boolean loginByPassword(String userId, String signedPassword, String remoteAddr);
    
    boolean loginByCookie(String userId, String sequence, String token, String remoteAddr);
    
    boolean allowsLogin(String userId, String remoteAddr);
    
}
