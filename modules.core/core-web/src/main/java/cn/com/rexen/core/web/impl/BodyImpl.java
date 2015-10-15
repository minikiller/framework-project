package cn.com.rexen.core.web.impl;

import cn.com.rexen.core.api.web.IApplication;
import cn.com.rexen.core.api.web.IBody;
import cn.com.rexen.core.web.manager.ApplicationManager;

import java.util.List;

/**
 * Created by sunlf on 2015/7/13.
 * 监听IApplication的注册和注销
 */
public class BodyImpl implements IBody {


    @Override
    public List<IApplication> getApplications() {
        return ApplicationManager.getInstall().getApplicationList();
    }


}
