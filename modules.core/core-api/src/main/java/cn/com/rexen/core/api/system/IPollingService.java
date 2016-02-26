package cn.com.rexen.core.api.system;

import cn.com.rexen.core.api.IService;

/**
 * Created by zangyanming on 2016/2/25.
 * 轮询服务接口
 */
public interface IPollingService extends IService {
    String getId();

    String getType();

    int getInterval();

    String getUrl();

    boolean isStop();

    String getCallbackHandler();
}
