package <packageName>.web.impl;

import cn.com.rexen.core.api.web.IMenu;

public class <beanName>MenuImpl implements IMenu {
    @Override
    public boolean isLeaf() {
        return true;
    }

    @Override
    public String getModuleId() {
        return "<pomName>Module";
    }

    @Override
    public String getParentMenuId() {
        return "<pomName>Menu";
    }

    @Override
    public String getId() {
        return "<pomName>Menu";
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
        return "Kalix.<pomName>.view.<beanName>";
    }

    @Override
    public int getIndex() {
        return 0;
    }

    @Override
    public String getPermission() {
        return "admin:<pomName>Module:<pomName>Menu:<pomName>Menu";
    }
}
