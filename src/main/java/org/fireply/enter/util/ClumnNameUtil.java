package org.fireply.enter.util;

public class ClumnNameUtil {

    public static String getClumnName(String fieldName) {
        return getUnderlineCase(fieldName);
    }
    
    public static String getUnderlineCase(String camelCase) {
        // TODO 实体类属性与数据库列的映射方法
        return "user_id";
    }
}
