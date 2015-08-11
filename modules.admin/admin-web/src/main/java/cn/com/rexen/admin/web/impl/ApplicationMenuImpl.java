package cn.com.rexen.admin.web.impl;

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
        return "sysModule";
    }

    @Override
    public String getParentMenuId() {
        return "permissionControlMenu";
    }

    @Override
    public String getId() {
        return "applicationMenu";
    }

    @Override
    public String getTitle() {
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
    public String getComponentClass() {
        return "Kalix.app.application.view.Application";
    }

    @Override
    public int getIndex() {
        return 0;
    }
}
