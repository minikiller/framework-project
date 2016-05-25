package cn.com.rexen.workflow.dao;

import cn.com.rexen.core.impl.persistence.GenericDao;
import cn.com.rexen.workflow.api.dao.ICategoryBeanDao;
import cn.com.rexen.workflow.entities.CategoryBean;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * 类描述:    工作流分类Dao实现类
 * 创建人:    sunlf
 * 创建时间:  2016/5/24 15:57
 * 修改人:
 * 修改时间:
 * 修改备注:  [说明本次修改内容]
 */
public class CategoryBeanDaoImpl extends GenericDao<CategoryBean, Long> implements ICategoryBeanDao {
    @Override
    @PersistenceContext(unitName = "workflow-cm")
    public void setEntityManager(EntityManager em) {
        super.setEntityManager(em);
    }
}
