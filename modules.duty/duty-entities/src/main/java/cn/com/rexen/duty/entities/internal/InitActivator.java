package cn.com.rexen.duty.entities.internal;

import cn.com.rexen.core.util.SystemUtil;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

/**
 * Created by sunlf on 14-3-23.
 */
public class InitActivator implements BundleActivator {

    private static final String BUNDLE_NAME = " Admin Duty Entities ";

    @Override
    public void start(BundleContext bundleContext) throws Exception {
        SystemUtil.succeedPrintln(String.format("Start-up %s bundle!!", BUNDLE_NAME) + bundleContext.getBundle());
    }

    @Override
    public void stop(BundleContext bundleContext) throws Exception {
        SystemUtil.succeedPrintln(String.format("Stop %s bundle!!", BUNDLE_NAME) + bundleContext.getBundle());
    }
}
