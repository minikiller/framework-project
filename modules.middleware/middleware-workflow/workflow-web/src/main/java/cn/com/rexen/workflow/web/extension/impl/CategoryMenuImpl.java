package cn.com.rexen.workflow.web.extension.impl;

import cn.com.rexen.core.api.web.IMenu;

public class CategoryMenuImpl implements IMenu {
    @Override
        public boolean isLeaf() {
            return true;
        }

        @Override
        public String getModuleId() {
            return "workFlowModule";
        }

        @Override
        public String getParentMenuId() {
            return null;
        }

        @Override
        public String getId() {
            return "categoryMenu";
        }

        @Override
        public String getDescription() {
            return "流程分类管理";
        }

        @Override
        public String getIcon() {
            return null;
        }

        @Override
        public int getIndex() {
            return 30;
        }


        @Override
        public String getIconCls() {
            return "x-fa fa-cutlery";
        }

        @Override
        public String getText() {
            return "流程分类管理";
        }

        @Override
        public String getRouteId() {
            return "workflow/category";
        }

        @Override
        public String getPermission() {
//            return "workflow:" + getModuleId() + ":" + getId();
            return "";
        }

}
