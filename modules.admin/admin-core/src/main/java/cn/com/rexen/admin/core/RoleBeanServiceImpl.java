package cn.com.rexen.admin.core;

import cn.com.rexen.admin.api.biz.IRoleBeanService;
import cn.com.rexen.admin.api.dao.IRoleBeanDao;
import cn.com.rexen.admin.api.dao.IUserBeanDao;
import cn.com.rexen.admin.entities.RoleBean;
import cn.com.rexen.admin.entities.UserBean;
import cn.com.rexen.core.api.biz.JsonStatus;
import cn.com.rexen.core.api.persistence.JsonData;
import cn.com.rexen.core.impl.biz.GenericBizServiceImpl;

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
}