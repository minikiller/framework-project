package cn.com.rexen.admin.core;

import cn.com.rexen.admin.api.biz.IPermissionBeanService;
import cn.com.rexen.admin.api.biz.IRoleBeanService;
import cn.com.rexen.admin.api.biz.IWorkGroupBeanService;
import cn.com.rexen.admin.api.dao.IPermissionBeanDao;
import cn.com.rexen.admin.api.dao.IRoleApplicationBeanDao;
import cn.com.rexen.admin.api.dao.IRoleBeanDao;
import cn.com.rexen.admin.entities.PermissionBean;
import cn.com.rexen.admin.entities.RoleApplicationBean;
import cn.com.rexen.admin.entities.RoleBean;
import cn.com.rexen.admin.entities.WorkGroupUserBean;
import cn.com.rexen.app.api.dao.IApplicationBeanDao;
import cn.com.rexen.app.entities.ApplicationBean;
import cn.com.rexen.core.impl.biz.GenericBizServiceImpl;
import cn.com.rexen.core.util.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @类描述：权限服务实现类
 * @创建人：sunlf
 * @创建时间：2014-05-14 上午11:23
 * @修改人：
 * @修改时间：
 * @修改备注：
 */

public class PermissionBeanServiceImpl extends GenericBizServiceImpl implements IPermissionBeanService {
    private IPermissionBeanDao permissionBeanDao;
    private IRoleBeanDao roleBeanDao;
    private IRoleBeanService roleBeanService;
    private IRoleApplicationBeanDao roleApplicationBeanDao;
    private IWorkGroupBeanService workGroupBeanService;
    private IApplicationBeanDao applicationBeanDao;

    public void setApplicationBeanDao(IApplicationBeanDao applicationBeanDao) {
        this.applicationBeanDao = applicationBeanDao;
    }

    public void setWorkGroupBeanService(IWorkGroupBeanService workGroupBeanService) {
        this.workGroupBeanService = workGroupBeanService;
    }

    public void setRoleApplicationBeanDao(IRoleApplicationBeanDao roleApplicationBeanDao) {
        this.roleApplicationBeanDao = roleApplicationBeanDao;
    }

    public void setRoleBeanService(IRoleBeanService roleBeanService) {
        this.roleBeanService = roleBeanService;
    }

    public void setPermissionBeanDao(IPermissionBeanDao permissionBeanDao) {
        this.permissionBeanDao = permissionBeanDao;
        super.init(permissionBeanDao, PermissionBean.class.getName());

    }

    public void setRoleBeanDao(IRoleBeanDao roleBeanDao) {
        this.roleBeanDao = roleBeanDao;
    }

    @Override
    public PermissionBean getRootPermission() {
        return permissionBeanDao.getRootPermission();
    }

    @Override
    public List<PermissionBean> getChildPermission(PermissionBean permissionBean) {
        return permissionBeanDao.getChildPermission(permissionBean);
    }

    @Override
    public List<PermissionBean> query(PermissionBean permissionBean) {
        return null;
    }

    @Override
    public List<PermissionBean> getRootBeanList() {
        return permissionBeanDao.find("select u from PermissionBean u where u.parent is null");
    }

    @Override
    public List<PermissionBean> getChildBeanList(PermissionBean permissionBean) {
        return permissionBeanDao.find("select u from PermissionBean u where u.parent= ?1", permissionBean);
    }

    /**
     * 根据角色分配权限
     *
     * @param roleBean     角色bean
     * @param checkedNodes 权限列表
     */
    @Override
    public void assignPermission(RoleBean roleBean, Set<PermissionBean> checkedNodes) {
        roleBean.getPermissionList().clear();
        for (PermissionBean bean : checkedNodes) {
            roleBean.getPermissionList().add(bean);
        }
        roleBeanDao.save(roleBean);
    }

    @Override
    public List<String> getApplicationCodesByUserId(String userId) {
        Assert.notNull(userId, "用户编号不能为空.");
        List<String> applicationLocations=new ArrayList<String>();
        //返回用户下所有角色
        List<RoleBean> roleBeans=roleBeanService.getRolesByUserId(Long.parseLong(userId));
        if(roleBeans!=null&&!roleBeans.isEmpty()){
            for(RoleBean roleBean:roleBeans){
                List<RoleApplicationBean> roleApplicationBeans=roleApplicationBeanDao.getRoleApplicationsByRoleId(roleBean.getId());
                fillApplicationLicationByRoles(applicationLocations,roleApplicationBeans);
            }
        }
        //返回用户下所有工作组,根据工作组再返回工作组下所有角色
        List<WorkGroupUserBean> workGroupUserBeans=workGroupBeanService.getWorkGroupUserBeanByUserId(Integer.parseInt(userId));
        if(workGroupUserBeans!=null&&!workGroupUserBeans.isEmpty()){
            for(WorkGroupUserBean workGroupUserBean:workGroupUserBeans){
                List<RoleBean> _roleBeans=roleBeanService.getRolesByWorkGorupId(workGroupUserBean.getGroupId());
                if(_roleBeans!=null&&!_roleBeans.isEmpty()){
                    for(RoleBean roleBean:_roleBeans){
                        List<RoleApplicationBean> roleApplicationBeans=roleApplicationBeanDao.getRoleApplicationsByRoleId(roleBean.getId());
                        fillApplicationLicationByRoles(applicationLocations,roleApplicationBeans);
                    }
                }
            }
        }
        return applicationLocations;
    }

    private void fillApplicationLicationByRoles(List<String> applicationLocations,List<RoleApplicationBean> roleApplicationBeans){
        if(roleApplicationBeans!=null&&!roleApplicationBeans.isEmpty()){
            for(RoleApplicationBean roleApplicationBean:roleApplicationBeans){
                ApplicationBean applicationBean=applicationBeanDao.get(ApplicationBean.class.getName(), roleApplicationBean.getApplicationId());
                if(applicationBean!=null)
                    applicationLocations.add(applicationBean.getCode());
            }
        }
    }
}