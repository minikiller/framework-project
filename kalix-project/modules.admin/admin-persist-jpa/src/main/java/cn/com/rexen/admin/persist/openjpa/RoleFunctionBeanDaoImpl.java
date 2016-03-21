package cn.com.rexen.admin.persist.openjpa;

import cn.com.rexen.admin.api.dao.IRoleFunctionBeanDao;
import cn.com.rexen.admin.entities.RoleFunctionBean;

import java.util.List;

/**
 * 角色功能DAO实现
 * @author majian <br/>
 *         date:2015-7-23
 * @version 1.0.0
 */
public class RoleFunctionBeanDaoImpl extends BaseAdminDao<RoleFunctionBean, Long> implements IRoleFunctionBeanDao {
    private final String className = RoleFunctionBean.class.getName();

    @Override
    public void deleteByRoleId(long id) {
        super.updateNativeQuery("delete from sys_role_function where roleId="+id);
    }

    @Override
    public List<RoleFunctionBean> getRoleFunctionsByRoleId(long roleId) {
        return super.find("select rab from RoleFunctionBean rab where rab.roleId=?1",roleId);
    }
}
