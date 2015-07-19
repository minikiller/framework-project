package cn.com.rexen.admin.web.impl;

import cn.com.rexen.core.api.web.IMenu;

/**
 * Created by sunlf on 2015/7/19.
 * 权限控制菜单
 */
public class UserMenuImpl implements IMenu {
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
        return "userMenu";
    }

    @Override
    public String getTitle() {
        return "用户管理";
    }

    @Override
    public String getDescription() {
        return null;
    }

    @Override
    public String getIcon() {
        return "admin/resources/images/group.png";
    }

    @Override
    public String getComponentClass() {
        return "Kalix.admin.user.view.User";
    }

    @Override
    public int getIndex() {
        return 0;
    }
}
