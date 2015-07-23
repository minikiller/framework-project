package cn.com.rexen.core.api.security;

import org.apache.shiro.session.Session;

/**
 * Created by sunlf on 2015/7/23.
 * 安全服务
 */
public interface IShiroService {
    /**
     * 获得当前登录的用户名称
     *
     * @return 用户名称
     */
    String getCurrentUserName();

    /**
     * 获得shiro的session
     *
     * @return
     */

    Session getSession();
}
