package cn.com.rexen.security.core;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.SessionContext;
import org.apache.shiro.session.mgt.SessionFactory;

/**
 * Created by admin on 2014/7/4.
 */
public class ShiroSessionFactory implements SessionFactory {
    @Override
    public Session createSession(SessionContext initData) {
        if (initData != null) {
            String host = initData.getHost();
            if (host != null) {
                return new ShiroSession(host);
            }
        }
        return new ShiroSession();
    }
}
