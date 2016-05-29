package org.fireply.enter.security;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Random;

public class Sign {

    public static String sign(List<String> unSigned) {
        String signed = null;

        if (unSigned == null) {
            unSigned = new ArrayList<>();
        }
        
        String currentTime = Long.toString(System.currentTimeMillis());
        unSigned.add(currentTime);
        unSigned.add(getRandomStr());

        int r = 0, w = 0;
        for (; r < unSigned.size(); r++) {
            if (unSigned.get(r) != null) {
                unSigned.set(w++, unSigned.get(r));
            }
        }
        unSigned = unSigned.subList(0, w);
        
        Object[] unSignedArray = unSigned.toArray();
        Arrays.sort(unSignedArray);

        try {
            signed = Md5.md5(unSignedArray.toString());
        } catch (AesException e) {
            e.printStackTrace();
        }

        return signed;
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
