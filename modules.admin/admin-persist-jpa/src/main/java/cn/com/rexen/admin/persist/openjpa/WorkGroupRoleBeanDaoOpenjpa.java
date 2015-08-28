package cn.com.rexen.admin.persist.openjpa;

import cn.com.rexen.admin.api.dao.IWorkGroupRoleBeanDao;
import cn.com.rexen.admin.entities.WorkGroupRoleBean;
import cn.com.rexen.core.impl.persistence.GenericOpenJpaDao;

/**
 * 工作组角色DAO实现
 * @author majian <br/>
 *         date:2015-7-23
 * @version 1.0.0
 */
public class WorkGroupRoleBeanDaoOpenjpa extends GenericOpenJpaDao<WorkGroupRoleBean, Long> implements IWorkGroupRoleBeanDao {
    private final String className = WorkGroupRoleBean.class.getName();

    @Override
    public void deleteByWorkGroupId(long id) {
        super.updateNativeQuery("delete from sys_workGroup_role where groupId="+id);
    }
}
