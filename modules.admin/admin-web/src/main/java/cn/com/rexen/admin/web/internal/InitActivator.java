package cn.com.rexen.admin.web.internal;

import cn.com.rexen.core.util.SystemUtil;
import org.apache.log4j.Logger;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.service.http.HttpService;

/**
 * Created by sunlf on 14-3-23.
 */
public class InitActivator implements BundleActivator {

    private static final String BUNDLE_NAME = " Kalix Admin Web ";
    private static BundleContext context;
    private static Logger logger = Logger.getLogger(InitActivator.class);
    private ServiceReference reference;

    @Override
    public void start(BundleContext bundleContext) throws Exception {
        SystemUtil.succeedPrintln(String.format("Start-up %s bundle!!", BUNDLE_NAME));
        context = bundleContext;

        reference = bundleContext.getServiceReference(HttpService.class.getName());
        HttpService httpService = (HttpService) bundleContext.getService(reference);
        httpService.registerResources("/kalix/app/admin", "/admin", null);
        httpService.registerResources("/kalix/admin/resources/images", "/resources/images", null);
    }

    @Override
    public void stop(BundleContext bundleContext) throws Exception {
        SystemUtil.succeedPrintln(String.format("Stop %s bundle!!", BUNDLE_NAME));

        if (reference != null)
            bundleContext.ungetService(reference);
        context = null;
    }
}
