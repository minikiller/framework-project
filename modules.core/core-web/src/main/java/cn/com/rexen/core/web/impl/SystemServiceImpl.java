package cn.com.rexen.core.web.impl;

import cn.com.rexen.core.api.web.*;
import cn.com.rexen.core.api.web.model.*;
import cn.com.rexen.core.web.listener.ApplicationManager;
import cn.com.rexen.core.web.listener.MenuManager;
import cn.com.rexen.core.web.listener.MoudleManager;
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

    @Override
    public List<ModuleBean> getModuleByApplication(String applicationId) {
        List<IModule> moduleList = MoudleManager.getInstall().getModuleList(applicationId);
        Mapper mapper = new DozerBeanMapper();
        List<ModuleBean> moduleBeanList = DozerHelper.map(mapper, moduleList, ModuleBean.class);
        return moduleBeanList;
    }

    @Override
    public MenuBean getMenuByModule(String moduleId) {
        List<IMenu> menuList = MenuManager.getInstall().getMenuList(moduleId);
        IMenu rootMenu = getRootMenu(menuList);
        /*List<String> mapFile=new ArrayList<>();
        mapFile.add("META-INF/MenuMapper.xml");*/
        Mapper mapper = new DozerBeanMapper();
        MenuBean menuBean = mapper.map(rootMenu, MenuBean.class);
        getMenuChilden(menuBean, menuList, mapper);
        return menuBean;
    }

    /**
     * 递归函数加载子菜单
     *
     * @param menuBean
     * @param menuList
     */
    private void getMenuChilden(MenuBean menuBean, List<IMenu> menuList, Mapper mapper) {
        List<MenuBean> childMenuList = new ArrayList<>();

        for (IMenu menu : menuList) {
            if (menu.getParentMenuId() != null && menu.getParentMenuId().equals(menuBean.getId())) {
                MenuBean mBean = mapper.map(menu, MenuBean.class);
                childMenuList.add(mBean);
                getMenuChilden(mBean, menuList, mapper);
            }
        }
        menuBean.setChildren(childMenuList);
    }

    /**
     * 获得菜单根节点
     *
     * @param menuList
     * @return
     */
    private IMenu getRootMenu(List<IMenu> menuList) {
        for (IMenu menu : menuList) {
            if (menu.getParentMenuId() == null) {
                return menu;
            }
        }
        return null;
    }

    public void setSystemService(ISystem systemService) {
        this.systemService = systemService;
    }

}
