package cn.com.rexen.kalix.osgi.core;

import cn.com.rexen.kalix.osgi.api.BundleJsonStatus;
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
    private BundleJsonStatus jsonStatus;

    @Override
    public BundleJsonStatus start(String id) {
        Bundle[] bundles = bundleContext.getBundles();


        for (int idx = 0; idx < bundles.length; ++idx) {
            if (bundles[idx].getSymbolicName().matches("\\S*" + id + ".web")) {
                try {
                    bundles[idx].start();
                    jsonStatus = BundleJsonStatus.successResult("服务启动成功");
                } catch (BundleException e) {
                    e.printStackTrace();
                    jsonStatus = BundleJsonStatus.failureResult("服务启动失败");
                }

                return jsonStatus;
            }
        }

        jsonStatus.setAppStatus(null);

        return BundleJsonStatus.failureResult("服务异常");
    }

    @Override
    public BundleJsonStatus stop(String id) {
        Bundle[] bundles = bundleContext.getBundles();

        for (int idx = 0; idx < bundles.length; ++idx) {
            if (bundles[idx].getSymbolicName().matches("\\S*" + id + ".web")) {
                try {
                    bundles[idx].stop();
                    jsonStatus = BundleJsonStatus.successResult("服务停止成功");
                } catch (BundleException e) {
                    e.printStackTrace();
                    jsonStatus = BundleJsonStatus.failureResult("服务停止失败");
                }

                return jsonStatus;
            }
        }

        jsonStatus.setAppStatus(null);

        return BundleJsonStatus.failureResult("服务异常");
    }

    @Override
    public BundleJsonStatus getAppStatus(String appIds) {
        Bundle[] bundles = bundleContext.getBundles();
        String[] appIdArray = null;
        Map<String, Boolean> appStatusMap = new HashMap<String, Boolean>();


        if (appIds != null) {
            appIdArray = appIds.split("_");

            for (int idx = 0; idx < appIdArray.length; ++idx) {
                for (int bundleIdx = 0; bundleIdx < bundles.length; ++bundleIdx) {
                    if (bundles[bundleIdx].getSymbolicName().matches("\\S*" + appIdArray[idx] + ".web")) {
                        if (bundles[bundleIdx].getState() == Bundle.ACTIVE) {
                            appStatusMap.put(appIdArray[idx], true);
                        } else {
                            appStatusMap.put(appIdArray[idx], false);
                        }

                        break;
                    }
                }
            }
        }

        if (appStatusMap.size() > 0) {
            jsonStatus = BundleJsonStatus.successResult("");
            jsonStatus.setAppStatus(appStatusMap);
        } else {
            jsonStatus = BundleJsonStatus.failureResult("");
            jsonStatus.setAppStatus(null);
        }

        return jsonStatus;
    }


    public BundleContext getBundleContext() {
        return bundleContext;
    }

    public void setBundleContext(BundleContext bundleContext) {
        this.bundleContext = bundleContext;
    }
}
