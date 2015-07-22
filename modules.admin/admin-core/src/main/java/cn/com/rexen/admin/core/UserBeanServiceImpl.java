package cn.com.rexen.admin.core;

import cn.com.rexen.admin.api.biz.IUserBeanService;
import cn.com.rexen.admin.api.dao.IRoleBeanDao;
import cn.com.rexen.admin.api.dao.IUserBeanDao;
import cn.com.rexen.admin.entities.RoleBean;
import cn.com.rexen.admin.entities.UserBean;
import cn.com.rexen.core.api.PermissionConstant;
import cn.com.rexen.core.api.biz.JsonStatus;
import cn.com.rexen.core.api.persistence.JsonData;
import cn.com.rexen.core.impl.biz.GenericBizServiceImpl;
import cn.com.rexen.core.util.JNDIHelper;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.web.mgt.WebSecurityManager;

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

    @Override
    public JsonStatus addUser(UserBean user) {
        JsonStatus jsonStatus = new JsonStatus();
        try {
            userBeanDao.saveUser(user);
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
    public JsonStatus deleteUser(Long id) {
        JsonStatus jsonStatus = new JsonStatus();
        try {
            if (userBeanDao.getUser(id) == null) {
                jsonStatus.setFailure(true);
                jsonStatus.setMsg(FUNCTION_NAME + "{" + id + "}不存在！");
            } else {
                userBeanDao.removeUser(id);
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
    public JsonStatus updateUser(UserBean user) {
        JsonStatus jsonStatus = new JsonStatus();
        try {
            userBeanDao.saveUser(user);
            jsonStatus.setSuccess(true);
            jsonStatus.setMsg("更新" + FUNCTION_NAME + "成功！");
        } catch (Exception e) {
            e.printStackTrace();
            jsonStatus.setFailure(true);
            jsonStatus.setMsg("更新" + FUNCTION_NAME + "失败！");
        }
        return jsonStatus;

    }

    public JsonData getAllUser(int page,int limit) {
       return userBeanDao.getAll(page,limit,UserBean.class.getName());
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
