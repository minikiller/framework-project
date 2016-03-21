package cn.com.rexen.core.api.osgi;

import cn.com.rexen.core.util.ConfigUtil;
import org.osgi.framework.BundleActivator;

/**
 * @author chenyanxu
 */
public abstract class KalixBundleActivator implements BundleActivator {
    protected String contextPath;

    public KalixBundleActivator() {
        contextPath = (String) ConfigUtil.getConfigProp("path", "ConfigWebContext");

        if (contextPath.equals("/")) {
            contextPath = "";
        }
    }
}
