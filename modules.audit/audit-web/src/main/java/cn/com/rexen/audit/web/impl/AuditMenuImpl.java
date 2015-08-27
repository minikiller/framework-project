package cn.com.rexen.audit.web.impl;

import cn.com.rexen.core.api.web.IMenu;

/**
 * 审计菜单
 *
 * @author majian <br/>
 *         date:2015-8-10
 * @version 1.0.0
 */
public class AuditMenuImpl implements IMenu {
    @Override
    public boolean isLeaf() {
        return true;
    }

    @Override
    public String getModuleId() {
        return "auditModule";
    }

    @Override
    public String getParentMenuId() {
        return "auditMenu";
    }

    @Override
    public String getId() {
        return "auditMenu";
    }

    @Override
    public String getTitle() {
        return "审计管理";
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
        return "Kalix.audit.view.Audit";
    }

    @Override
    public int getIndex() {
        return 0;
    }

    @Override
    public String getPermission() {
        return "admin:auditModule:auditMenu:auditMenu";
    }
}