package cn.com.rexen.workflow.api.biz;

import cn.com.rexen.core.api.biz.IBizService;
import cn.com.rexen.core.api.persistence.JsonData;
import cn.com.rexen.workflow.entities.CategoryBean;


/**
 * @类描述：流程分类
 * @创建人： sunlf
 * @创建时间：2014/10/10
 * @修改人：
 * @修改时间：
 * @修改备注：
 */
public interface ICategoryBeanService extends IBizService<CategoryBean> {
    /**
     * 通过分类获得流程定义
     * @param type
     * @return
     */
    public JsonData getAllWorkFlow(String type);
}
