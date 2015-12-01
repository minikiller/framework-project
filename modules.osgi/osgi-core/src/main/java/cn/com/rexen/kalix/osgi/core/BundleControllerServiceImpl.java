package cn.com.rexen.kalix.osgi.core;

import cn.com.rexen.core.util.JNDIHelper;
import cn.com.rexen.core.util.OsgiUtil;
import cn.com.rexen.demo.web.impl.app.TestApplicationImpl;
import cn.com.rexen.kalix.osgi.api.IBundleControllerService;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.framework.BundleException;
import org.osgi.framework.FrameworkUtil;
import org.osgi.service.blueprint.container.BlueprintContainer;

import java.io.Console;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by lenovo on 2015/11/30.
 */
public class BundleControllerServiceImpl implements IBundleControllerService {
    public BundleContext bundleContext;



    @Override
    public void start(String id) {
    }

    @Override
    public void stop(String id) {
        Bundle[] bundles = bundleContext.getBundles();


        System.out.println("1111");
        //bd.get
//        try {
//            Map<String, String> map=new HashMap<String,String>();
//            BundleContext xx=
//            map.put("id","admin");
//
//          Object obj=  JNDIHelper.getJNDIServiceForName("cn.com.rexen.core.api.web.IApplication",map);
//
//          obj=null;
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        // Bundle bundle = FrameworkUtil.get
//
//        try {
//            JNDIHelper.getJNDIServiceForName("11");
//            //bundle.stop();
//        } catch (BundleException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

    }

    public BundleContext getBundleContext() {
        return bundleContext;
    }

    public void setBundleContext(BundleContext bundleContext) {
        this.bundleContext = bundleContext;
    }
}
