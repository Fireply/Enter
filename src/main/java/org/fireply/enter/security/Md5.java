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
     * @param undigested 待签名字符串
     * @return 安全签名
     * @throws AesException 
     * 
     */
    public static String md5(String undigested) throws AesException {
        try {
            // MD5 签名生成
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(undigested.getBytes());
            byte[] digest = md.digest();
            
            StringBuffer hexStr = new StringBuffer();
            String byteHex = "";
            for (int i = 0; i < digest.length; i++) {
                byteHex = Integer.toHexString(digest[i] & 0xFF);
                if (byteHex.length() < 2) {
                    hexStr.append(0);
                }
                hexStr.append(byteHex);
            }
            return hexStr.toString();
        } catch (Exception e) {
            e.printStackTrace();
            throw new AesException(AesException.ComputeSignatureError);
        }
    }
    
}
