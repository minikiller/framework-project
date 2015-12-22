package cn.com.rexen.core.security;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by sunlf on 2015/12/17.
 */
public class Util {
    public static String getUserName(String str) {
        Map map = new HashMap();
        String[] cnStr = str.split(",");
        for (String tempStr : cnStr) {
            String[] s1 = tempStr.split("=");
            map.put(s1[0], s1[1]);

        }
        return (String) map.get("CN");
    }
}
