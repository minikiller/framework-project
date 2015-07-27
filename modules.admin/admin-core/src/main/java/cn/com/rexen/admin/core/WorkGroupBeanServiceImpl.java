package cn.com.rexen.admin.core;

import cn.com.rexen.admin.api.biz.IWorkGroupBeanService;
import cn.com.rexen.admin.api.dao.IWorkGroupBeanDao;
import cn.com.rexen.admin.entities.UserBean;
import cn.com.rexen.admin.entities.WorkGroupBean;
import cn.com.rexen.admin.rest.model.WorkGroupDTO;
import cn.com.rexen.core.api.biz.JsonStatus;
import cn.com.rexen.core.api.persistence.JsonData;
import cn.com.rexen.core.api.persistence.PersistentEntity;
import cn.com.rexen.core.api.security.IShiroService;
import cn.com.rexen.core.impl.biz.GenericBizServiceImpl;
import cn.com.rexen.core.util.Assert;
import cn.com.rexen.core.util.StringUtils;
import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;

import java.util.ArrayList;
import java.util.List;

/**
 * 工作组管理服务实现
 * @author majian <br/>
 *         date:2015-7-27
 * @version 1.0.0
 */
public class WorkGroupBeanServiceImpl extends GenericBizServiceImpl implements IWorkGroupBeanService {
    private static final String FUNCTION_NAME = "工作组";
    private IWorkGroupBeanDao workGroupBeanDao;
    private IShiroService shiroService;


    public void setShiroService(IShiroService shiroService) {
        this.shiroService = shiroService;
    }

    public void setWorkGroupBeanDao(IWorkGroupBeanDao dictBeanDao) {
        this.workGroupBeanDao = dictBeanDao;
        super.init(dictBeanDao, WorkGroupBean.class.getName());
    }

    @Override
    public List<WorkGroupBean> query(WorkGroupBean WorkGroupBean) {
        return workGroupBeanDao.find("select a from WorkGroupBean a where a.name like ?1", "%" + WorkGroupBean.getName() + "%");
    }

    @Override
    public void afterDeleteEntity(Long id, JsonStatus status) {

    }

    @Override
    public boolean isDelete(Long entityId, JsonStatus status) {
        if (workGroupBeanDao.get(WorkGroupBean.class.getName(),entityId) == null) {
            status.setFailure(true);
            status.setMsg(FUNCTION_NAME + "已经被删除！");
            return false;
        }
        return true;
    }

    @Override
    public void beforeSaveEntity(PersistentEntity entity, JsonStatus status) {
        String userName = shiroService.getCurrentUserName();
        Assert.notNull(userName, "用户名不能为空.");
        if(StringUtils.isNotEmpty(userName)) {
            entity.setCreateBy(userName);
            entity.setUpdateBy(userName);
        }
    }

    @Override
    public boolean isSave(PersistentEntity entity, JsonStatus status) {
        Assert.notNull(entity, "实体不能为空.");
        WorkGroupBean bean=(WorkGroupBean)entity;
        List<WorkGroupBean> beans= workGroupBeanDao.find("select ob from WorkGroupBean ob where ob.name = ?1", bean.getName());
        if(beans!=null&&beans.size()>0){
            status.setSuccess(false);
            status.setMsg(FUNCTION_NAME + "已经存在！");
            return false;
        }
        return true;
    }

    @Override
    public void beforeUpdateEntity(PersistentEntity entity, JsonStatus status) {
        Assert.notNull(entity, "实体不能为空.");
        WorkGroupBean oldWorkGroup=workGroupBeanDao.get(WorkGroupBean.class.getName(), entity.getId());
        WorkGroupBean WorkGroup=(WorkGroupBean)entity;
        String userName = shiroService.getCurrentUserName();
        Assert.notNull(userName, "用户名不能为空.");
        if(StringUtils.isNotEmpty(userName)) {
            WorkGroup.setUpdateBy(userName);
        }
    }

    @Override
    public JsonData getAllWorkGroup(int page,int limit) {
        return workGroupBeanDao.getAll(page,limit,WorkGroupBean.class.getName());
    }
}
