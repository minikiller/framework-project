package cn.com.rexen.kalix.osgi.api;

/**
 * Created by lenovo on 2015/11/30.
 */
public interface IBundleControllerService {
    void start(String id);

    void stop(String id);
}