package cn.com.rexen.demo.web.impl;

import cn.com.rexen.core.api.web.IMenu;

/**
 * 流程演示菜单
 * @author majian <br/>
 *         date:2015-8-10
 * @version 1.0.0
 */
public class DemoWorkFlowMenuImpl implements IMenu {
    @Override
    public boolean isLeaf() {
        return false;
    }

    @Override
    public String getModuleId() {
        return "demoWorkFlowModule";
    }

    @Override
    public String getParentMenuId() {
        return null;
    }

    @Override
    public String getId() {
        return "demoWorkFlowMenu";
    }

    @Override
    public String getTitle() {
        return "流程演示";
    }

    @Override
    public String getDescription() {
        return null;
    }

    @Override
    public String getIcon() {
        return "app/resources/images/application.png";
    }

    @Override
    public String getComponentClass() {
        return null;
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
