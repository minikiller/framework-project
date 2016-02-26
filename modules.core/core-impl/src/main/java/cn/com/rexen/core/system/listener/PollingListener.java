package cn.com.rexen.core.system.listener;

import cn.com.rexen.core.api.system.IPolling;
import cn.com.rexen.core.system.manager.PollingManager;
import org.apache.log4j.Logger;

/**
 * Created by zangyanming on 2016/2/25.
 */
public class PollingListener {
    private static Logger logger = Logger.getLogger(PollingListener.class);

    public void register(IPolling polling) {
        logger.info("polling of " + polling.getId() + " is regisered!");
        PollingManager.getInstall().add(polling);
    }

    public void unregister(IPolling polling) {
        if (polling != null) {
            logger.info("polling of " + polling.getId() + " is unregisered!");
            PollingManager.getInstall().remove(polling);
        }

    }
}
