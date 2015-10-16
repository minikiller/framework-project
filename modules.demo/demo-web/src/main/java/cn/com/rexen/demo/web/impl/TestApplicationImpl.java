package cn.com.rexen.demo.web.impl;

import cn.com.rexen.core.api.web.IApplication;
import cn.com.rexen.core.api.web.IModule;

import java.util.List;

/**
 * Created by sunlf on 2015/7/14.
 */
public class TestApplicationImpl implements IApplication {
    @Override
    public List<IModule> getModules() {
        return null;
    }

    @Override
    public String getId() {
        return "TestApplication";
    }

    @Override
    public String getText() {
        return "测试应用";
    }

    @Override
    public String getDescription() {
        return "测试应用";
    }

    @Override
    public String getIcon() {
        return "admin/resources/images/building.png";
    }

    @Override
    public String getRouteId() {
        return null;
    }

    @Override
    public int getIndex() {
        return 1;
    }

    @Override
    public String getPermission() {
        return "test";
    }
}
