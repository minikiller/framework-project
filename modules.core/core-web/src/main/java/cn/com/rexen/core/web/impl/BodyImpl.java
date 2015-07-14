package cn.com.rexen.core.web.impl;

import cn.com.rexen.core.api.web.IApplication;
import cn.com.rexen.core.api.web.IBody;
import org.apache.log4j.Logger;

import java.util.List;

/**
 * Created by sunlf on 2015/7/13.
 * 监听IApplication的注册和注销
 */
public class BodyImpl implements IBody {
    private static Logger logger = Logger.getLogger(BodyImpl.class);

    @Override
    public List<IApplication> getApplications() {
        return ApplicationManager.getInstall().getApplicationList();
    }

    public void register(IApplication application) {
        logger.info("application of " + application.getTitle() + " is regisered!");
        ApplicationManager.getInstall().add(application);
    }

    public void unregister(IApplication application) {
        logger.info("application of " + application.getTitle() + " is unregisered!");
        ApplicationManager.getInstall().remove(application);
    }
}
