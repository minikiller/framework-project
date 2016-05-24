package cn.com.rexen.bean.dao;

import cn.com.rexen.bean.api.dao.IMeetingroomBeanDao;
import cn.com.rexen.bean.entities.MeetingroomBean;
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
public class MeetingroomBeanDaoImpl extends GenericDao<MeetingroomBean, Long> implements IMeetingroomBeanDao {
    @Override
    @PersistenceContext(unitName = "meetingroom-cm")
    public void setEntityManager(EntityManager em) {
        super.setEntityManager(em);
    }
    //todo add custom query

}
