package cn.com.rexen.admin.persist.openjpa;

import cn.com.rexen.admin.api.dao.IWorkGroupBeanDao;
import cn.com.rexen.admin.entities.WorkGroupBean;

/**
 * 工作组管理DAO实现
 * @author majian <br/>
 *         date:2015-7-23
 * @version 1.0.0
 */
public class WorkGroupBeanDaoImpl extends BaseAdminDao<WorkGroupBean, Long> implements IWorkGroupBeanDao {
    private final String className = WorkGroupBean.class.getName();

    /**
     * Constructor that sets the entity to User.class.
     */
    public WorkGroupBeanDaoImpl() {
//        super.setEntityManager(UserBean.class);
    }
}
