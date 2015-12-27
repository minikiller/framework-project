package cn.com.rexen.security.core.filter;

import cn.com.rexen.core.util.JNDIHelper;
import cn.com.rexen.core.util.SystemUtil;
import org.apache.shiro.web.env.WebEnvironment;
import org.apache.shiro.web.filter.mgt.FilterChainResolver;
import org.apache.shiro.web.mgt.WebSecurityManager;
import org.apache.shiro.web.servlet.AbstractShiroFilter;
import org.apache.shiro.web.util.WebUtils;

import java.io.IOException;

/**
 * Created by sunlf on 2015/7/10.
 */
public class KalixSecurityFilter extends AbstractShiroFilter {
    private WebSecurityManager securityManager;

    public void setSecurityManager(WebSecurityManager securityManager) {
        this.securityManager = securityManager;
    }

    @Override
    public void destroy() {

    }

    @Override
    public void init() throws Exception {
        WebEnvironment env = WebUtils.getRequiredWebEnvironment(getServletContext());
        try {
            securityManager = JNDIHelper.getJNDIServiceForName(WebSecurityManager.class.getName());
            SystemUtil.errorPrintln("start shiro security manager succeed!");
        } catch (IOException e) {
            e.printStackTrace();
        }

        super.setSecurityManager(securityManager);
        FilterChainResolver resolver = env.getFilterChainResolver();
        if (resolver != null) {
            setFilterChainResolver(resolver);
        }
    }
}
