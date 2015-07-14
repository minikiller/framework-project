package cn.com.rexen.core.web.impl;

import cn.com.rexen.core.api.web.IApplication;
import cn.com.rexen.core.api.web.ISystem;
import cn.com.rexen.core.api.web.ISystemService;
import cn.com.rexen.core.api.web.model.ApplicationBean;
import cn.com.rexen.core.api.web.model.HeaderBean;
import cn.com.rexen.core.api.web.model.SystemBean;
import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.ops4j.pax.cdi.api.OsgiService;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by sunlf on 2015/7/13.
 */
public class SystemServiceImpl implements ISystemService {
    @Inject
    @OsgiService(dynamic = true)
    ISystem systemService;

    @Override
    public SystemBean getSystem() {
        SystemBean systemBean = new SystemBean();
        Mapper mapper = new DozerBeanMapper();
        HeaderBean headerBean = mapper.map(systemService.getHeader(), HeaderBean.class);
        systemBean.setHeaderBean(headerBean);
        return systemBean;
    }

    @Override
    public List<ApplicationBean> getApplicationList() {
        List<ApplicationBean> applicationBeans = new ArrayList<>();
        List<IApplication> applicationList = ApplicationManager.getInstall().getApplicationList();
        if (applicationList != null && applicationList.size() > 0) {
            for (IApplication application : applicationList) {
                Mapper mapper = new DozerBeanMapper();
                ApplicationBean applicationBean = mapper.map(application, ApplicationBean.class);
                applicationBeans.add(applicationBean);
            }
        }
        return applicationBeans;
    }
}
