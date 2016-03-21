package cn.com.rexen.core.web.listener;

import cn.com.rexen.core.api.web.IApplication;
import cn.com.rexen.core.web.manager.ApplicationManager;
import org.apache.log4j.Logger;

/**
 * Created by sunlf on 2015/7/18.
 */
public class ApplicationListener {
    private static Logger logger = Logger.getLogger(ApplicationListener.class);

    public void register(IApplication application) {
        logger.info("application of " + application.getText() + " is regisered!");
        ApplicationManager.getInstall().add(application);
    }

    public void unregister(IApplication application) {
        if (application != null) {
            logger.info("application of " + application.getText() + " is unregisered!");
            ApplicationManager.getInstall().remove(application);
        }

    }
}
