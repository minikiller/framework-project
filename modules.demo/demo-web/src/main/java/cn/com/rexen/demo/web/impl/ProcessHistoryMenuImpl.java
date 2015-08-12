package cn.com.rexen.demo.web.impl;

import cn.com.rexen.core.api.web.IMenu;

/**
 * 流程历史列表
 * @author majian <br/>
 *         date:2015-8-10
 * @version 1.0.0
 */
public class ProcessHistoryMenuImpl implements IMenu {
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
        return "processHistoryMenu";
    }

    @Override
    public String getTitle() {
        return "流程历史列表";
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
    public String getComponentClass() {
        return "Kalix.workflow.view.ProcessHistory";
    }

    @Override
    public int getIndex() {
        return 0;
    }

    @Override
    public String getPermission() {
        return null;
    }
}
