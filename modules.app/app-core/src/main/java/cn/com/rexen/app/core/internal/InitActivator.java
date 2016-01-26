package cn.com.rexen.app.core.internal;

import cn.com.rexen.app.core.PluginBundleHandler;
import cn.com.rexen.core.util.SystemUtil;
import org.apache.log4j.Logger;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.BundleEvent;
import org.osgi.util.tracker.BundleTracker;

/**
 * Created by sunlf on 14-3-23.
 */
public class InitActivator implements BundleActivator {

    private static final String BUNDLE_NAME = " Kalix App Core ";
    private static BundleContext context;
    private static Logger logger = Logger.getLogger(InitActivator.class);
    private BundleTracker bundleTracker;

    @Override
    public void start(BundleContext bundleContext) throws Exception {
        SystemUtil.succeedPrintln(String.format("Start-up %s bundle!!", BUNDLE_NAME) + bundleContext.getBundle());
        context = bundleContext;
        bundleTracker = new BundleTracker(context, Bundle.ACTIVE | Bundle.RESOLVED, null) {
            @Override
            public Object addingBundle(Bundle bundle, BundleEvent event) {
                logger.info(String.format("adding bundle {0} {1}", bundle.getSymbolicName(), bundle));
                PluginBundleHandler.processBundle(bundle);
                return null;
            }
        };
        bundleTracker.open();
    }

    @Override
    public void stop(BundleContext bundleContext) throws Exception {
        SystemUtil.succeedPrintln(String.format("Stop %s bundle!!", BUNDLE_NAME) + bundleContext.getBundle());
        context = null;
        bundleTracker.close();
    }
}
