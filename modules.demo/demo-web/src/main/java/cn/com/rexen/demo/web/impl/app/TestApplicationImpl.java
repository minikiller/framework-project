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
        return "办公自动化";
    }

    @Override
    public String getDescription() {
        return "办公自动化";
    }

    @Override
    public String getIcon() {
        return "iconfont icon-oa";
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
        return Const.APPLICATION_NAME;
    }

    @Override
    public String getTitle() {
        return "办公自动化";
    }
}
