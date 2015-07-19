package cn.com.rexen.admin.web.impl;

import cn.com.rexen.core.api.web.IMenu;

/**
 * Created by sunlf on 2015/7/19.
 * 权限控制菜单
 */
public class PermissionControlMenuImpl implements IMenu {
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
        return "permissionControlMenu";
    }

    @Override
    public String getTitle() {
        return "权限控制";
    }

    @Override
    public String getDescription() {
        return null;
    }

    @Override
    public String getIcon() {
        return "admin/resources/images/lock.png";
    }

    @Override
    public String getComponentClass() {
        return null;
    }

    @Override
    public int getIndex() {
        return 0;
    }
}
