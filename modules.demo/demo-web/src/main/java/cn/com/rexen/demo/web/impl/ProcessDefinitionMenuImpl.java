package cn.com.rexen.demo.web.impl;

import cn.com.rexen.core.api.web.IMenu;

/**
 * 流程定义菜单
 * @author majian <br/>
 *         date:2015-8-10
 * @version 1.0.0
 */
public class ProcessDefinitionMenuImpl implements IMenu {
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
        return "processDefinitionMenu";
    }

    @Override
    public String getText() {
        return "流程定义管理";
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
        return "Kalix.workflow.view.ProcessDefinition";
    }

    @Override
    public int getIndex() {
        return 0;
    }

    @Override
    public String getPermission() {
        return "test:demoWorkFlowModule:demoWorkFlowMenu:processDefinitionMenu";
    }
}
