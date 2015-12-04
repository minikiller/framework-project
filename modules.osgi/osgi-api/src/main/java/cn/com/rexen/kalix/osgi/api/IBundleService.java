package cn.com.rexen.kalix.osgi.api;

import java.util.Map;

/**
 * @author chenyanxu
 */
public interface IBundleService {
    Map start(String id);

    Map stop(String id);

    Map getAppStatus(String appIds);//connect by '_'
}
