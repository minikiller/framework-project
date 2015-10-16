package cn.com.rexen.admin.web.impl;

import cn.com.rexen.core.api.web.IMenu;

/**
 * 机构菜单
 * @author majian <br/>
 *         date:2015-8-10
 * @version 1.0.0
 */
public class OrganizationMenuImpl implements IMenu {
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
        return "systemConstantMenu";
    }

    @Override
    public String getId() {
        return "organizationMenu";
    }

    @Override
    public String getText() {
        return "机构管理";
    }

    @Override
    public String getDescription() {
        return null;
    }

    @Override
    public String getIcon() {
        return "admin/resources/images/script.png";
    }

    @Override
    public String getRouteId() {
        return "AdminApplication/Org";
    }

    @Override
    public int getIndex() {
        return 0;
    }

    @Override
    public String getPermission() {
        return "admin:sysModule:systemConstantMenu:organizationMenu";
    }
}
