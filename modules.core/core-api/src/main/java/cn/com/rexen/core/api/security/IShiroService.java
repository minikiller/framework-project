package cn.com.rexen.core.api.security;

import cn.com.rexen.core.api.biz.JsonStatus;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;

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
     * 返回当前登录用户
     * @return
     */
    public Subject getSubject();

    /**
     * 获得shiro的session
     *
     * @return
     */

    Session getSession();

    /**
     * sessionid校验用户是否登录
     *
     * @return
     */
    public JsonStatus validSession(String sessionId);
}
