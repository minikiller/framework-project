package cn.com.rexen.admin.core;

import cn.com.rexen.admin.api.biz.IRoleBeanService;
import cn.com.rexen.admin.api.dao.IRoleBeanDao;
import cn.com.rexen.admin.api.dao.IRoleUserBeanDao;
import cn.com.rexen.admin.api.dao.IUserBeanDao;
import cn.com.rexen.admin.entities.PermissionBean;
import cn.com.rexen.admin.entities.RoleBean;
import cn.com.rexen.admin.entities.RoleUserBean;
import cn.com.rexen.admin.entities.UserBean;
import cn.com.rexen.core.api.biz.JsonStatus;
import cn.com.rexen.core.api.persistence.JsonData;
import cn.com.rexen.core.api.persistence.PersistentEntity;
import cn.com.rexen.core.api.security.IShiroService;
import cn.com.rexen.core.impl.biz.GenericBizServiceImpl;
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
    private IShiroService shiroService;

    public IRoleUserBeanDao getRoleUserBeanDao() {
        return roleUserBeanDao;
    }

    public void setRoleUserBeanDao(IRoleUserBeanDao roleUserBeanDao) {
        this.roleUserBeanDao = roleUserBeanDao;
    }

    public IUserBeanDao getUserBeanDao() {
        return userBeanDao;
    }

    public IShiroService getShiroService() {
        return shiroService;
    }

    public void setShiroService(IShiroService shiroService) {
        this.shiroService = shiroService;
    }

    public void setRoleBeanDao(IRoleBeanDao roleBeanDao) {
        this.roleBeanDao = roleBeanDao;
        super.init(roleBeanDao, RoleBean.class.getName());
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
    public JsonStatus addRole(RoleBean role) {
        JsonStatus jsonStatus = new JsonStatus();
        try {
            List<RoleBean> beans=roleBeanDao.find("select ob from RoleBean ob where ob.name = ?1", role.getName());
            if(beans!=null&&beans.size()>0){
                jsonStatus.setSuccess(false);
                jsonStatus.setMsg(FUNCTION_NAME + "已经存在！");
                return jsonStatus;
            }
            String userName=shiroService.getCurrentUserName();
            if(StringUtils.isNotEmpty(userName)){
                role.setCreateBy(userName);
                role.setUpdateBy(userName);
            }
            roleBeanDao.saveRole(role);
            jsonStatus.setSuccess(true);
            jsonStatus.setMsg("新增" + FUNCTION_NAME + "成功！");
        } catch (Exception e) {
            e.printStackTrace();
            jsonStatus.setFailure(true);
            jsonStatus.setMsg("新增" + FUNCTION_NAME + "失败！");
        }
        return jsonStatus;
    }

    @Override
    public JsonStatus deleteRole(Long id) {
        JsonStatus jsonStatus = new JsonStatus();
        try {
            if (roleBeanDao.getRole(id) == null) {
                jsonStatus.setFailure(true);
                jsonStatus.setMsg(FUNCTION_NAME + "{" + id + "}不存在！");
            } else {
                roleBeanDao.removeRole(id);
                roleUserBeanDao.deleteByRoleId(id);
                jsonStatus.setSuccess(true);
                jsonStatus.setMsg("删除" + FUNCTION_NAME + "成功！");
            }

        } catch (Exception e) {
            e.printStackTrace();
            jsonStatus.setFailure(true);
            jsonStatus.setMsg("删除" + FUNCTION_NAME + "失败！");
        }
        return jsonStatus;

    }

    @Override
    public JsonStatus updateRole(RoleBean role) {
        JsonStatus jsonStatus = new JsonStatus();
        try {

            List<RoleBean> beans=roleBeanDao.find("select ob from RoleBean ob where ob.name = ?1 ", role.getName());
            if(beans!=null&&beans.size()>0){
                RoleBean _role=beans.get(0);
                if(_role.getId()!=role.getId()){
                    jsonStatus.setFailure(true);
                    jsonStatus.setMsg("更新" + FUNCTION_NAME + "失败,已经存在！");
                    return jsonStatus;
                }
            }
            String userName=shiroService.getCurrentUserName();
            if(StringUtils.isNotEmpty(userName)) {
                role.setUpdateBy(userName);
            }
            roleBeanDao.saveRole(role);
            jsonStatus.setSuccess(true);
            jsonStatus.setMsg("更新" + FUNCTION_NAME + "成功！");
        } catch (Exception e) {
            e.printStackTrace();
            jsonStatus.setFailure(true);
            jsonStatus.setMsg("更新" + FUNCTION_NAME + "失败！");
        }
        return jsonStatus;

    }

    public JsonData getAllRole(int page,int limit) {
        return roleBeanDao.getAll(page, limit, RoleBean.class.getName());
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