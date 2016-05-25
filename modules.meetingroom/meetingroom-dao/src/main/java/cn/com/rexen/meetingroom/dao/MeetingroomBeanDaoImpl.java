package cn.com.rexen.meetingroom.dao;


import cn.com.rexen.core.impl.persistence.GenericDao;
import cn.com.rexen.meetingroom.api.dao.IMeetingroomBeanDao;
import cn.com.rexen.meetingroom.entities.MeetingroomBean;

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
public class MeetingroomBeanDaoImpl extends GenericDao<MeetingroomBean, Long> implements IMeetingroomBeanDao {
    @Override
    @PersistenceContext(unitName = "meetingroom-cm")
    public void setEntityManager(EntityManager em) {
        super.setEntityManager(em);
    }
    //todo add custom query

}
