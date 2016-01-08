package cn.com.rexen.core.impl.biz;

import cn.com.rexen.core.api.biz.JsonStatus;
import cn.com.rexen.core.api.persistence.IGenericDao;
import cn.com.rexen.core.api.persistence.PersistentEntity;
import cn.com.rexen.core.api.security.IShiroService;
import cn.com.rexen.core.util.Assert;
import org.apache.commons.lang.StringUtils;

/**
 * @author chenyanxu
 */
public abstract class ShiroGenericBizServiceImpl<T extends IGenericDao, TP extends PersistentEntity> extends GenericBizServiceImpl<T, TP> {
    private IShiroService shiroService;

    @Override
    public void beforeSaveEntity(TP entity, JsonStatus status) {
        String userName = shiroService.getCurrentUserName();
        Assert.notNull(userName, "用户名不能为空.");
        if (StringUtils.isNotEmpty(userName)) {
            entity.setCreateBy(userName);
            entity.setUpdateBy(userName);
        }
    }

    @Override
    public void beforeUpdateEntity(TP entity, JsonStatus status) {
        String userName = shiroService.getCurrentUserName();
        Assert.notNull(userName, "用户名不能为空.");
        if (StringUtils.isNotEmpty(userName)) {
            entity.setUpdateBy(userName);
        }
    }

    public IShiroService getShiroService() {
        return this.shiroService;
    }

    public void setShiroService(IShiroService shiroService) {
        this.shiroService = shiroService;
    }
}
