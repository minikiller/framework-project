package cn.com.rexen.admin.api.biz;

import cn.com.rexen.admin.entities.WorkGroupBean;
import cn.com.rexen.admin.rest.model.AreaDTO;
import cn.com.rexen.admin.rest.model.WorkGroupDTO;
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
    public List<WorkGroupBean> query(WorkGroupBean bean);

    /**
     * 返回全部工作组
     * @param page
     * @param limit
     * @return
     */
    public JsonData getAllWorkGroup(int page,int limit);

    /**
     * 返回工作组下所有用户
     * @param id
     * @return
     */
    public List getUsersByWorkGroupId(long id);

    /**
     * 返回工作组下所有角色
     * @param id
     * @return
     */
    public List getRolesByWorkGroupId(long id);

    /**
     * 保存工作组与用户关联
     * @param workGroupId
     * @param userIds
     * @return
     */
    public JsonStatus saveWorkGroupUsers(long workGroupId,String userIds);

    /**
     * 保存工作组与角色关联
     * @param workGroupId
     * @param roleIds
     * @return
     */
    public JsonStatus saveWorkGroupRoles(long workGroupId,String roleIds);
}
