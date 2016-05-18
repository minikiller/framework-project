package cn.com.rexen.message.dao;

import cn.com.rexen.message.api.dao.IMessageBeanDao;
import cn.com.rexen.message.entities.MessageBean;
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
public class MessageBeanDaoImpl extends GenericDao<MessageBean, Long> implements IMessageBeanDao {
    @Override
    @PersistenceContext(unitName = "message-cm")
    public void setEntityManager(EntityManager em) {
        super.setEntityManager(em);
    }
    //todo add custom query

}
