package cn.com.rexen.admin.api.dao;

import cn.com.rexen.admin.entities.WorkGroupBean;
import cn.com.rexen.admin.entities.WorkGroupUserBean;
import cn.com.rexen.core.api.persistence.IGenericDao;

/**
 * 工作组用户关联DAO接口
 * @author majian <br/>
 *         date:2015-7-27
 * @version 1.0.0
 */
public interface IWorkGroupUserBeanDao extends IGenericDao<WorkGroupUserBean, Long> {
    public void deleteByWorkGroupId(long id);
}
