package cn.com.rexen.app.web.impl;

import cn.com.rexen.core.api.web.IMenu;

/**
 * 功能菜单
 * @author majian <br/>
 *         date:2015-8-10
 * @version 1.0.0
 */
public class FunctionMenuImpl implements IMenu {
    @Override
    public boolean isLeaf() {
        return true;
    }

    @Override
    public String getModuleId() {
        return "appModule";
    }

    @Override
    public String getParentMenuId() {
        return "appControlMenu";
    }

    @Override
    public String getId() {
        return "functionMenu";
    }

    @Override
    public String getText() {
        return "功能管理";
    }

    @Override
    public String getDescription() {
        return null;
    }

    @Override
    public String getIcon() {
        return "app/resources/images/note.png";
    }

    @Override
    public String getRouteId() {
        return "Kalix.app.function.view.Function";
    }

    @Override
    public int getIndex() {
        return 1;
    }

    @Override
    public String getPermission() {
        return "admin:appModule:appControlMenu:functionMenu";
    }
}
