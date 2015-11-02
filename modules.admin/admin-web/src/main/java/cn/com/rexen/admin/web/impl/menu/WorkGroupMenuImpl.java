package cn.com.rexen.admin.web.impl.menu;

import cn.com.rexen.core.api.web.IMenu;

/**
 * 工作组菜单
 * @author majian <br/>
 *         date:2015-8-10
 * @version 1.0.0
 */
public class WorkGroupMenuImpl implements IMenu {
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
        return "workGroupMenu";
    }

    @Override
    public String getText() {
        return "工作组管理";
    }

    @Override
    public String getDescription() {
        return null;
    }

    @Override
    public String getIcon() {
        return "admin/resources/images/cup.png";
    }

    @Override
    public String getRouteId() {
        return "admin/WorkGroup";
    }

    @Override
    public int getIndex() {
        return 2;
    }

    @Override
    public String getPermission() {
        return null;//"admin:sysModule:permissionControl:workGroupMenu";
    }

    @Override
    public String getIconCls() {
        return "x-fa fa-user-plus";
    }
}
