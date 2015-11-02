package cn.com.rexen.admin.web.impl.menu;

import cn.com.rexen.core.api.web.IMenu;

/**
 * 字典菜单
 * @author majian <br/>
 *         date:2015-8-10
 * @version 1.0.0
 */
public class DictMenuImpl implements IMenu {
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
        return null;
    }

    @Override
    public String getId() {
        return "dictMenu";
    }

    @Override
    public String getText() {
        return "字典管理";
    }

    @Override
    public String getDescription() {
        return null;
    }

    @Override
    public String getIcon() {
        return "admin/resources/images/book.png";
    }

    @Override
    public String getRouteId() {
        return "admin/Dict";
    }

    @Override
    public int getIndex() {
        return 0;
    }

    @Override
    public String getPermission() {
        return null;//"admin:sysModule:systemConstantMenu:dictMenu";
    }

    @Override
    public String getIconCls() {
        return "x-fa fa-table";
    }
}
