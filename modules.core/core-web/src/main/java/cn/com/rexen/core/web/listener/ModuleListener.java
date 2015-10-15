package cn.com.rexen.core.web.listener;

import cn.com.rexen.core.api.web.IModule;
import cn.com.rexen.core.web.manager.ModuleManager;
import org.apache.log4j.Logger;

/**
 * Created by sunlf on 2015/7/18.
 */
public class ModuleListener {
    private static Logger logger = Logger.getLogger(ModuleListener.class);

    public void register(IModule module) {
        logger.info("module of " + module.getTitle() + " is regisered!");
        ModuleManager.getInstall().add(module);
    }

    public void unregister(IModule module) {
        logger.info("module of " + module.getTitle() + " is unregisered!");
        ModuleManager.getInstall().remove(module);
    }
}
