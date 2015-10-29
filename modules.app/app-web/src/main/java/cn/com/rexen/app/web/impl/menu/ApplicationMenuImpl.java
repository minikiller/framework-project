package cn.com.rexen.app.web.impl.menu;

import cn.com.rexen.core.api.web.IMenu;

/**
 * 应用菜单
 * @author majian <br/>
 *         date:2015-8-10
 * @version 1.0.0
 */
public class ApplicationMenuImpl implements IMenu {
    @Override
    public boolean isLeaf() {
        return true;
    }

    @Override
    public String getModuleId() {
        return "appModule";
    }

    @Override
    public String getParentMenuId() {
        return null;
    }

    @Override
    public String getId() {
        return "applicationMenu";
    }

    @Override
    public String getText() {
        return "应用管理";
    }

    @Override
    public String getDescription() {
        return null;
    }

    @Override
    public String getIcon() {
        return "app/resources/images/application.png";
    }

    @Override
    public String getRouteId() {
        return "/application";
    }

    @Override
    public int getIndex() {
        return 0;
    }

    @Override
    public String getPermission() {
        return null;//"admin:appModule:appControlMenu:applicationMenu";
    }

    @Override
    public String getIconCls() {
        return "x-fa fa-cubes";
    }
}
