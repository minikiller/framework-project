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
        public String getDescription() {
            return null;
        }

        @Override
        public String getIcon() {
            return "admin/resources/images/building.png";
        }

        @Override
        public int getIndex() {
            return 0;
        }

        //todo add permission
        @Override
        public String getPermission() {
            return "";
        }

        //todo change iconcls
        @Override
        public String getIconCls() {
            return "x-fa fa-cubes";
        }

        @Override
        public String getText() {
            return "项目机会";
        }

        @Override
        public String getRouteId() {
            return "roffice/<beanName>";
        }
}
