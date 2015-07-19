package cn.com.rexen.core.api.web.model;

import java.util.List;

/**
 * Created by sunlf on 2015/7/14.
 */
public class ModuleBean extends BaseWebPage {
    private List<MenuBean> menus;

    public List<MenuBean> getMenus() {
        return menus;
    }

    public void setMenus(List<MenuBean> menus) {
        this.menus = menus;
    }
}
