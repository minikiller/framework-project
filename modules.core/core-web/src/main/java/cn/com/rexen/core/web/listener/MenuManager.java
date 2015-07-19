package cn.com.rexen.core.web.listener;

import cn.com.rexen.core.api.web.IMenu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by sunlf on 2015/7/13.
 * 维护IApplication列表
 */
public class MenuManager {
    private static MenuManager install;

    private Map<String, List<IMenu>> menuMap = new HashMap<>();

    private MenuManager() {
    }

    public synchronized static MenuManager getInstall() {
        if (install == null) {
            install = new MenuManager();
        }
        return install;
    }

    public void add(IMenu menu) {
        List<IMenu> menuList = menuMap.get(menu.getModuleId());
        if (menuList == null) {
            menuList = new ArrayList<>();
            menuMap.put(menu.getModuleId(), menuList);
        }
        menuList.add(menu);
    }

    public void remove(IMenu menu) {
        List<IMenu> moduleList = menuMap.get(menu.getModuleId());
        moduleList.remove(menu);
    }

    public List<IMenu> getMenuList(String moduleId) {
        return menuMap.get(moduleId);
    }
}
