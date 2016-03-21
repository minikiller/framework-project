package cn.com.rexen.app.persist.openjpa;

import cn.com.rexen.app.api.dao.IPluginBeanDao;
import cn.com.rexen.app.entities.PluginBean;
import cn.com.rexen.core.impl.persistence.GenericDao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * 插件DAO接口
 *
 * @author sunlf <br/>
 *         date:2015-10-27
 * @version 1.0.0
 */

public class PluginBeanDaoImpl extends GenericDao<PluginBean, Long> implements IPluginBeanDao {

    @Override
    @PersistenceContext(unitName = "app-cm")
    public void setEntityManager(EntityManager em) {
        super.setEntityManager(em);
    }
}
