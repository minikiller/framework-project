package cn.com.rexen.kalix.osgi.core;

import cn.com.rexen.demo.web.impl.app.TestApplicationImpl;
import cn.com.rexen.kalix.osgi.api.IBundleControllerService;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleException;
import org.osgi.framework.FrameworkUtil;

/**
 * Created by lenovo on 2015/11/30.
 */
public class BundleControllerServiceImpl implements IBundleControllerService {
    @Override
    public void start(Class cls) {
    }

    @Override
    public void stop(Class cls) {
        Bundle bundle = FrameworkUtil.getBundle(TestApplicationImpl.class);

        try {
            bundle.stop();
        } catch (BundleException e) {
            e.printStackTrace();
        }

    }
}
