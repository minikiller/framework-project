package cn.com.rexen.core.web.listener;

import cn.com.rexen.core.api.web.IModule;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by sunlf on 2015/7/13.
 * 维护IApplication列表
 */
public class MoudleManager {
    private static MoudleManager install;

    private Map<String, List<IModule>> moduleMap = new HashMap<>();

    private MoudleManager() {
    }

    public synchronized static MoudleManager getInstall() {
        if (install == null) {
            install = new MoudleManager();
        }
        return install;
    }

    public void add(IModule module) {
        List<IModule> moduleList = moduleMap.get(module.getApplicationId());
        if (moduleList == null) {
            moduleList = new ArrayList<>();
            moduleMap.put(module.getApplicationId(), moduleList);
        }
        moduleList.add(module);
    }

    public void remove(IModule module) {
        List<IModule> moduleList = moduleMap.get(module.getApplicationId());
        moduleList.remove(module);
    }

    public List<IModule> getModuleList(String applicationId) {
        return moduleMap.get(applicationId);
    }
}
