package cn.com.rexen.admin.api.biz;

import cn.com.rexen.admin.entities.WorkGroupBean;
import cn.com.rexen.admin.entities.WorkGroupUserBean;
import cn.com.rexen.core.api.biz.IBizService;
import cn.com.rexen.core.api.biz.JsonStatus;
import cn.com.rexen.core.api.persistence.JsonData;

import java.util.List;

/**
 * 工作组管理服务接口
 * @author majian <br/>
 *         date:2015-7-27
 * @version 1.0.0
 */
public interface IWorkGroupBeanService extends IBizService {
    /**
     * 查询工作组
     * @param bean
     * @return
     */
    List<WorkGroupBean> query(WorkGroupBean bean);

    /**
     * 返回全部工作组
     * @param page
     * @param limit
     * @return
     */
    JsonData getAllWorkGroup(int page, int limit);

    /**
     * 返回工作组下所有用户
     * @param id
     * @return
     */
    List getUsersByWorkGroupId(long id);

    /**
     * 返回工作组下所有角色
     * @param id
     * @return
     */
    List getRolesByWorkGroupId(long id);

    /**
     * 保存工作组与用户关联
     * @param workGroupId
     * @param userIds
     * @return
     */
    JsonStatus saveWorkGroupUsers(long workGroupId, String userIds);

    /**
     * 保存工作组与角色关联
     * @param workGroupId
     * @param roleIds
     * @return
     */
    JsonStatus saveWorkGroupRoles(long workGroupId, String roleIds);

    /**
     * 返回用户下所有关联工作组
     * @param userId
     * @return
     */
    List<WorkGroupUserBean> getWorkGroupUserBeanByUserId(long userId);
}
