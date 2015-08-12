package cn.com.rexen.admin.core;

import cn.com.rexen.admin.api.biz.IUserBeanService;
import cn.com.rexen.admin.api.dao.*;
import cn.com.rexen.admin.dto.model.query.UserDTO;
import cn.com.rexen.admin.entities.OrganizationBean;
import cn.com.rexen.admin.entities.RoleBean;
import cn.com.rexen.admin.entities.UserBean;
import cn.com.rexen.core.api.PermissionConstant;
import cn.com.rexen.core.api.biz.JsonStatus;
import cn.com.rexen.core.api.persistence.JsonData;
import cn.com.rexen.core.api.persistence.PersistentEntity;
import cn.com.rexen.core.api.security.IShiroService;
import cn.com.rexen.core.api.web.model.QueryDTO;
import cn.com.rexen.core.impl.biz.GenericBizServiceImpl;
import cn.com.rexen.core.util.Assert;
import cn.com.rexen.core.util.JNDIHelper;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.web.mgt.WebSecurityManager;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.metamodel.EntityType;
import javax.persistence.metamodel.SingularAttribute;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by dell on 14-1-17.
 */
public class UserBeanServiceImpl extends GenericBizServiceImpl implements IUserBeanService {
    private static final String FUNCTION_NAME = "用户";
    private IUserBeanDao userBeanDao;
    private IRoleBeanDao roleBeanDao;
    private IRoleUserBeanDao roleUserBeanDao;
    private IWorkGroupUserBeanDao workGroupUserBeanDao;
    private IDepartmentUserBeanDao departmentUserBeanDao;
    private IShiroService shiroService;

    public void setWorkGroupUserBeanDao(IWorkGroupUserBeanDao workGroupUserBeanDao) {
        this.workGroupUserBeanDao = workGroupUserBeanDao;
    }

    public void setDepartmentUserBeanDao(IDepartmentUserBeanDao departmentUserBeanDao) {
        this.departmentUserBeanDao = departmentUserBeanDao;
    }

    public void setRoleUserBeanDao(IRoleUserBeanDao roleUserBeanDao) {
        this.roleUserBeanDao = roleUserBeanDao;
    }

    @Override
    public void afterDeleteEntity(Long id, JsonStatus status) {
        roleUserBeanDao.update("delete from RoleUserBean ru where ru.userId=?1",id);
        departmentUserBeanDao.update("delete from DepartmentUserBean du where du.userId=?1", id);
        workGroupUserBeanDao.update("delete from WorkGroupUserBean wu where wu.userId=?1", id);
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
    public boolean isUpdate(PersistentEntity entity, JsonStatus status) {
        Assert.notNull(entity, "实体不能为空.");
        UserBean bean=(UserBean)entity;
        List<UserBean> userBeans=userBeanDao.find("select ob from UserBean ob where ob.loginName = ?1", bean.getLoginName());
        if(userBeans!=null&&userBeans.size()>0){
            UserBean _userBean=userBeans.get(0);
            if(entity.getId()!=_userBean.getId()) {
                status.setFailure(true);
                status.setMsg(FUNCTION_NAME + "已经存在！");
                return false;
            }
        }
        return true;
    }

    @Override
    public CriteriaQuery buildCriteriaQuery(QueryDTO queryDTO) {
        Assert.notNull(queryDTO,"查询对象不能为空.");
        UserDTO userDTO=(UserDTO)queryDTO;
        CriteriaBuilder criteriaBuilder = userBeanDao.getEntityManager().getCriteriaBuilder();
        CriteriaQuery<UserBean> criteriaQuery = criteriaBuilder.createQuery(UserBean.class);
        Root<UserBean> from = criteriaQuery.from(UserBean.class);
        EntityType<UserBean> userBean_ = from.getModel(); //实体元数据
        List<Predicate> predicatesList = new ArrayList<Predicate>();

        if(userDTO.getName()!=null&&!userDTO.getName().trim().isEmpty()){
            SingularAttribute<UserBean,String> name=(SingularAttribute<UserBean,String>)userBean_.getSingularAttribute("name");
            predicatesList.add(criteriaBuilder.like(from.get(name),"%"+ userDTO.getName()+"%"));
        }
        if(userDTO.getLoginName()!=null&&!userDTO.getLoginName().trim().isEmpty()){
            SingularAttribute<UserBean,String> loginName=(SingularAttribute<UserBean,String>)userBean_.getSingularAttribute("loginName");
            predicatesList.add(criteriaBuilder.like(from.get(loginName),"%"+userDTO.getLoginName()+"%"));
        }
        if(userDTO.getAvailable()!=-1){
            SingularAttribute<UserBean,Integer> available=(SingularAttribute<UserBean,Integer>)userBean_.getSingularAttribute("available");
            predicatesList.add(criteriaBuilder.equal(from.get(available), userDTO.getAvailable()));
        }
        criteriaQuery.where(predicatesList.toArray(new Predicate[predicatesList.size()]));
        CriteriaQuery select = criteriaQuery.select(from);
        return select;
    }


    @Override
    public boolean isSave(PersistentEntity entity, JsonStatus status) {
        UserBean bean=(UserBean)entity;
        List<UserBean> userBeans=userBeanDao.find("select ob from UserBean ob where ob.loginName = ?1", bean.getLoginName());
        if(userBeans!=null&&userBeans.size()>0){
            status.setFailure(true);
            status.setMsg(FUNCTION_NAME + "已经存在！");
            return false;
        }
        return true;
    }

    @Override
    public boolean isDelete(Long entityId, JsonStatus status) {
        if (userBeanDao.get(UserBean.class.getName(),entityId) == null) {
            status.setFailure(true);
            status.setMsg(FUNCTION_NAME + "已经被删除！");
            return false;
        }
        return true;
    }

    public void setShiroService(IShiroService shiroService) {
        this.shiroService = shiroService;
    }

    //    public void setUserBeanDao(IUserBeanDao userBeanDao) {
//        this.userBeanDao = userBeanDao;
////        super.init(userBeanDao, UserBean.class.getName());
//    }
//
//    public void setRoleBeanDao(IRoleBeanDao roleBeanDao) {
//        this.roleBeanDao = roleBeanDao;
//    }

    public IRoleBeanDao getRoleBeanDao() {
        return roleBeanDao;
    }

    public void setRoleBeanDao(IRoleBeanDao roleBeanDao) {
        this.roleBeanDao = roleBeanDao;
    }

    public IUserBeanDao getUserBeanDao() {
        return userBeanDao;
    }

    public void setUserBeanDao(IUserBeanDao userBeanDao) {
        this.userBeanDao = userBeanDao;
        super.init(userBeanDao, UserBean.class.getName());
    }

    public void init() {
        /*UserBeanImpl user = new UserBeanImpl();
        user.setName("test");
        user.setPassword("hello");
        user = addUser(user);
        List<UserBeanImpl> list = this.getAllUser();

        System.out.print("system is called " + list.size());*/
    }



    public JsonData getAllUser() {
        JsonData jsonData=new JsonData();
        List<UserBean> users=userBeanDao.getAll(UserBean.class.getName());
        List<PersistentEntity> persistentEntities=new ArrayList<PersistentEntity>();
        if(users!=null&&users.size()>0){
            for(UserBean user:users){
                if(user!=null) {
                    persistentEntities.add((PersistentEntity)user);
                }
            }
        }
        jsonData.setData(persistentEntities);
        jsonData.setTotalCount((long) users.size());
       return jsonData;
    }

    @Override
    public List<UserBean> queryUser(UserBean userBean, int is_ent) {

        return userBeanDao.find("select a from UserBean a where a.is_ent_user =?1 and a.name LIKE ?2", is_ent, "%" + userBean.getName() + "%");
    }

    @Override
    public List<UserBean> queryUser(String userName, int pageNumber, int pageSize) {

        return userBeanDao.findbyPage("select a from UserBean a where a.name LIKE ?1", pageNumber, pageSize, "%" + userName + "%");
    }

    @Override
    public List<UserBean> query(UserBean userBean, int is_ent) {
        return queryUser(userBean, is_ent);
    }

    /**
     * 生成roleList列表，以逗号分隔
     *
     * @param userBean 用户
     * @return
     */
    @Override
    public String getRoleList(UserBean userBean) {
        List<RoleBean> roleBeanList = roleBeanDao.find("select r from RoleBean r join r.userList u where u=?1", userBean);
        String value = "";
        if (roleBeanList != null && roleBeanList.size() > 0) {
            for (RoleBean roleBean : roleBeanList) {
                value = value + roleBean.getName() + ",";
            }
            //截掉最后一个“，”
            if (value.length() > 1)
                value = value.substring(0, value.length() - 1);
        }
        return value;
    }

    @Override
    public void saveUserRole(UserBean userBean, List<String> roleSelect) {
        List<RoleBean> roleBeanList = userBean.getRoleList();
        //清空全部角色
        roleBeanList.clear();
        //重新添加角色
        if (roleSelect != null && roleSelect.size() > 0) {
            for (String role : roleSelect) {
                roleBeanList.add(roleBeanDao.getRole(role));
            }
        }
        userBeanDao.save(userBean);
    }

    @Override
    public void saveUserRoleNew(UserBean userBean, List<String> roleSelect) {
        List<RoleBean> roleBeanList = new ArrayList<RoleBean>();
        if (userBean.getId() == 0L) {       //为新用户对象
            userBean = userBeanDao.save(userBean);
        } else {                            //取出用户的角色集合
            roleBeanList = userBeanDao.get(UserBean.class.getName(), userBean.getId()).getRoleList();
        }
        //删除全部该角色下的用户
        if (roleSelect != null) {
            removeRole(userBean, roleBeanList);
            if (roleSelect.size() > 0) {
                //添加角色到用户
                for (String roleName : roleSelect) {
                    RoleBean roleBean = roleBeanDao.getRole(roleName);
                    UserBean user = userBeanDao.getUser(userBean.getId());
                    if (!user.getRoleList().contains(roleBean)) {
                        user.getRoleList().add(roleBean);
                        userBeanDao.save(user);
                    }
                }
            }
        } else {
            userBeanDao.save(userBean);
        }
    }

    private void removeRole(UserBean userBean, List<RoleBean> roleBeanList) {
        for (RoleBean roleBean : roleBeanList) {
            userBean.getRoleList().remove(roleBean);
            userBeanDao.save(userBean);
        }
    }

    @Override
    public String getCurrentUserName() {
        Session session = SecurityUtils.getSubject().getSession();
        UserBean userBean = (UserBean) session.getAttribute(PermissionConstant.SYS_CURRENT_USER);
        if (userBean == null) {
            SecurityUtils.getSubject().logout();
        }
        return userBean.getName();
    }

    @Override
    public String getCurrentUserLoginName() {
        Session session = SecurityUtils.getSubject().getSession();
        UserBean userBean = (UserBean) session.getAttribute(PermissionConstant.SYS_CURRENT_USER);
        if (userBean == null) {
            SecurityUtils.getSubject().logout();
        }
        return userBean.getLoginName();
    }

    @Override
    public UserBean getCurrentUser() {
        try {
            SecurityUtils.setSecurityManager((WebSecurityManager) JNDIHelper.getJNDIServiceForName(WebSecurityManager.class.getName()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Session session = SecurityUtils.getSubject().getSession();
        UserBean userBean = (UserBean) session.getAttribute(PermissionConstant.SYS_CURRENT_USER);
        if (userBean == null) {
            SecurityUtils.getSubject().logout();
        }
        return userBean;
    }

    @Override
    public String getCurrUserInQhdm() {
        UserBean userBean = getCurrentUser();
        if (userBean != null) {
            List<String> qhdmList = userBeanDao.findByNativeSql("select t.xzqh_dm " +
                    "from urg_ent_organization t where t.jgdm=" + userBean.getJgdm(), String.class);
            if (qhdmList != null && qhdmList.size() > 0) {
                return qhdmList.get(0);
            }
        }
        return "";

    }


    @Override
    public List getUserTokenListByIds(Long id) {
        return userBeanDao.findByNativeSql("select s.token from sys_user_rel s where s.token is not null and s.user_id in (" + id + ")", String.class);
    }

    @Override
    public List getUserTokenListJgdm(String jgdm, long user_id) {
        String jgdmStr = jgdm.replaceAll("(0+)$", "");
        return userBeanDao.findByNativeSql("select sur.token from sys_user s " +
                " left join sys_user_rel sur on sur.user_id=s.id where s.id!=" + user_id +
                " and sur.token is not null and s.jgdm like '" + jgdmStr + "%'", String.class);
    }

    @Override
    public List getUserTokenListByNoticeId(Long notice_id, int reply_type, long user_id) {
        return userBeanDao.findByNativeSql("select s.token from sys_user_rel s where s.token is not null and s.user_id in " +
                "(select c.user_id from coop_notice_user_rel c " +
                "where c.user_id != " + user_id + " and c.notice_id=" + notice_id + " and c.reply_type=" + reply_type + ")", String.class);
    }

    @Override
    public List getUseridListByGgdm(String jgdm, long user_id) {
        String jgdmStr = jgdm.replaceAll("(0+)$", "");
        return userBeanDao.findByNativeSql("select s.id from sys_user s " +
                " where s.id!=" + user_id + " and s.jgdm like '" + jgdmStr + "%'", Long.class);
    }

    @Override
    public List<UserBean> getUserListByCond(int is_ent_user) {
        return userBeanDao.findByNativeSql("select * from sys_user u where u.is_ent_user=" + is_ent_user, UserBean.class);
    }

    @Override
    public UserBean getUserBeanByUsername(String username) {
        return userBeanDao.findUnique("select a from UserBean a where a.loginName = ?1", username);
    }

    @Override
    public void setUserUnavailable(String relateId) {
        userBeanDao.update("update sys_user set available=0 where relateId=" + relateId);
    }

    @Override
    public UserBean getUserByRelateId(String relateId) {
        return userBeanDao.findUnique("select a from UserBean a where a.relateId = ?1", relateId);
    }

}
