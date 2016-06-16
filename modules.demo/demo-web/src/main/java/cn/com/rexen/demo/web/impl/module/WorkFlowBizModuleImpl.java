package cn.com.rexen.demo.web.impl.module;

import cn.com.rexen.core.api.web.IMenu;
import cn.com.rexen.core.api.web.IModule;
import cn.com.rexen.demo.web.Const;

import java.util.List;

/**
 * 业务流程模块
 */
public class WorkFlowBizModuleImpl implements IModule {
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
        return Const.WORKFLOW_BIZ_MODULE_NAME;
    }

    @Override
    public String getText() {
        return "业务流程";
    }

    @Override
    public String getDescription() {
        return "业务流程";
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
//        return Const.APPLICATION_NAME + ":" + getId();
        return "";
    }

    @Override
    public String getIconCls() {
        return "iconfont icon-process-definition";
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
