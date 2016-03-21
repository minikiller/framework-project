package cn.com.rexen.admin.web.impl.menu;

import cn.com.rexen.admin.web.impl.Const;
import cn.com.rexen.core.api.web.IMenu;

/**
 * 机构菜单
 *
 * @author majian <br/>
 *         date:2015-8-10
 * @version 1.0.0
 */
public class OrganizationNoAreaMenuImpl implements IMenu {
    @Override
    public boolean isLeaf() {
        return true;
    }

    @Override
    public String getModuleId() {
        return "constructModule";
    }

    @Override
    public String getParentMenuId() {
        return null;
    }

    @Override
    public String getId() {
        return "organizationNoAreaMenu";
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
        return "admin/OrgNoArea";
    }

    @Override
    public int getIndex() {
        return 10;
    }

    @Override
    public String getPermission() {
        return Const.APP_NAME + ":" + getModuleId() + ":" + getId();
    }

    @Override
    public String getIconCls() {
        return "x-fa fa-building";
    }
}
