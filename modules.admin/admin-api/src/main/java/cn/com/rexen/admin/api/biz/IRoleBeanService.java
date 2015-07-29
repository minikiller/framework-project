package cn.com.rexen.admin.api.biz;

import cn.com.rexen.admin.entities.RoleBean;
import cn.com.rexen.admin.entities.UserBean;
import cn.com.rexen.core.api.biz.IBizService;
import cn.com.rexen.core.api.biz.JsonStatus;
import cn.com.rexen.core.api.persistence.JsonData;

import java.util.List;

/**
 * @类描述：角色管理业务接口类
 * @创建人：sunlf
 * @创建时间：2014-04-03 下午6:29
 * @修改人：
 * @修改时间：
 * @修改备注：
 */

public interface IRoleBeanService extends IBizService {
    /**
     * 获得角色名称列表
     *
     * @return
     */
    List<String> getRoleNameList();

    public JsonStatus addRole(RoleBean role);

    public JsonStatus deleteRole(Long id);

    public JsonStatus updateRole(RoleBean role);

    public JsonData getAllRole(int page,int limit);

    public JsonData getAllRole();


    /**
     * 根据用户获得角色名称列表
     *
     * @return
     */
    List<String> getRoleNameList(UserBean userBean);

    /**
     * 根据角色保存该角色关联的用户列表
     *
     * @param roleBean
     * @param userSelect
     */
    void saveRoleUser(RoleBean roleBean, List<UserBean> userSelect);

    List<RoleBean> query(RoleBean roleBean);

    /**
     * 通过role获得UserLIst
     *
     * @param roleBean
     * @return
     */
    List<UserBean> getUserList(RoleBean roleBean);

    public JsonStatus saveRoleUsers(long roleId, String userId);


    public List getUsersByRoleId(long id);

}
