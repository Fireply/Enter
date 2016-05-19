package org.fireply.enter.security;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Sign {

    public static String encrypt(List<String> unEncrypted) {
        String encrypted = null;

        if (unEncrypted == null) {
            unEncrypted = new ArrayList<>();
        }
        
        String currentTime = Long.toString(System.currentTimeMillis());
        unEncrypted.add(currentTime);
        unEncrypted.add(getRandomStr());

        Object[] unEncryptedArray = unEncrypted.toArray();
        Arrays.sort(unEncryptedArray);

        try {
            encrypted = Md5.sign(unEncryptedArray.toString());
        } catch (AesException e) {
            e.printStackTrace();
        }

        return encrypted;
    }

    public static String getRandomStr() {
        String base = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 16; i++) {
            int number = random.nextInt(base.length());
            sb.append(base.charAt(number));
        }
        return sb.toString();
    }
}
