package cn.com.rexen.audit.core.biz;

import cn.com.rexen.audit.api.biz.IAuditBeanService;
import cn.com.rexen.audit.core.AuditUtil;
import cn.com.rexen.audit.entities.AuditBean;
import cn.com.rexen.core.api.biz.JsonStatus;
import cn.com.rexen.core.api.persistence.IGenericDao;
import cn.com.rexen.core.api.persistence.PersistentEntity;
import cn.com.rexen.core.api.security.IShiroService;
import cn.com.rexen.core.impl.biz.GenericBizServiceImpl;

import javax.transaction.Transactional;

/**
 * 支持审计的业务服务基类
 * Created by sunlf on 2015/8/27.
 */

public abstract class AuditBizServiceImpl<T extends IGenericDao, TP extends PersistentEntity> extends GenericBizServiceImpl<T, TP> {
    protected AuditBean auditBean;
    protected IAuditBeanService auditBeanService;
    protected IShiroService shiroService;


    public AuditBizServiceImpl() {

    }

    public void setAuditBeanService(IAuditBeanService auditBeanService) {
        this.auditBeanService = auditBeanService;
    }

    public void setShiroService(IShiroService shiroService) {
        this.shiroService = shiroService;
    }

    @Override
    @Transactional
    public void beforeUpdateEntity(TP entity, JsonStatus status) {
        auditBean = new AuditBean();
        auditBean.setAppName(getAppName());
        auditBean.setFunName(getFunName());
        auditBean.setAction("更新");
        auditBean.setActor(shiroService.getCurrentUserName());
        final TP oldEntity = (TP) dao.get(entity.getId());

        auditBean.setContent(AuditUtil.Match(entity, oldEntity, entityClassName));
//        auditBean.setContent(AuditUtil.Match(oldEntity,entity));
        auditBeanService.saveEntity(auditBean);
    }

    @Override
    @Transactional
    public void beforeSaveEntity(TP entity, JsonStatus status) {
        auditBean = new AuditBean();
        auditBean.setAppName(getAppName());
        auditBean.setFunName(getFunName());
        if (entity.getId() > 0) {
            auditBean.setAction("更新");
            final TP oldEntity = (TP) dao.get(entity.getId());
            auditBean.setContent(AuditUtil.Match(entity, oldEntity, entityClassName));
        } else {
            auditBean.setAction("新增");
            auditBean.setContent(entity.toString());
        }
        auditBean.setActor(shiroService.getCurrentUserName());
        auditBeanService.saveEntity(auditBean);
    }

    @Override
    @Transactional
    public void beforeDeleteEntity(Long id, JsonStatus status) {
        auditBean = new AuditBean();
        auditBean.setAppName(getAppName());
        auditBean.setFunName(getFunName());
        auditBean.setAction("删除");
        auditBean.setActor(shiroService.getCurrentUserName());
        auditBean.setContent(dao.get(id).toString());
        auditBeanService.saveEntity(auditBean);
    }

    /**
     * 获得应用名称
     *
     * @return
     */
    public abstract String getAppName();

    /**
     * 获得功能名称
     *
     * @return
     */
    public abstract String getFunName();
}
