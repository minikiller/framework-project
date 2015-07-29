package cn.com.rexen.admin.api.dao;

import cn.com.rexen.admin.entities.WorkGroupRoleBean;
import cn.com.rexen.admin.entities.WorkGroupUserBean;
import cn.com.rexen.core.api.persistence.IGenericDao;

/**
 * 工作组角色关联DAO接口
 * @author majian <br/>
 *         date:2015-7-27
 * @version 1.0.0
 */
public interface IWorkGroupRoleBeanDao extends IGenericDao<WorkGroupRoleBean, Long> {
    public void deleteByWorkGroupId(long id);
}
