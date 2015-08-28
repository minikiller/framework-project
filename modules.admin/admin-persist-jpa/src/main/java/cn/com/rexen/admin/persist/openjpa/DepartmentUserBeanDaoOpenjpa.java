package cn.com.rexen.admin.persist.openjpa;

import cn.com.rexen.admin.api.dao.IDepartmentUserBeanDao;
import cn.com.rexen.admin.entities.DepartmentUserBean;
import cn.com.rexen.core.impl.persistence.GenericOpenJpaDao;

import java.util.List;

/**
 * 部门用户DAO实现
 * @author majian <br/>
 *         date:2015-7-23
 * @version 1.0.0
 */
public class DepartmentUserBeanDaoOpenjpa extends GenericOpenJpaDao<DepartmentUserBean, Long> implements IDepartmentUserBeanDao {
    private final String className = DepartmentUserBean.class.getName();

    @Override
    public void deleteByDepartmentId(long id) {
        super.updateNativeQuery("delete from sys_department_user where depId="+id);
    }

    @Override
    public long findDepartmentIdByUserId(long id) {
        List<DepartmentUserBean> departmentUserBeanList=findByNativeSql("select * from sys_department_user where userId="+id,DepartmentUserBean.class,null);
        if(departmentUserBeanList!=null&&departmentUserBeanList.size()>0){
            return departmentUserBeanList.get(0).getDepId();
        }
        return 0;
    }
}
