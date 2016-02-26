package cn.com.rexen.bean.core.system;

import cn.com.rexen.core.api.system.IPollingService;

/**
 * Created by zangyanming on 2016/2/25.
 */
public class MessagePollingServiceImpl implements IPollingService {
    @Override
    public String getId() {
        return "MessagePolling";
    }

    @Override
    public String getType() {
        return "workflow-message";
    }

    @Override
    public int getInterval() {
        return 10000;
    }

    @Override
    public String getUrl() {
        return "camel/rest/messages/workflow/message";
    }

    @Override
    public boolean isStop() {
        return false;
    }

    @Override
    public String getCallbackHandler() {
        return "onWorkflowMsg";
    }
}
