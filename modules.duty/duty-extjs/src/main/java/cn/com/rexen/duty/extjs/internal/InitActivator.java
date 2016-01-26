package cn.com.rexen.duty.extjs.internal;

import cn.com.rexen.core.api.osgi.KalixBundleActivator;
import cn.com.rexen.core.util.SystemUtil;
import org.apache.log4j.Logger;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.service.http.HttpService;
/**
 * Created by sunlf on 14-3-23.
 */
public class InitActivator extends KalixBundleActivator {

    private static final String BUNDLE_NAME = " Duty Duty Extjs ";
    public static final String KALIX_APP_ROFFICE_PATH = "/kalix/app/duty";
    public static final String KALIX_ROFFICE_RESOURCES_IMAGES = "/kalix/duty/resources/images";
    private static BundleContext context;
    private static Logger logger = Logger.getLogger(InitActivator.class);
    private ServiceReference reference;
    private HttpService httpService;

    @Override
    public void start(BundleContext bundleContext) throws Exception {
        SystemUtil.succeedPrintln(String.format("Start-up %s bundle!!", BUNDLE_NAME) + bundleContext.getBundle());
        context = bundleContext;

        reference = bundleContext.getServiceReference(HttpService.class.getName());
        httpService = (HttpService) bundleContext.getService(reference);
        httpService.registerResources(contextPath +"/app/app/duty", "/app/duty", null);
        httpService.registerResources(contextPath +"/app/duty/resources/images", "/resources/images", null);
    }

    @Override
    public void stop(BundleContext bundleContext) throws Exception {
        SystemUtil.succeedPrintln(String.format("Stop %s bundle!!", BUNDLE_NAME) + bundleContext.getBundle());
        context = null;
        if(httpService!=null){
            httpService.unregister(contextPath +"/app/app/duty");
            httpService.unregister(contextPath +"/app/duty/resources/images");
        }
        if (reference != null)
                    bundleContext.ungetService(reference);
    }
}
