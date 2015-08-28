package cn.com.rexen.admin.persist.openjpa;

import cn.com.rexen.admin.api.dao.IWorkGroupUserBeanDao;
import cn.com.rexen.admin.entities.WorkGroupUserBean;
import cn.com.rexen.core.impl.persistence.GenericOpenJpaDao;

/**
 * 工作组用户DAO实现
 * @author majian <br/>
 *         date:2015-7-23
 * @version 1.0.0
 */
public class WorkGroupUserBeanDaoOpenjpa extends GenericOpenJpaDao<WorkGroupUserBean, Long> implements IWorkGroupUserBeanDao {
    private final String className = WorkGroupUserBean.class.getName();

    @Override
    public void deleteByWorkGroupId(long id) {
        super.updateNativeQuery("delete from sys_workGroup_user where groupId="+id);
    }
}
