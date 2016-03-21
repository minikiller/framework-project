package cn.com.rexen.admin.api.dao;

import cn.com.rexen.admin.entities.RoleFunctionBean;
import cn.com.rexen.core.api.persistence.IGenericDao;

import java.util.List;

/**
 * 角色功能关联DAO接口
 * @author majian <br/>
 *         date:2015-7-27
 * @version 1.0.0
 */
public interface IRoleFunctionBeanDao extends IGenericDao<RoleFunctionBean, Long> {
    void deleteByRoleId(long id);

    List<RoleFunctionBean> getRoleFunctionsByRoleId(long roleId);
}
