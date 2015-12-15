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
    private Map<String, Object> resultMap;

    public BundleServiceImpl() {
        this.resultMap = new HashMap<>();
    }

    @Override
    public Map start(String id) {
        this.resultMap.clear();
        Bundle[] bundles = bundleContext.getBundles();

        for (int idx = 0; idx < bundles.length; ++idx) {
            if (bundles[idx].getSymbolicName().matches("\\S*" + id + ".web")) {
                try {
                    bundles[idx].start();
                    //jsonStatus = BundleJsonStatus.successResult("服务启动成功");
                    resultMap.put("success", true);
                    resultMap.put("msg", "服务启动成功");
                } catch (BundleException e) {
                    e.printStackTrace();
                    //jsonStatus = BundleJsonStatus.failureResult("服务启动失败");
                    resultMap.put("success", false);
                    resultMap.put("msg", "服务启动失败");
                }

                return resultMap;
            }
        }

        resultMap.put("success", false);
        resultMap.put("msg", "服务启动失败");

        return resultMap;
    }

    @Override
    public Map stop(String id) {
        this.resultMap.clear();
        Bundle[] bundles = bundleContext.getBundles();

        for (int idx = 0; idx < bundles.length; ++idx) {
            if (bundles[idx].getSymbolicName().matches("\\S*" + id + ".web")) {
                try {
                    bundles[idx].stop();
                    //jsonStatus = BundleJsonStatus.successResult("服务停止成功");
                    resultMap.put("success", true);
                    resultMap.put("msg", "服务停止成功");
                } catch (BundleException e) {
                    e.printStackTrace();
                    //jsonStatus = BundleJsonStatus.failureResult("服务停止失败");
                    resultMap.put("success", false);
                    resultMap.put("msg", "服务停止失败");
                }

                return resultMap;
            }
        }

        //jsonStatus.setAppStatus(null);
        resultMap.put("success", false);
        resultMap.put("msg", "服务异常");
        //return BundleJsonStatus.failureResult("服务异常");
        return resultMap;
    }

    @Override
    public Map getAppStatus(String appIds) {
        this.resultMap.clear();
        Bundle[] bundles = bundleContext.getBundles();
        String[] appIdArray = null;
        //Map<String, Boolean> appStatusMap = new HashMap<String, Boolean>();


        if (appIds != null) {
            appIdArray = appIds.split("_");

            for (int idx = 0; idx < appIdArray.length; ++idx) {
                for (int bundleIdx = 0; bundleIdx < bundles.length; ++bundleIdx) {
                    if (bundles[bundleIdx].getSymbolicName().matches("\\S*" + appIdArray[idx] + ".web")) {
                        if (bundles[bundleIdx].getState() == Bundle.ACTIVE) {
                            this.resultMap.put(appIdArray[idx], true);
                            //appStatusMap.put(appIdArray[idx], true);
                        } else {
                            //appStatusMap.put(appIdArray[idx], false);
                            this.resultMap.put(appIdArray[idx], false);
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
        if (this.resultMap.size() > 0) {
            this.resultMap.put("success", true);
        } else {
            this.resultMap.put("success", false);
        }

        return resultMap;
    }

    public void setBundleContext(BundleContext bundleContext) {
        this.bundleContext = bundleContext;
    }
}
