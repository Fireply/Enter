package org.fireply.enter.util;

public class ClumnNameUtil {

    private static final char SEPARATOR = '_';

    public static String getClumnName(String fieldName) {
        return getUnderlineCase(fieldName);
    }

    public static String getUnderlineCase(String camelCase) {
        if (camelCase == null) {
            return null;
        }

        StringBuilder sb = new StringBuilder();
        boolean upperCase = false;
        boolean nextUpperCase = false;
        char c;

        for (int i = 0; i < camelCase.length(); i++) {
            c = camelCase.charAt(i);
            sb.append(Character.toLowerCase(c));

            if (i < (camelCase.length() - 1)) {
                upperCase = Character.isUpperCase(camelCase.charAt(i));
                nextUpperCase = Character.isUpperCase(camelCase.charAt(i + 1));
                if (!upperCase && nextUpperCase) {
                    sb.append(SEPARATOR);
                }
            }
        }

        return sb.toString();
    }
}
