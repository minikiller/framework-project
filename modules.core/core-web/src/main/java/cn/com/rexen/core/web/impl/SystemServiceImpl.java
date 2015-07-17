package cn.com.rexen.core.web.impl;

import cn.com.rexen.core.api.web.IApplication;
import cn.com.rexen.core.api.web.ISystem;
import cn.com.rexen.core.api.web.ISystemService;
import cn.com.rexen.core.api.web.model.*;
import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sunlf on 2015/7/13.
 */
public class SystemServiceImpl implements ISystemService {
    private ISystem systemService;

    @Override
    public SystemBean getSystem() {
        SystemBean systemBean = new SystemBean();
        Mapper mapper = new DozerBeanMapper();
        HeaderBean headerBean = mapper.map(systemService.getHeader(), HeaderBean.class);
        systemBean.setHeaderBean(headerBean);

        FooterBean footerBean = mapper.map(systemService.getFooter(), FooterBean.class);
        systemBean.setFooterBean(footerBean);

        BodyBean bodyBean = new BodyBean();
        bodyBean.setApplicationBeanList(DozerHelper.map(mapper, systemService.getBody().getApplications(), ApplicationBean.class));
        systemBean.setBodyBean(bodyBean);
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

    public void setSystemService(ISystem systemService) {
        this.systemService = systemService;
    }

}
