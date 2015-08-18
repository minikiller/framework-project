package cn.com.rexen.core.util;

import sun.misc.BASE64Encoder;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * MD5加密工具类
 *
 * @author majian <br/>
 *         date:2015-8-18
 * @version 1.0.0
 */
public class MD5Util {

    /**
     * MD5加密
     * @param str
     * @return
     */
    public static String encode(String str) {
        String returnStr = new String("");
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            BASE64Encoder base64en = new BASE64Encoder();
            returnStr = base64en.encode(md5.digest(str.getBytes("utf-8")));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return returnStr;
    }
}
