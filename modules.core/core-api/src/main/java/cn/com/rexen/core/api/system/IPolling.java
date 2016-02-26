package cn.com.rexen.core.api.system;

/**
 * Created by zangyanming on 2016/2/25.
 */
public interface IPolling {
    String getId();

    String getType();

    int getInterval();

    String getUrl();

    boolean isStop();

    String getCallbackHandler();
}
