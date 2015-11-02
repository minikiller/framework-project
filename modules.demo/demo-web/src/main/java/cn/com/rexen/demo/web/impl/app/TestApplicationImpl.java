package cn.com.rexen.demo.web.impl.app;

import cn.com.rexen.core.api.web.IApplication;
import cn.com.rexen.core.api.web.IModule;
import cn.com.rexen.demo.web.Const;

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
        return Const.APPLICATION_NAME;
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
        return "";
    }

    @Override
    public int getIndex() {
        return 1;
    }

    @Override
    public String getPermission() {
        return "test";
    }

    @Override
    public String getTitle() {
        return "测试应用";
    }
}
