package cn.com.rexen.admin.api.biz;

import cn.com.rexen.admin.entities.RoleBean;
import cn.com.rexen.admin.entities.UserBean;
import cn.com.rexen.app.dto.model.AuthorizationDTO;
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

    JsonData getAllRole();


    /**
     * 返回授权树
     * @return
     */
    AuthorizationDTO getAuthorizationTree(long roleId);

    /**
     * 保存授权信息
     * @param roleId
     * @param authorizationIds
     */
    JsonStatus saveAuthorization(String roleId, String authorizationIds);

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

    /**
     * 返回用户下所有角色
     * @param userId
     * @return
     */
    List<RoleBean> getRolesByUserId(long userId);

    /**
     * 返回工作组下所有角色
     * @param workGroupId
     * @return
     */
    List<RoleBean> getRolesByWorkGorupId(long workGroupId);

    /**
     * 保存角色与用户关联
     * @param roleId
     * @param userId
     * @return
     */
    JsonStatus saveRoleUsers(long roleId, String userId);


    /**
     * 根据角色ID获得所有用户
     * @param id
     * @return
     */
    List getUsersByRoleId(long id);


}
