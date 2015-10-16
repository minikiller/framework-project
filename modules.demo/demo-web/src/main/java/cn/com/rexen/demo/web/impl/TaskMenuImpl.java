package cn.com.rexen.demo.web.impl;

import cn.com.rexen.core.api.web.IMenu;

/**
 * 待办任务列表
 * @author majian <br/>
 *         date:2015-8-10
 * @version 1.0.0
 */
public class TaskMenuImpl implements IMenu {
    @Override
    public boolean isLeaf() {
        return true;
    }

    @Override
    public String getModuleId() {
        return "demoWorkFlowModule";
    }

    @Override
    public String getParentMenuId() {
        return "demoWorkFlowMenu";
    }

    @Override
    public String getId() {
        return "taskMenu";
    }

    @Override
    public String getText() {
        return "待办任务列表";
    }

    @Override
    public String getDescription() {
        return null;
    }

    @Override
    public String getIcon() {
        return "admin/resources/images/building.png";
    }

    @Override
    public String getRouteId() {
        return "Kalix.workflow.view.Task";
    }

    @Override
    public int getIndex() {
        return 0;
    }

    @Override
    public String getPermission() {
        return "test:demoWorkFlowModule:demoWorkFlowMenu:taskMenu";
    }
}
