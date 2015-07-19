package cn.com.rexen.core.web.listener;

import cn.com.rexen.core.api.web.IMenu;
import org.apache.log4j.Logger;

/**
 * Created by sunlf on 2015/7/18.
 */
public class MenuListener {
    private static Logger logger = Logger.getLogger(MenuListener.class);

    public void register(IMenu menu) {
        logger.info("menu of " + menu.getTitle() + " is regisered!");
        MenuManager.getInstall().add(menu);
    }

    public void unregister(IMenu menu) {
        logger.info("menu of " + menu.getTitle() + " is unregisered!");
        MenuManager.getInstall().remove(menu);
    }
}
