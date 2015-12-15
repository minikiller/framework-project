package cn.com.rexen.ext.shiro.realm.x509;

import cn.com.rexen.ext.shiro.authc.x509.X509AuthenticationInfo;
import cn.com.rexen.ext.shiro.authc.x509.X509AuthenticationToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.subject.PrincipalCollection;

/**
 * Created by sunlf on 2015/12/15.
 */
public class ShiroCentificateRealm extends AbstractX509Realm {
    @Override
    protected X509AuthenticationInfo doGetX509AuthenticationInfo(X509AuthenticationToken x509AuthenticationToken) {
        return null;
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        return null;
    }
}
