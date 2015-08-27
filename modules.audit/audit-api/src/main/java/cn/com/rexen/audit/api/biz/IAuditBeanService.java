package cn.com.rexen.audit.api.biz;

import cn.com.rexen.audit.entities.AuditBean;
import cn.com.rexen.core.api.biz.IBizService;

import java.util.List;

/**
 * @类描述：审计管理
 * @创建人： sunlf
 * @创建时间：2014/10/10
 * @修改人：
 * @修改时间：
 * @修改备注：
 */
public interface IAuditBeanService extends IBizService {
    public List<AuditBean> query(String title);
}
