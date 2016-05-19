package cn.com.rexen.demo.api.biz;

import cn.com.rexen.core.api.biz.IBizService;
import cn.com.rexen.core.api.persistence.JsonData;
import cn.com.rexen.demo.entities.WorkFlowBean;

import java.util.List;

/**
 * @author sunlf
 */
public interface IWorkFlowBeanService extends IBizService<WorkFlowBean> {
    List<WorkFlowBean> getCategories();

    JsonData getAllWorkFlow(String category);
}
