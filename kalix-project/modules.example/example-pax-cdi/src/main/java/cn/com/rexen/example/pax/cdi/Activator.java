package cn.com.rexen.example.pax.cdi;


import org.dozer.DozerInitializer;
import org.dozer.config.BeanContainer;
import org.dozer.osgi.OSGiClassLoader;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

/**
 * Created by sunlf on 2015/7/21.
 */
public class Activator implements BundleActivator {
//    private final Logger log = LoggerFactory.getLogger(Activator.class);

    public Activator() {
    }

    public void start(BundleContext bundleContext) throws Exception {
//        this.log.info("Starting Dozer OSGi bundle");
        /*OSGiClassLoader classLoader = new OSGiClassLoader(bundleContext);
        BeanContainer.getInstance().setClassLoader(classLoader);*/
//        DozerInitializer.getInstance().init(Activator.class.getClassLoader());
    }

    public void stop(BundleContext bundleContext) throws Exception {
//        this.log.info("Dozer OSGi bundle stopped");
    }
}