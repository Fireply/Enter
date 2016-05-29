package org.fireply.enter.service;

import java.io.Serializable;
import java.util.List;

import javax.servlet.http.Cookie;

public interface LoginService extends BaseService {

    String loginByPassword(String userId, String signedPassword, String remoteAddr);
    
    String loginByCookie(String userId, String sequence, String token, String remoteAddr);
    
    boolean allowsLogin(String userId, String remoteAddr);
    
    /** 
     * 是否曾经登陆过
     * @param userId 用户 ID
     * @return boolean 如果用户曾经登陆过返回 {@code true}, 否则返回 {@code false}
     */
    <T> List<T> userLoginHistory(String userId);
    
    /** 
     * 是否曾经登陆过
     * @param userId 用户 ID
     * @return boolean 如果曾经管理员登陆过返回 {@code true}, 否则返回 {@code false}
     */
    <T> List<T> adminLoginHistory(String userId);
}
