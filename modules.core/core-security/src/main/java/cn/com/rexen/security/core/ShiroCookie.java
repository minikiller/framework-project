package cn.com.rexen.security.core;

import org.apache.shiro.web.servlet.SimpleCookie;

/**
 * Created by admin on 2014/7/6.
 */
public class ShiroCookie extends SimpleCookie {

    public ShiroCookie(String name) {
        super(name);
    }

    public ShiroCookie() {
        super();
    }
}
