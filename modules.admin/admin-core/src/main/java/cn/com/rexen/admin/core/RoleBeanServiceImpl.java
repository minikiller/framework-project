package cn.com.rexen.admin.core;

import cn.com.rexen.admin.api.biz.IRoleBeanService;
import cn.com.rexen.admin.api.dao.*;
import cn.com.rexen.admin.entities.*;
import cn.com.rexen.app.api.biz.IFunctionBeanService;
import cn.com.rexen.app.api.dao.IApplicationBeanDao;
import cn.com.rexen.app.api.dao.IFunctionBeanDao;
import cn.com.rexen.app.dto.model.AuthorizationDTO;
import cn.com.rexen.app.entities.ApplicationBean;
import cn.com.rexen.app.entities.FunctionBean;
import cn.com.rexen.core.api.biz.JsonStatus;
import cn.com.rexen.core.api.persistence.IGenericDao;
import cn.com.rexen.core.api.persistence.JsonData;
import cn.com.rexen.core.api.persistence.PersistentEntity;
import cn.com.rexen.core.api.security.IShiroService;
import cn.com.rexen.core.impl.biz.GenericBizServiceImpl;
import cn.com.rexen.core.util.Assert;
import org.apache.commons.lang.StringUtils;
import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;

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

public class RoleBeanServiceImpl extends GenericBizServiceImpl<IRoleBeanDao, RoleBean> implements IRoleBeanService {
    private static final String FUNCTION_NAME = "角色";
    //    private IRoleBeanDao dao;
    private IUserBeanDao userBeanDao;
    private IRoleUserBeanDao roleUserBeanDao;
    private IWorkGroupRoleBeanDao workGroupRoleBeanDao;
    private IRoleApplicationBeanDao roleApplicationBeanDao;
    private IRoleFunctionBeanDao roleFunctionBeanDao;
    private IApplicationBeanDao applicationBeanDao;
    private IFunctionBeanDao functionBeanDao;
    private IFunctionBeanService functionBeanService;
    private IShiroService shiroService;

    public RoleBeanServiceImpl() {
        super.init(RoleBean.class.getName());
    }

    public void setFunctionBeanService(IFunctionBeanService functionBeanService) {
        this.functionBeanService = functionBeanService;
    }

    public void setApplicationBeanDao(IApplicationBeanDao applicationBeanDao) {
        this.applicationBeanDao = applicationBeanDao;
    }

    public void setFunctionBeanDao(IFunctionBeanDao functionBeanDao) {
        this.functionBeanDao = functionBeanDao;
    }

    public void setRoleApplicationBeanDao(IRoleApplicationBeanDao roleApplicationBeanDao) {
        this.roleApplicationBeanDao = roleApplicationBeanDao;
    }

    public void setRoleFunctionBeanDao(IRoleFunctionBeanDao roleFunctionBeanDao) {
        this.roleFunctionBeanDao = roleFunctionBeanDao;
    }

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

//    public void setRoleBeanDao(IRoleBeanDao dao) {
//        this.dao = dao;
//
//    }

    @Override
    public void beforeUpdateEntity(RoleBean entity, JsonStatus status) {
        Assert.notNull(entity, "实体不能为空.");
        String userName = shiroService.getCurrentUserName();
        Assert.notNull(userName, "用户名不能为空.");
        if(StringUtils.isNotEmpty(userName)) {
            entity.setUpdateBy(userName);
        }
    }

    @Override
    public void beforeSaveEntity(RoleBean entity, JsonStatus status) {
        String userName = shiroService.getCurrentUserName();
        Assert.notNull(userName, "用户名不能为空.");
        if(StringUtils.isNotEmpty(userName)) {
            entity.setCreateBy(userName);
            entity.setUpdateBy(userName);
        }
    }

    @Override
    public boolean isDelete(Long entityId, JsonStatus status) {
        if (dao.get(RoleBean.class.getName(), entityId) == null) {
            status.setFailure(true);
            status.setMsg(FUNCTION_NAME + "已经被删除！");
            return false;
        }
        return true;
    }

    @Override
    public boolean isUpdate(RoleBean entity, JsonStatus status) {
        Assert.notNull(entity, "实体不能为空.");
        RoleBean role=(RoleBean)entity;
        List<RoleBean> beans = dao.find("select ob from RoleBean ob where ob.name = ?1 ", role.getName());
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
    public boolean isSave(RoleBean entity, JsonStatus status) {
        Assert.notNull(entity, "实体不能为空.");
        RoleBean role=(RoleBean)entity;
        List<RoleBean> beans = dao.find("select ob from RoleBean ob where ob.name = ?1", role.getName());
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
        return dao.getRoleNameList();
    }

    @Override
    public List<String> getRoleNameList(UserBean userBean) {
        return dao.getRoleNameList(userBean);
    }




    @Override
    public JsonData getAllRole() {
        JsonData jsonData=new JsonData();
        List<RoleBean> roles = dao.getAll(RoleBean.class.getName());
        List<PersistentEntity> persistentEntityList=new ArrayList<PersistentEntity>();
        if(roles!=null&&roles.size()>0){
            for(RoleBean role:roles){
                persistentEntityList.add(role);
            }
        }
        jsonData.setData(persistentEntityList);
        jsonData.setTotalCount((long) roles.size());
        return jsonData;
    }

    @Override
    public JsonStatus saveAuthorization(String roleId, String authorizationIds) {
        Assert.notNull(roleId,"角色编号不能为空.");
        Assert.notNull(authorizationIds,"授权编号不能为空.");
        JsonStatus jsonStatus=new JsonStatus();
        try {
            //清除关联关系
            roleApplicationBeanDao.deleteByRoleId(Long.parseLong(roleId));
            roleFunctionBeanDao.deleteByRoleId(Long.parseLong(roleId));
            String userName=shiroService.getCurrentUserName();
            if (authorizationIds.indexOf(",") != -1) {
                String[] _authorizationIds = authorizationIds.split(",");
                for (String _authorizationId : _authorizationIds) {
                    if(_authorizationId.indexOf("root")!=-1)
                        continue;
                    if(_authorizationId.startsWith("app:")){
                        RoleApplicationBean roleApplicationBean=new RoleApplicationBean();
                        roleApplicationBean.setCreateBy(userName);
                        roleApplicationBean.setUpdateBy(userName);
                        roleApplicationBean.setRoleId(Long.parseLong(roleId));
                        String applicationId=_authorizationId.substring("app:".length(), _authorizationId.length());
                        roleApplicationBean.setApplicationId(Long.parseLong(applicationId));
                        roleApplicationBeanDao.save(roleApplicationBean);
                    }else if(_authorizationId.startsWith("fun:")){
                        RoleFunctionBean roleFunctionBean=new RoleFunctionBean();
                        roleFunctionBean.setCreateBy(userName);
                        roleFunctionBean.setUpdateBy(userName);
                        roleFunctionBean.setRoleId(Long.parseLong(roleId));
                        String functionId=_authorizationId.substring("fun:".length(), _authorizationId.length());
                        roleFunctionBean.setFunctionId(Long.parseLong(functionId));
                        roleFunctionBeanDao.save(roleFunctionBean);
                    }
                }
            }else{
                if(authorizationIds.startsWith("app:")&&authorizationIds.indexOf("root")==-1){
                    RoleApplicationBean roleApplicationBean=new RoleApplicationBean();
                    roleApplicationBean.setCreateBy(userName);
                    roleApplicationBean.setUpdateBy(userName);
                    roleApplicationBean.setRoleId(Long.parseLong(roleId));
                    String applicationId=authorizationIds.substring("app:".length(), authorizationIds.length());
                    roleApplicationBean.setApplicationId(Long.parseLong(applicationId));
                    roleApplicationBeanDao.save(roleApplicationBean);
                }else if(authorizationIds.startsWith("fun:")&&authorizationIds.indexOf("root")==-1){
                    RoleFunctionBean roleFunctionBean=new RoleFunctionBean();
                    roleFunctionBean.setCreateBy(userName);
                    roleFunctionBean.setUpdateBy(userName);
                    roleFunctionBean.setRoleId(Long.parseLong(roleId));
                    String functionId=authorizationIds.substring("fun:".length(), authorizationIds.length());
                    roleFunctionBean.setFunctionId(Long.parseLong(functionId));
                    roleFunctionBeanDao.save(roleFunctionBean);
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

    @Override
    public void saveRoleUser(RoleBean roleBean, List<UserBean> userSelect) {
        List<UserBean> userBeanList = new ArrayList<UserBean>();
        //为新对象
        if (roleBean.getId() == 0L) {
            roleBean = dao.save(roleBean);
        } else {
            userBeanList = dao.get(RoleBean.class.getName(), roleBean.getId()).getUserList();
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
        return dao.find("select a from RoleBean a where a.name LIKE ?1", "%" + roleBean.getName() + "%");
    }

    @Override
    public List<UserBean> getUserList(RoleBean roleBean) {
        return null;
    }

    @Override
    public List<RoleBean> getRolesByUserId(long userId) {
        List<RoleUserBean> roleUserBeans=roleUserBeanDao.find("select rub from RoleUserBean rub where rub.userId=?1", userId);
        List<RoleBean> roleBeans=new ArrayList<RoleBean>();
        if(roleUserBeans!=null&&!roleUserBeans.isEmpty()){
            for(RoleUserBean roleUserBean:roleUserBeans){
                RoleBean roleBean = dao.get(RoleBean.class.getName(), roleUserBean.getRoleId());
                roleBeans.add(roleBean);
            }
        }
        return roleBeans;
    }

    @Override
    public List<RoleBean> getRolesByWorkGorupId(long workGroupId) {
        List<WorkGroupRoleBean> workGroupRoleBeans=workGroupRoleBeanDao.find("select wgrb from WorkGroupRoleBean wgrb where wgrb.groupId=?1",workGroupId);
        List<RoleBean> roleBeans=new ArrayList<RoleBean>();
        if(workGroupRoleBeans!=null&&!workGroupRoleBeans.isEmpty()){
            for(WorkGroupRoleBean workGroupRoleBean:workGroupRoleBeans){
                roleBeans.add(dao.get(RoleBean.class.getName(), workGroupRoleBean.getRoleId()));
            }
        }
        return roleBeans;
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
        roleApplicationBeanDao.deleteByRoleId(id);
        roleFunctionBeanDao.deleteByRoleId(id);
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

    @Override
    public AuthorizationDTO getAuthorizationTree(long roleId) {
        AuthorizationDTO root=new AuthorizationDTO();
        root.setId("-1");
        List<ApplicationBean> beans=applicationBeanDao.getAll(ApplicationBean.class.getName());
        if(beans!=null&&beans.size()>0){
            if(beans!=null&&beans.size()>0) {
                //查询关联关系
                List<RoleFunctionBean> roleFunctionBeans=roleFunctionBeanDao.find("select rfb from RoleFunctionBean rfb where rfb.roleId=?1",roleId);
                List<RoleApplicationBean> roleApplicationBeans=roleApplicationBeanDao.find("select rab from RoleApplicationBean rab where rab.roleId=?1",roleId);
                for(ApplicationBean applicationBean:beans){
                    Assert.notNull(applicationBean,"应用不能为空");
                    Mapper mapper = new DozerBeanMapper();
                    AuthorizationDTO applicationDTO = mapper.map(applicationBean, AuthorizationDTO.class);
                    applicationDTO.setParentId(-1);
                    applicationDTO.setLeaf(true);
                    applicationDTO.setChecked(false);
                    if(roleApplicationBeans!=null&&!roleApplicationBeans.isEmpty()){
                        for(RoleApplicationBean roleApplicationBean:roleApplicationBeans){
                            if(applicationBean.getId()==roleApplicationBean.getApplicationId()){
                                applicationDTO.setChecked(true);
                                break;
                            }
                        }
                    }
                    applicationDTO.setExpanded(true);
                    List<FunctionBean> functionBeans=functionBeanDao.find("select ob from FunctionBean ob where ob.applicationId = ?1", applicationBean.getId());
                    if(functionBeans!=null&&functionBeans.size()>0) {
                        applicationDTO.setLeaf(false);
                        //返回该应用下所有根功能
                        List<FunctionBean> rootFunctions=functionBeanService.getRootElements(functionBeans);
                        if(rootFunctions!=null&&rootFunctions.size()>0){
                            for(FunctionBean functionBean:rootFunctions) {
                                AuthorizationDTO functionDTO = mapper.map(functionBean, AuthorizationDTO.class);
                                functionDTO.setParentId(applicationBean.getId());
                                functionDTO.setLeaf(functionBean.getIsLeaf() == 0 ? false : true);
                                functionDTO.setText(functionBean.getName());
                                functionDTO.setChecked(false);
                                //将已选择的节点设置选中状态
                                if(roleFunctionBeans!=null&&!roleFunctionBeans.isEmpty()){
                                    for(RoleFunctionBean roleFunctionBean:roleFunctionBeans){
                                        if(functionBean.getId()==roleFunctionBean.getFunctionId()){
                                            functionDTO.setChecked(true);
                                            break;
                                        }
                                    }
                                }
                                functionDTO.setExpanded(true);
                                functionBeanService.getChilden(functionDTO, functionBeans, mapper,roleFunctionBeans);
                                applicationDTO.getChildren().add(functionDTO);
                            }
                        }
                    }
                    applicationDTO.setText(applicationBean.getName());
                    root.getChildren().add(applicationDTO);
                }
            }
        }
        return root;
    }

}