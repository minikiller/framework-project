package cn.com.rexen.admin.api.dao;

import cn.com.rexen.admin.entities.RoleUserBean;
import cn.com.rexen.core.api.persistence.IGenericDao;

/**
 * 角色用户关联DAO接口
 * @author majian <br/>
 *         date:2015-7-27
 * @version 1.0.0
 */
public interface IRoleUserBeanDao extends IGenericDao<RoleUserBean, Long> {
    void deleteByRoleId(long id);
}
