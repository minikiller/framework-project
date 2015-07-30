package cn.com.rexen.admin.core;

import cn.com.rexen.admin.api.biz.IDictBeanService;
import cn.com.rexen.admin.api.dao.IDictBeanDao;
import cn.com.rexen.admin.entities.DictBean;
import cn.com.rexen.core.api.biz.JsonStatus;
import cn.com.rexen.core.api.persistence.JsonData;
import cn.com.rexen.core.api.persistence.PersistentEntity;
import cn.com.rexen.core.api.security.IShiroService;
import cn.com.rexen.core.impl.biz.GenericBizServiceImpl;
import cn.com.rexen.core.util.Assert;
import org.apache.commons.lang.StringUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @类描述：字典服务实现类
 * @创建人：sunlf
 * @创建时间：2014-05-14 下午1:59
 * @修改人：
 * @修改时间：
 * @修改备注：
 */

public class DictBeanServiceImpl extends GenericBizServiceImpl implements IDictBeanService {
    private static final String FUNCTION_NAME = "字典";
    private IDictBeanDao dictBeanDao;
    private IShiroService shiroService;



    public void setShiroService(IShiroService shiroService) {
        this.shiroService = shiroService;
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


    public void setDictBeanDao(IDictBeanDao dictBeanDao) {
        this.dictBeanDao = dictBeanDao;
        super.init(dictBeanDao, DictBean.class.getName());
    }

    @Override
    public List<DictBean> getDictList(String type) {
        return dictBeanDao.getDictList(type);
    }

    @Override
    public Map<String, String> getDictMap(String type) {
        List<DictBean> dictBeanList = getDictList(type);
        Map map = new HashMap();
        if (dictBeanList.size() > 0) {
            for (DictBean dictBean : dictBeanList)
                map.put(dictBean.getValue(), dictBean.getLabel());
        }
        return map;
    }

    @Override
    public List<DictBean> query(DictBean dictBean) {
        return dictBeanDao.find("select a from DictBean a where a.type like ?1", "%" + dictBean.getType() + "%");
    }


    public JsonData getAll(int page,int limit) {
        return dictBeanDao.getAll(page, limit, DictBean.class.getName());
    }

}
