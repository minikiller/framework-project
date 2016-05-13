package cn.com.rexen.message.dao;

import cn.com.rexen.message.api.dao.ISenderMessageBeanDao;
import cn.com.rexen.message.entities.SenderMessageBean;
import cn.com.rexen.core.impl.persistence.GenericDao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @类描述：
 * @创建人：
 * @创建时间：
 * @修改人：
 * @修改时间：
 * @修改备注：
 */
public class SenderMessageBeanDaoImpl extends GenericDao<SenderMessageBean, Long> implements ISenderMessageBeanDao {
    @Override
    @PersistenceContext(unitName = "message-cm")
    public void setEntityManager(EntityManager em) {
        super.setEntityManager(em);
    }
    //todo add custom query
}
