package cn.com.rexen.demo.web.impl.module;

import cn.com.rexen.core.api.web.IMenu;
import cn.com.rexen.core.api.web.IModule;
import cn.com.rexen.demo.web.Const;

import java.util.List;

/**
 * 工作流演示
 */
public class WorkFlowModuleImpl implements IModule {
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
        return Const.MODULE_NAME;
    }

    @Override
    public String getText() {
        return "工作流演示";
    }

    @Override
    public String getDescription() {
        return "工作流演示";
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
        return 0;
    }

    @Override
    public String getPermission() {
        return Const.APPLICATION_NAME + ":" + getId();
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
