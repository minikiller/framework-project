package cn.com.rexen.attachment.persist.openjpa;


import cn.com.rexen.core.impl.persistence.GenericDao;
import cn.com.rexen.attachment.api.dao.IAttachmentBeanDao;
import cn.com.rexen.attachment.entities.AttachmentBean;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by dell on 14-1-16.
 */
public class AttachmentBeanDaoImpl extends GenericDao<AttachmentBean, Long> implements IAttachmentBeanDao {
    @Override
    @PersistenceContext(unitName = "attachment-cm")
    public void setEntityManager(EntityManager em) {
        super.setEntityManager(em);
    }
}
