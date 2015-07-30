package cn.com.rexen.app.core;

import cn.com.rexen.app.api.biz.IApplicationBeanService;
import cn.com.rexen.app.api.dao.IApplicationBeanDao;
import cn.com.rexen.app.entities.ApplicationBean;
import cn.com.rexen.core.api.biz.JsonStatus;
import cn.com.rexen.core.api.persistence.JsonData;
import cn.com.rexen.core.api.persistence.PersistentEntity;
import cn.com.rexen.core.api.security.IShiroService;
import cn.com.rexen.core.impl.biz.GenericBizServiceImpl;
import cn.com.rexen.core.util.Assert;
import org.apache.commons.lang.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 应用服务实现
 * @author majian <br/>
 *         date:2015-7-27
 * @version 1.0.0
 */
public class ApplicationBeanServiceImpl extends GenericBizServiceImpl implements IApplicationBeanService {
    private static final String FUNCTION_NAME = "应用";
    private IApplicationBeanDao applicationBeanDao;
    private IShiroService shiroService;

    public void setShiroService(IShiroService shiroService) {
        this.shiroService = shiroService;
    }

    public void setApplicationBeanDao(IApplicationBeanDao applicationBeanDao) {
        this.applicationBeanDao = applicationBeanDao;
        super.init(applicationBeanDao, ApplicationBean.class.getName());
    }

    @Override
    public void beforeUpdateEntity(PersistentEntity entity, JsonStatus status) {
        Assert.notNull(entity, "实体不能为空.");
        String userName = shiroService.getCurrentUserName();
        Assert.notNull(userName, "用户名不能为空.");
        if(StringUtils.isNotEmpty(userName)) {
            entity.setUpdateBy(userName);
        }
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
    public boolean isDelete(Long entityId, JsonStatus status) {
        if (applicationBeanDao.get(ApplicationBean.class.getName(),entityId) == null) {
            status.setFailure(true);
            status.setMsg(FUNCTION_NAME + "已经被删除！");
            return false;
        }
        return true;
    }

    @Override
    public boolean isUpdate(PersistentEntity entity, JsonStatus status) {
        Assert.notNull(entity, "实体不能为空.");
        ApplicationBean bean=(ApplicationBean)entity;
        List<ApplicationBean> beans= applicationBeanDao.find("select ob from ApplicationBean ob where ob.name = ?1", bean.getName());
        if(beans!=null&&beans.size()>0){
            ApplicationBean applicationBean=beans.get(0);
            if(applicationBean.getId()!=entity.getId()) {
                status.setFailure(true);
                status.setMsg(FUNCTION_NAME + "已经存在,请检查名称！");
                return false;
            }
        }
        beans= applicationBeanDao.find("select ob from ApplicationBean ob where ob.code = ?1", bean.getCode());
        if(beans!=null&&beans.size()>0){
            ApplicationBean applicationBean=beans.get(0);
            if(applicationBean.getId()!=entity.getId()) {
                status.setFailure(true);
                status.setMsg(FUNCTION_NAME + "已经存在,请检查代码！");
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean isSave(PersistentEntity entity, JsonStatus status) {
        Assert.notNull(entity, "实体不能为空.");
        ApplicationBean bean=(ApplicationBean)entity;
        List<ApplicationBean> beans= applicationBeanDao.find("select ob from ApplicationBean ob where ob.name = ?1 ", bean.getName());
        if(beans!=null&&beans.size()>0){
            status.setFailure(true);
            status.setMsg(FUNCTION_NAME + "已经存在,请检查名称！");
            return false;
        }
        beans= applicationBeanDao.find("select ob from ApplicationBean ob where ob.code = ?1 ", bean.getCode());
        if(beans!=null&&beans.size()>0){
            status.setFailure(true);
            status.setMsg(FUNCTION_NAME + "已经存在,请检查代码！");
            return false;
        }
        return true;
    }



}