package cn.com.rexen.workflow.core.impl;

import cn.com.rexen.core.impl.biz.GenericBizServiceImpl;
import cn.com.rexen.workflow.api.biz.ICategoryBeanService;
import cn.com.rexen.workflow.api.dao.ICategoryBeanDao;
import cn.com.rexen.workflow.entities.CategoryBean;

/**
 * Created by Administrator on 2016-05-24.
 */
public class CategoryBeanServiceImpl extends GenericBizServiceImpl<ICategoryBeanDao, CategoryBean> implements ICategoryBeanService {
    public CategoryBeanServiceImpl() {
        super.init(CategoryBean.class.getName());
    }
}
