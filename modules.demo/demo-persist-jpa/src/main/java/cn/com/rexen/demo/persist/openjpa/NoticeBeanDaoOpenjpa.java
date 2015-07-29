package cn.com.rexen.demo.persist.openjpa;

import cn.com.rexen.core.impl.persistence.GenericOpenJpaDao;
import cn.com.rexen.demo.api.dao.INoticeBeanDao;
import cn.com.rexen.demo.entities.NoticeBean;

import java.util.UUID;

/**
 * @类描述：公告管理
 * @创建人： zhangqingxin
 * @创建时间：2014/10/10
 * @修改人：
 * @修改时间：
 * @修改备注：
 */
public class NoticeBeanDaoOpenjpa extends GenericOpenJpaDao<NoticeBean, Long> implements INoticeBeanDao {
    private String uuid;

    public NoticeBeanDaoOpenjpa() {
        uuid = UUID.randomUUID().toString();
    }
}
