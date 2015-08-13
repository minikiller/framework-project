package cn.com.rexen.admin.web.impl;

import cn.com.rexen.core.api.web.IMenu;

/**
 * 系统常量菜单
 * @author majian <br/>
 *         date:2015-8-10
 * @version 1.0.0
 */
public class SystemConstantMenuImpl implements IMenu {
    @Override
    public boolean isLeaf() {
        return false;
    }

    @Override
    public String getModuleId() {
        return "sysModule";
    }

    @Override
    public String getParentMenuId() {
        return null;
    }

    @Override
    public String getId() {
        return "systemConstantMenu";
    }

    @Override
    public String getTitle() {
        return "系统常量";
    }

    @Override
    public String getDescription() {
        return null;
    }

    @Override
    public String getIcon() {
        return "admin/resources/images/bricks.png";
    }

    @Override
    public String getComponentClass() {
        return null;
    }

    @Override
    public int getIndex() {
        return 1;
    }

    @Override
    public String getPermission() {
        return "admin:sysModule:systemConstantMenu";
    }
}
