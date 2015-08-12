package cn.com.rexen.admin.web.impl;

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
        return "sysModule";
    }

    @Override
    public String getParentMenuId() {
        return "permissionControlMenu";
    }

    @Override
    public String getId() {
        return "functionMenu";
    }

    @Override
    public String getTitle() {
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
    public String getComponentClass() {
        return "Kalix.app.function.view.Function";
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
