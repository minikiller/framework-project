package cn.com.rexen.admin.web.impl;

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
        return "sysModule";
    }

    @Override
    public String getParentMenuId() {
        return "permissionControlMenu";
    }

    @Override
    public String getId() {
        return "workGroupMenu";
    }

    @Override
    public String getTitle() {
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
    public String getComponentClass() {
        return "Kalix.admin.workGroup.view.WorkGroup";
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
