package cn.com.rexen.core.security.impl;

import cn.com.rexen.core.api.PermissionConstant;
import cn.com.rexen.core.api.security.IShiroService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.web.mgt.WebSecurityManager;

/**
 * Created by sunlf on 2015/7/23.
 */
public class ShiroServiceImpl implements IShiroService {
    private WebSecurityManager securityManager;

    public void setSecurityManager(WebSecurityManager securityManager) {
        this.securityManager = securityManager;
    }

    public void init() {
        SecurityUtils.setSecurityManager(securityManager);
    }

    @Override
    public String getCurrentUserName() {
        Session session = getSession();
        String userName = (String) session.getAttribute(PermissionConstant.SYS_CURRENT_USERNAME);
        return userName;
    }

    @Override
    public Session getSession() {
        return SecurityUtils.getSubject().getSession();
    }
}