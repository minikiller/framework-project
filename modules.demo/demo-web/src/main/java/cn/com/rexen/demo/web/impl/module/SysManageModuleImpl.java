package cn.com.rexen.demo.web.impl.module;

import cn.com.rexen.core.api.web.IMenu;
import cn.com.rexen.core.api.web.IModule;
import cn.com.rexen.demo.web.Const;

import java.util.List;

/**
 * 流程管理
 */
public class SysManageModuleImpl implements IModule {
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
        return Const.SYS_MANAGE_MODULE_NAME;
    }

    @Override
    public String getText() {
        return "基本设置";
    }

    @Override
    public String getDescription() {
        return "基本设置";
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
        return 130;
    }

    @Override
    public String getPermission() {
        return Const.APPLICATION_NAME + ":" + getId();
    }

    @Override
    public String getIconCls() {
        return "fa fa-plug";
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
