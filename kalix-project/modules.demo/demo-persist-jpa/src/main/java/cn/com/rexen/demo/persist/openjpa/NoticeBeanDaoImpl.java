package cn.com.rexen.demo.persist.openjpa;

import cn.com.rexen.core.impl.persistence.GenericDao;
import cn.com.rexen.demo.api.dao.INoticeBeanDao;
import cn.com.rexen.demo.entities.NoticeBean;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.UUID;

/**
 * @类描述：公告管理
 * @创建人： zhangqingxin
 * @创建时间：2014/10/10
 * @修改人：
 * @修改时间：
 * @修改备注：
 */
public class NoticeBeanDaoImpl extends GenericDao<NoticeBean, Long> implements INoticeBeanDao {
    private String uuid;

    public NoticeBeanDaoImpl() {
        uuid = UUID.randomUUID().toString();
    }

    @Override
    @PersistenceContext(unitName = "demo-cm")
    public void setEntityManager(EntityManager em) {
        super.setEntityManager(em);
    }
}
