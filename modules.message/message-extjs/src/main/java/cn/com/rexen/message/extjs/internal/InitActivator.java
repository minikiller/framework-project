package cn.com.rexen.message.extjs.internal;

import cn.com.rexen.core.api.osgi.KalixBundleActivator;
import cn.com.rexen.core.util.SystemUtil;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.service.http.HttpService;

/**
 * Created by sunlf on 14-3-23.
 */
public class InitActivator extends KalixBundleActivator {

    private static final String BUNDLE_NAME = " Kalix Message Extjs ";
    public static final String KALIX_APP_ROFFICE_PATH = "/kalix/app/message";
    public static final String KALIX_ROFFICE_RESOURCES_IMAGES = "/kalix/message/resources/images";
    private static BundleContext context;
    private ServiceReference reference;
    private HttpService httpService;

    @Override
    public void start(BundleContext bundleContext) throws Exception {
        SystemUtil.succeedPrintln(String.format("Start-up %s bundle!!", BUNDLE_NAME) + bundleContext.getBundle());
        context = bundleContext;

        reference = bundleContext.getServiceReference(HttpService.class.getName());
        httpService = (HttpService) bundleContext.getService(reference);
        httpService.registerResources(KALIX_APP_ROFFICE_PATH, "/message", null);
        httpService.registerResources(KALIX_ROFFICE_RESOURCES_IMAGES, "/resources/images", null);
    }

    @Override
    public void stop(BundleContext bundleContext) throws Exception {
        SystemUtil.succeedPrintln(String.format("Stop %s bundle!!", BUNDLE_NAME) + bundleContext.getBundle());
        context = null;
        if (httpService != null) {
            httpService.unregister(KALIX_APP_ROFFICE_PATH);
            httpService.unregister(KALIX_ROFFICE_RESOURCES_IMAGES);
        }
        if (reference != null)
            bundleContext.ungetService(reference);
    }
}
