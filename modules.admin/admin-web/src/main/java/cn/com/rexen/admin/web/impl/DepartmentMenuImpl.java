package cn.com.rexen.admin.web.impl;

import cn.com.rexen.core.api.web.IMenu;

/**
 * 部门菜单
 * @author majian <br/>
 *         date:2015-8-10
 * @version 1.0.0
 */
public class DepartmentMenuImpl implements IMenu {
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
        return "departmentMenu";
    }

    @Override
    public String getTitle() {
        return "部门管理";
    }

    @Override
    public String getDescription() {
        return null;
    }

    @Override
    public String getIcon() {
        return "admin/resources/images/building.png";
    }

    @Override
    public String getComponentClass() {
        return "Kalix.admin.dep.view.Dep";
    }

    @Override
    public int getIndex() {
        return 0;
    }
}
