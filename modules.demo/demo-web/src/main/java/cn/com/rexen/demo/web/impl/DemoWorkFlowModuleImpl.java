package cn.com.rexen.demo.web.impl;

import cn.com.rexen.core.api.web.IMenu;
import cn.com.rexen.core.api.web.IModule;

import java.util.List;

/**
 * 工作流演示
 */
public class DemoWorkFlowModuleImpl implements IModule {
    @Override
    public List<IMenu> getMenus() {
        return null;
    }

    @Override
    public String getApplicationId() {
        return "TestApplication";
    }

    @Override
    public String getId() {
        return "demoWorkFlowModule";
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
        return "test:demoWorkFlowModule";
    }
}
