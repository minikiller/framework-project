package cn.com.rexen.kalix.osgi.api;

/**
 * @author chenyanxu
 */
public interface IBundleService {
    BundleJsonStatus start(String id);

    BundleJsonStatus stop(String id);

    BundleJsonStatus getAppStatus(String appIds);//connect by '_'
}
