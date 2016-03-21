package <packageName>.web.impl;

import cn.com.rexen.core.api.web.IMenu;

public class <beanName>MenuImpl implements IMenu {
    @Override
        public boolean isLeaf() {
            return true;
        }

        @Override
        public String getModuleId() {
            return "<module_id>";
        }

        @Override
        public String getParentMenuId() {
            return null;
        }

        @Override
        public String getId() {
            return "<menu_id>";
        }

        @Override
        public String getDescription() {
            return "<menu_text>";
        }

        @Override
        public String getIcon() {
            return null;
        }

        @Override
        public int getIndex() {
            return <menu_index>;
        }


        @Override
        public String getIconCls() {
            return "<menu_icon_class>";
        }

        @Override
        public String getText() {
            return "<menu_text>";
        }

        @Override
        public String getRouteId() {
            return "<menu_route_id>";
        }

        @Override
        public String getPermission() {
            return "<permission_app>:<permission_module>:<permission_menu>";
        }
}
