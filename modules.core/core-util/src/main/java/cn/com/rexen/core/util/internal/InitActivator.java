package cn.com.rexen.core.util.internal;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

/**
 * @类描述：osgi的初始化类
 * @创建人： sunlingfeng
 * @创建时间：2014/12/17
 * @修改人：
 * @修改时间：
 * @修改备注：
 */
public class InitActivator implements BundleActivator {

    private static BundleContext context;

    /**
     * @return
     */
    public static BundleContext getBundleContext() {
        return context;
    }

    @Override
    public void start(BundleContext bundleContext) throws Exception {
        context = bundleContext;
    }

    @Override
    public void stop(BundleContext bundleContext) throws Exception {
        context = null;
    }
}
