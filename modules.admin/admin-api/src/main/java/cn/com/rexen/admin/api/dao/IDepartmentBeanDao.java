package cn.com.rexen.admin.api.dao;

import cn.com.rexen.admin.entities.DepartmentBean;
import cn.com.rexen.admin.entities.OrganizationBean;
import cn.com.rexen.core.api.persistence.IGenericDao;

/**
 * 部门管理DAO接口
 * @author majian <br/>
 *         date:2015-7-21
 * @version 1.0.0
 */
public interface IDepartmentBeanDao extends IGenericDao<DepartmentBean, Long> {


    /**
     * 获得bean.
     * @param id
     * @return
     */
    DepartmentBean get(Long id);

    /**
     * 删除一个bean.
     *
     * @param id ID
     */
    void remove(Long id);


    /**
     * 保存bean.
     *
     * @param bean the object to be saved
     * @return the persisted User object
     */
    DepartmentBean save(DepartmentBean bean);
}
