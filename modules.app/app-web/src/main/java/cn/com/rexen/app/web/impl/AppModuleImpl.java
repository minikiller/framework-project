package cn.com.rexen.app.web.impl;

import cn.com.rexen.core.api.web.IMenu;
import cn.com.rexen.core.api.web.IModule;

import java.util.List;

/**
 * Created by sunlf on 2015/7/19.
 */
public class AppModuleImpl implements IModule {
    @Override
    public List<IMenu> getMenus() {
        return null;
    }

    @Override
    public String getApplicationId() {
        return "AdminApplication";
    }

    @Override
    public String getId() {
        return "appModule";
    }

    @Override
    public String getTitle() {
        return "模块管理";
    }

    @Override
    public String getDescription() {
        return "模块管理";
    }

    @Override
    public String getIcon() {
        return "resources/images/computer.png";
    }

    @Override
    public String getComponentClass() {
        return null;
    }

    @Override
    public int getIndex() {
        return 1;
    }

    @Override
    public String getPermission() {
        return "admin:appModule";
    }
}
