package cn.com.rexen.admin.web.impl.menu;

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
        return "permissionModule";
    }

    @Override
    public String getParentMenuId() {
        return null;
    }

    @Override
    public String getId() {
        return "userMenu";
    }

    @Override
    public String getText() {
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
    public String getRouteId() {
        return "AdminApplication/User";
    }

    @Override
    public int getIndex() {
        return 0;
    }

    @Override
    public String getPermission() {
        return null;//"admin:sysModule:permissionControl:userMenu";
    }

    @Override
    public String getIconCls() {
        return "x-fa fa-user";
    }
}
