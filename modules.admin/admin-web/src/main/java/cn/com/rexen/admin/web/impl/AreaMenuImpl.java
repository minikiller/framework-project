package cn.com.rexen.admin.web.impl;

import cn.com.rexen.core.api.web.IMenu;

/**
 * 区域菜单
 * @author majian <br/>
 *         date:2015-8-10
 * @version 1.0.0
 */
public class AreaMenuImpl implements IMenu {
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
        return "areaMenu";
    }

    @Override
    public String getTitle() {
        return "区域管理";
    }

    @Override
    public String getDescription() {
        return null;
    }

    @Override
    public String getIcon() {
        return "admin/resources/images/shape_square.png";
    }

    @Override
    public String getComponentClass() {
        return "Kalix.admin.area.view.Area";
    }

    @Override
    public int getIndex() {
        return 0;
    }

    @Override
    public String getPermission() {
        return "admin:sysModule:systemConstantMenu:areaMenu";
    }
}
