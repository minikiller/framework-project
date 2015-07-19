package cn.com.rexen.admin.web.impl;

import cn.com.rexen.core.api.web.IMenu;
import cn.com.rexen.core.api.web.IModule;

import java.util.List;

/**
 * Created by sunlf on 2015/7/19.
 */
public class AdminModuleImpl implements IModule {
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
        return "sysModule";
    }

    @Override
    public String getTitle() {
        return "系统管理";
    }

    @Override
    public String getDescription() {
        return "系统管理";
    }

    @Override
    public String getIcon() {
        return "resources/images/wrench.png";
    }

    @Override
    public String getComponentClass() {
        return null;
    }

    @Override
    public int getIndex() {
        return 0;
    }
}
