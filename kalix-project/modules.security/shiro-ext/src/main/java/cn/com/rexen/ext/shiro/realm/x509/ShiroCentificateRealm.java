package cn.com.rexen.ext.shiro.realm.x509;

import cn.com.rexen.core.api.PermissionConstant;
import cn.com.rexen.core.api.security.IAuthorizingRealm;
import cn.com.rexen.core.api.security.IUserLoginService;
import cn.com.rexen.core.util.JNDIHelper;
import cn.com.rexen.ext.shiro.authc.x509.X509AuthenticationInfo;
import cn.com.rexen.ext.shiro.authc.x509.X509AuthenticationToken;
import cn.com.rexen.ext.shiro.authc.x509.X509CredentialsIssuerDNSNMatcher;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.osgi.service.event.EventAdmin;

import java.io.IOException;
import java.util.List;

/**
 * Created by sunlf on 2015/12/15.
 */
public class ShiroCentificateRealm extends AbstractX509Realm implements IAuthorizingRealm {
    private IUserLoginService userLoginService;
    private EventAdmin eventAdmin;

    public ShiroCentificateRealm() {
        setName("myMemoryRealm");
        setCachingEnabled(true);
        X509CredentialsIssuerDNSNMatcher cm = new X509CredentialsIssuerDNSNMatcher();
        setCredentialsMatcher(cm);
        setAuthenticationTokenClass(X509AuthenticationToken.class);
    }

    @Override
    protected X509AuthenticationInfo doGetX509AuthenticationInfo(X509AuthenticationToken x509AuthenticationToken) {
        String username = (String) x509AuthenticationToken.getPrincipal();
        try {
            userLoginService = JNDIHelper.getJNDIServiceForName(IUserLoginService.class.getName());
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (userLoginService.validateUserStatus(username)) {
            Session session = SecurityUtils.getSubject().getSession();
            session.setAttribute(PermissionConstant.SYS_CURRENT_USERNAME, username);
            return new X509AuthenticationInfo(x509AuthenticationToken.getPrincipal(), x509AuthenticationToken.getIssuerDN(),
                    x509AuthenticationToken.getHexSerialNumber(),
                    getName());
        }
        throw new AuthenticationException();
    }


    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        String userName = principals.getPrimaryPrincipal().toString();
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        try {
            userLoginService = JNDIHelper.getJNDIServiceForName(IUserLoginService.class.getName());
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<String> userPermission = userLoginService.getUserPermission(userName);
        if (userPermission != null) {
            for (String permission : userPermission)
                info.addRole(permission);
        }
        return info;
    }

    public Class getAuthenticationTokenClass() {
        return X509AuthenticationToken.class;
    }

    public CredentialsMatcher getCredentialsMatcher() {
        return new X509CredentialsIssuerDNSNMatcher();
    }

    public void setEventAdmin(EventAdmin eventAdmin) {
        this.eventAdmin = eventAdmin;
    }
}
