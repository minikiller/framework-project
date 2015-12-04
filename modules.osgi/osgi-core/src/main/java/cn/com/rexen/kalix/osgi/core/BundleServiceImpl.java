package cn.com.rexen.kalix.osgi.core;

import cn.com.rexen.kalix.osgi.api.IBundleService;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.framework.BundleException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author chenyanxu
 */
public class BundleServiceImpl implements IBundleService {
    private BundleContext bundleContext;
    //private BundleJsonStatus jsonStatus;
    private Map<String, Object> rtnMap;

    public BundleServiceImpl() {
        this.rtnMap = new HashMap<>();
    }

    @Override
    public Map start(String id) {
        this.rtnMap.clear();

        Bundle[] bundles = bundleContext.getBundles();

        for (int idx = 0; idx < bundles.length; ++idx) {
            if (bundles[idx].getSymbolicName().matches("\\S*" + id + ".web")) {
                try {
                    bundles[idx].start();
                    //jsonStatus = BundleJsonStatus.successResult("服务启动成功");
                    rtnMap.put("success", true);
                    rtnMap.put("msg", "服务启动成功");
                } catch (BundleException e) {
                    e.printStackTrace();
                    //jsonStatus = BundleJsonStatus.failureResult("服务启动失败");
                    rtnMap.put("success", false);
                    rtnMap.put("msg", "服务启动失败");
                }

                return rtnMap;
            }
        }

        rtnMap.put("success", false);
        rtnMap.put("msg", "服务启动失败");

        return rtnMap;
    }

    @Override
    public Map stop(String id) {
        this.rtnMap.clear();
        Bundle[] bundles = bundleContext.getBundles();

        for (int idx = 0; idx < bundles.length; ++idx) {
            if (bundles[idx].getSymbolicName().matches("\\S*" + id + ".web")) {
                try {
                    bundles[idx].stop();
                    //jsonStatus = BundleJsonStatus.successResult("服务停止成功");
                    rtnMap.put("success", true);
                    rtnMap.put("msg", "服务停止成功");
                } catch (BundleException e) {
                    e.printStackTrace();
                    //jsonStatus = BundleJsonStatus.failureResult("服务停止失败");
                    rtnMap.put("success", false);
                    rtnMap.put("msg", "服务停止失败");
                }

                return rtnMap;
            }
        }

        //jsonStatus.setAppStatus(null);
        rtnMap.put("success", false);
        rtnMap.put("msg", "服务异常");
        //return BundleJsonStatus.failureResult("服务异常");
        return rtnMap;
    }

    @Override
    public Map getAppStatus(String appIds) {
        this.rtnMap.clear();
        Bundle[] bundles = bundleContext.getBundles();
        String[] appIdArray = null;
        //Map<String, Boolean> appStatusMap = new HashMap<String, Boolean>();


        if (appIds != null) {
            appIdArray = appIds.split("_");

            for (int idx = 0; idx < appIdArray.length; ++idx) {
                for (int bundleIdx = 0; bundleIdx < bundles.length; ++bundleIdx) {
                    if (bundles[bundleIdx].getSymbolicName().matches("\\S*" + appIdArray[idx] + ".web")) {
                        if (bundles[bundleIdx].getState() == Bundle.ACTIVE) {
                            this.rtnMap.put(appIdArray[idx], true);
                            //appStatusMap.put(appIdArray[idx], true);
                        } else {
                            //appStatusMap.put(appIdArray[idx], false);
                            this.rtnMap.put(appIdArray[idx], false);
                        }

                        break;
                    }
                }
            }
        }

//        if (appStatusMap.size() > 0) {
//            jsonStatus = BundleJsonStatus.successResult("");
//            jsonStatus.setAppStatus(appStatusMap);
//        } else {
//            jsonStatus = BundleJsonStatus.failureResult("");
//            jsonStatus.setAppStatus(null);
//        }
        if (this.rtnMap.size() > 0) {
            this.rtnMap.put("success", true);
        } else {
            this.rtnMap.put("success", false);
        }

        return rtnMap;
    }


    public BundleContext getBundleContext() {
        return bundleContext;
    }

    public void setBundleContext(BundleContext bundleContext) {
        this.bundleContext = bundleContext;
    }
}
