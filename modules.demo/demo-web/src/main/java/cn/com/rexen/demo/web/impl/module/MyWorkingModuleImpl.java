package cn.com.rexen.demo.web.impl.module;

import cn.com.rexen.core.api.web.IMenu;
import cn.com.rexen.core.api.web.IModule;
import cn.com.rexen.demo.web.Const;

import java.util.List;

/**
 * 我的流程
 */
public class MyWorkingModuleImpl implements IModule {
    @Override
    public List<IMenu> getMenus() {
        return null;
    }

    @Override
    public String getApplicationId() {
        return Const.APPLICATION_NAME;
    }

    @Override
    public String getId() {
        return Const.MY_WORKING_MODULE_NAME;
    }

    @Override
    public String getText() {
        return "我的流程";
    }

    @Override
    public String getDescription() {
        return "我的流程";
    }

    @Override
    public String getIcon() {
        return "resources/images/wrench.png";
    }

    @Override
    public String getRouteId() {
        return null;
    }

    @Override
    public int getIndex() {
        return 10;
    }

    @Override
    public String getPermission() {
//        return Const.APPLICATION_NAME + ":" + getId();
        return "";
    }

    @Override
    public String getIconCls() {
        return "right-icon x-fa fa-desktop";
    }

    @Override
    public boolean isExpanded() {
        return false;
    }

    @Override
    public boolean isSelectable() {
        return false;
    }
}
