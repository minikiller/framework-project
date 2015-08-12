package cn.com.rexen.admin.web.impl;

import cn.com.rexen.core.api.web.IMenu;

/**
 * 角色菜单
 * @author majian <br/>
 *         date:2015-8-10
 * @version 1.0.0
 */
public class RoleMenuImpl implements IMenu {
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
        return "roleMenu";
    }

    @Override
    public String getTitle() {
        return "角色管理";
    }

    @Override
    public String getDescription() {
        return null;
    }

    @Override
    public String getIcon() {
        return "admin/resources/images/user.png";
    }

    @Override
    public String getComponentClass() {
        return "Kalix.admin.role.view.Role";
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
