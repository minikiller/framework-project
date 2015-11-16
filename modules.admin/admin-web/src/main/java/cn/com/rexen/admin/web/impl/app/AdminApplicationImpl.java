package cn.com.rexen.admin.web.impl.app;

import cn.com.rexen.admin.web.impl.Const;
import cn.com.rexen.core.api.web.IApplication;
import cn.com.rexen.core.api.web.IModule;

import java.util.List;

/**
 * Created by sunlf on 2015/7/14.
 */
public class AdminApplicationImpl implements IApplication {
    @Override
    public List<IModule> getModules() {
        return null;
    }

    @Override
    public String getId() {
        return Const.APP_NAME;
    }

    @Override
    public String getText() {
        return "系统应用";
    }

    @Override
    public String getDescription() {
        return "统一用户管理";
    }

    @Override
    public String getIcon() {
        return "resources/images/cog.png";
    }

    @Override
    public String getRouteId() {
        return "";
    }

    @Override
    public int getIndex() {
        return 0;
    }

    @Override
    public String getPermission() {
        return Const.APP_NAME;
    }

    @Override
    public String getTitle() {
        return "系统应用";
    }
}
