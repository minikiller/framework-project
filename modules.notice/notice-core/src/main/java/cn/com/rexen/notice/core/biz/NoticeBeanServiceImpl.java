package cn.com.rexen.notice.core.biz;

import cn.com.rexen.core.impl.biz.GenericBizServiceImpl;
import cn.com.rexen.notice.api.biz.INoticeBeanService;
import cn.com.rexen.notice.api.dao.INoticeBeanDao;
import cn.com.rexen.notice.entities.NoticeBean;

import java.util.List;
import java.util.UUID;

/**
 * @类描述：公告管理
 * @创建人： zhangqingxin
 * @创建时间：2014/10/10
 * @修改人：
 * @修改时间：
 * @修改备注：
 */
public class NoticeBeanServiceImpl extends GenericBizServiceImpl implements INoticeBeanService {
    private INoticeBeanDao noticeBeanDao;
    private String uuid;

    public NoticeBeanServiceImpl() {
        uuid = UUID.randomUUID().toString();
    }

    public void setNoticeBeanDao(INoticeBeanDao noticeBeanDao) {
        this.noticeBeanDao = noticeBeanDao;
        super.init(noticeBeanDao, NoticeBean.class.getName());
    }

    @Override
    public List<NoticeBean> query(String title) {
        return noticeBeanDao.find("select n from NoticeBean n where n.title LIKE ?1 ", "%" + title + "%");
    }
}
