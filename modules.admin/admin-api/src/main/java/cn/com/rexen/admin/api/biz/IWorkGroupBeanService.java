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
    public List<WorkGroupBean> query(WorkGroupBean bean);
    public JsonData getAllWorkGroup(int page,int limit);
    public List getUsersByWorkGroupId(long id);
    public List getRolesByWorkGroupId(long id);
    public JsonStatus saveWorkGroupUsers(long workGroupId,String userIds);
    public JsonStatus saveWorkGroupRoles(long workGroupId,String roleIds);
}
