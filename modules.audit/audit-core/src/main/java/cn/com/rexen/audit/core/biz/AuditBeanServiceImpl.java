package cn.com.rexen.audit.core.biz;

import cn.com.rexen.audit.api.biz.IAuditBeanService;
import cn.com.rexen.audit.api.dao.IAuditBeanDao;
import cn.com.rexen.audit.entities.AuditBean;
import cn.com.rexen.core.api.biz.JsonStatus;
import cn.com.rexen.core.impl.biz.GenericBizServiceImpl;

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
public class AuditBeanServiceImpl extends GenericBizServiceImpl implements IAuditBeanService {
    private IAuditBeanDao auditBeanDao;

    private JsonStatus jsonStatus = new JsonStatus();

    private String uuid;

    public AuditBeanServiceImpl() {
        uuid = UUID.randomUUID().toString();
    }

    public void setAuditBeanDao(IAuditBeanDao auditBeanDao) {
        this.auditBeanDao = auditBeanDao;
        super.init(auditBeanDao, AuditBean.class.getName());
    }


    @Override
    public List<AuditBean> query(String title) {
        return auditBeanDao.find("select n from auditBean n where n.title LIKE ?1 ", "%" + title + "%");
    }

}
