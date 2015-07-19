package cn.com.rexen.core.web.listener;

import cn.com.rexen.core.api.web.IApplication;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sunlf on 2015/7/13.
 * 维护IApplication列表
 */
public class ApplicationManager {
    private static ApplicationManager install;

    private List<IApplication> applicationList = new ArrayList<>();

    private ApplicationManager() {
    }

    public synchronized static ApplicationManager getInstall() {
        if (install == null) {
            install = new ApplicationManager();
        }
        return install;
    }

    public void add(IApplication application) {
        applicationList.add(application);
    }

    public void remove(IApplication application) {
        applicationList.remove(application);
    }

    public List<IApplication> getApplicationList() {
        return applicationList;
    }
}
