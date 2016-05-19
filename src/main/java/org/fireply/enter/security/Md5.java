package org.fireply.enter.security;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

/**
 * SHA1 签名生成类
 * 
 */
public class Md5 {
    
    /**
     * 用 SHA1算法生成安全签名
     * @param unsign 待签名字符串
     * @return 安全签名
     * @throws AesException 
     * 
     */
    public static String sign(String unsign) throws AesException {
        try {
            // SHA1签名生成
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(unsign.getBytes());
            byte[] digest = md.digest();
            
            StringBuffer hexStr = new StringBuffer();
            String shaHex = "";
            for (int i = 0; i < digest.length; i++) {
                shaHex = Integer.toHexString(digest[i] & 0xFF);
                if (shaHex.length() < 2) {
                    hexStr.append(0);
                }
                hexStr.append(shaHex);
            }
            return hexStr.toString();
        } catch (Exception e) {
            e.printStackTrace();
            throw new AesException(AesException.ComputeSignatureError);
        }
    }
    
}
