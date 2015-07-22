package cn.com.rexen.core.swagger.internal;

import cn.com.rexen.core.util.SystemUtil;
import org.apache.log4j.Logger;
import org.apache.shiro.web.env.EnvironmentLoaderListener;
import org.ops4j.pax.web.service.WebContainer;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.service.http.HttpContext;

/**
 * Created by sunlf on 14-3-23.
 */
public class InitActivator implements BundleActivator {

    private static final String BUNDLE_NAME = " Kalix Core Swagger ";
    private static BundleContext context;
    private static Logger logger = Logger.getLogger(InitActivator.class);

    @Override
    public void start(BundleContext bundleContext) throws Exception {
        SystemUtil.succeedPrintln(String.format("Start-up %s bundle!!", BUNDLE_NAME));
        ServiceReference<WebContainer> serviceReference = bundleContext.getServiceReference(WebContainer.class);
        WebContainer webContainer = bundleContext.getService(serviceReference);
        HttpContext httpContext=webContainer.createDefaultHttpContext();
        webContainer.registerEventListener(new EnvironmentLoaderListener(),httpContext);
        context = bundleContext;
    }

    @Override
    public void stop(BundleContext bundleContext) throws Exception {
        SystemUtil.succeedPrintln(String.format("Stop %s bundle!!", BUNDLE_NAME));
        context = null;
    }
}
