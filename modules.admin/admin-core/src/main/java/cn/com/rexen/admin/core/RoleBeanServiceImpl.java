package cn.com.rexen.admin.core;

import cn.com.rexen.admin.api.biz.IRoleBeanService;
import cn.com.rexen.admin.api.dao.IRoleBeanDao;
import cn.com.rexen.admin.api.dao.IRoleUserBeanDao;
import cn.com.rexen.admin.api.dao.IUserBeanDao;
import cn.com.rexen.admin.api.dao.IWorkGroupRoleBeanDao;
import cn.com.rexen.admin.entities.PermissionBean;
import cn.com.rexen.admin.entities.RoleBean;
import cn.com.rexen.admin.entities.RoleUserBean;
import cn.com.rexen.admin.entities.UserBean;
import cn.com.rexen.core.api.biz.JsonStatus;
import cn.com.rexen.core.api.persistence.JsonData;
import cn.com.rexen.core.api.persistence.PersistentEntity;
import cn.com.rexen.core.api.security.IShiroService;
import cn.com.rexen.core.impl.biz.GenericBizServiceImpl;
import cn.com.rexen.core.util.Assert;
import org.apache.commons.lang.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @类描述：角色服务类
 * @创建人：sunlf
 * @创建时间：2014-05-14 上午10:43
 * @修改人：
 * @修改时间：
 * @修改备注：
 */

public class RoleBeanServiceImpl extends GenericBizServiceImpl implements IRoleBeanService {
    private static final String FUNCTION_NAME = "角色";
    private IRoleBeanDao roleBeanDao;
    private IUserBeanDao userBeanDao;
    private IRoleUserBeanDao roleUserBeanDao;
    private IWorkGroupRoleBeanDao workGroupRoleBeanDao;
    private IShiroService shiroService;

    public void setWorkGroupRoleBeanDao(IWorkGroupRoleBeanDao workGroupRoleBeanDao) {
        this.workGroupRoleBeanDao = workGroupRoleBeanDao;
    }

    public IRoleUserBeanDao getRoleUserBeanDao() {
        return roleUserBeanDao;
    }

    public void setRoleUserBeanDao(IRoleUserBeanDao roleUserBeanDao) {
        this.roleUserBeanDao = roleUserBeanDao;
    }


    public void setShiroService(IShiroService shiroService) {
        this.shiroService = shiroService;
    }

    public void setRoleBeanDao(IRoleBeanDao roleBeanDao) {
        this.roleBeanDao = roleBeanDao;
        super.init(roleBeanDao, RoleBean.class.getName());
    }

    @Override
    public void beforeUpdateEntity(PersistentEntity entity, JsonStatus status) {
        Assert.notNull(entity, "实体不能为空.");
        String userName = shiroService.getCurrentUserName();
        Assert.notNull(userName, "用户名不能为空.");
        if(StringUtils.isNotEmpty(userName)) {
            entity.setUpdateBy(userName);
        }
    }

    @Override
    public void beforeSaveEntity(PersistentEntity entity, JsonStatus status) {
        String userName = shiroService.getCurrentUserName();
        Assert.notNull(userName, "用户名不能为空.");
        if(StringUtils.isNotEmpty(userName)) {
            entity.setCreateBy(userName);
            entity.setUpdateBy(userName);
        }
    }

    @Override
    public boolean isDelete(Long entityId, JsonStatus status) {
        if (roleBeanDao.get(RoleBean.class.getName(),entityId) == null) {
            status.setFailure(true);
            status.setMsg(FUNCTION_NAME + "已经被删除！");
            return false;
        }
        return true;
    }

    @Override
    public boolean isUpdate(PersistentEntity entity, JsonStatus status) {
        Assert.notNull(entity, "实体不能为空.");
        RoleBean role=(RoleBean)entity;
        List<RoleBean> beans=roleBeanDao.find("select ob from RoleBean ob where ob.name = ?1 ", role.getName());
        if(beans!=null&&beans.size()>0){
            RoleBean _role=beans.get(0);
            if(_role.getId()!=role.getId()){
                status.setFailure(true);
                status.setMsg("更新" + FUNCTION_NAME + "失败,已经存在！");
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean isSave(PersistentEntity entity, JsonStatus status) {
        Assert.notNull(entity, "实体不能为空.");
        RoleBean role=(RoleBean)entity;
        List<RoleBean> beans=roleBeanDao.find("select ob from RoleBean ob where ob.name = ?1", role.getName());
        if(beans!=null&&beans.size()>0){
            status.setSuccess(false);
            status.setMsg(FUNCTION_NAME + "已经存在！");
            return false;
        }
        return true;
    }

    public void setUserBeanDao(IUserBeanDao userBeanDao) {
        this.userBeanDao = userBeanDao;
    }

    @Override
    public List<String> getRoleNameList() {
        return roleBeanDao.getRoleNameList();
    }

    @Override
    public List<String> getRoleNameList(UserBean userBean) {
        return roleBeanDao.getRoleNameList(userBean);
    }




    @Override
    public JsonData getAllRole() {
        JsonData jsonData=new JsonData();
        List<RoleBean> roles=roleBeanDao.getAll(RoleBean.class.getName());
        List<PersistentEntity> persistentEntityList=new ArrayList<PersistentEntity>();
        if(roles!=null&&roles.size()>0){
            for(RoleBean role:roles){
                persistentEntityList.add((PersistentEntity)role);
            }
        }
        jsonData.setData(persistentEntityList);
        jsonData.setTotalCount((long) roles.size());
        return jsonData;
    }

    @Override
    public void saveRoleUser(RoleBean roleBean, List<UserBean> userSelect) {
        List<UserBean> userBeanList = new ArrayList<UserBean>();
        //为新对象
        if (roleBean.getId() == 0L) {
            roleBean = roleBeanDao.save(roleBean);
        } else {
            userBeanList = roleBeanDao.get(RoleBean.class.getName(), roleBean.getId()).getUserList();
        }

        //删除全部该角色下的用户
        removeRole(roleBean, userBeanList);
        if (userSelect.size() > 0) {
            //添加角色到用户
            for (UserBean userBean : userSelect) {
                UserBean user = userBeanDao.getUser(userBean.getId());
                if (!user.getRoleList().contains(roleBean)) {
                    user.getRoleList().add(roleBean);
                    userBeanDao.save(user);
                }
            }
        }
    }

    @Override
    public List<RoleBean> query(RoleBean roleBean) {
        return roleBeanDao.find("select a from RoleBean a where a.name LIKE ?1", "%" + roleBean.getName() + "%");
    }

    @Override
    public List<UserBean> getUserList(RoleBean roleBean) {
        return null;
    }

    private void removeRole(RoleBean roleBean, List<UserBean> userBeanList) {
        for (UserBean userBean : userBeanList) {
            userBean.getRoleList().remove(roleBean);
            userBeanDao.save(userBean);
        }
    }

    @Override
    public List getUsersByRoleId(long id) {
        List<String> userIds=new ArrayList<String>();
        List<RoleUserBean> roleUserBeans=roleUserBeanDao.find("select ob from RoleUserBean ob where ob.roleId = ?1", id);
        if(roleUserBeans!=null&&!roleUserBeans.isEmpty()){
            for(RoleUserBean roleUserBean:roleUserBeans){
                if(roleUserBean!=null&&roleUserBean.getUserId()!=0){
                    userIds.add(String.valueOf(roleUserBean.getUserId()));
                }
            }
        }
        return userIds;
    }

    @Override
    public void afterDeleteEntity(Long id, JsonStatus status) {
        roleUserBeanDao.deleteByRoleId(id);
        workGroupRoleBeanDao.update("delete from WorkGroupRoleBean wgr where wgr.roleId=?1",id);
    }

    @Override
    public JsonStatus saveRoleUsers(long roleId, String userId) {
        JsonStatus jsonStatus=new JsonStatus();
        try {
            roleUserBeanDao.deleteByRoleId(roleId);
            String userName=shiroService.getCurrentUserName();
            if (StringUtils.isNotEmpty(userId)) {
                if (userId.indexOf(",") != -1) {
                    String[] userIds = userId.split(",");
                    for (String _userId : userIds) {
                        if (StringUtils.isNotEmpty(_userId.trim())) {
                            RoleUserBean roleUserBean = new RoleUserBean();
                            roleUserBean.setCreateBy(userName);
                            roleUserBean.setUpdateBy(userName);
                            roleUserBean.setRoleId(roleId);
                            roleUserBean.setUserId(Long.parseLong(_userId));
                            roleUserBeanDao.save(roleUserBean);
                        }
                    }
                }else{
                    if (StringUtils.isNotEmpty(userId.trim())) {
                        RoleUserBean roleUserBean = new RoleUserBean();
                        roleUserBean.setCreateBy(userName);
                        roleUserBean.setUpdateBy(userName);
                        roleUserBean.setRoleId(roleId);
                        roleUserBean.setUserId(Long.parseLong(userId));
                        roleUserBeanDao.save(roleUserBean);
                    }
                }
            }
        }catch(Exception e){
            e.printStackTrace();
            jsonStatus.setFailure(true);
            jsonStatus.setMsg("保存失败!");
            return jsonStatus;
        }
        jsonStatus.setSuccess(true);
        jsonStatus.setMsg("保存成功!");
        return jsonStatus;
    }
}