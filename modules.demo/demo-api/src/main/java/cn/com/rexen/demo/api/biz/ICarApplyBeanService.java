package cn.com.rexen.demo.api.biz;

import cn.com.rexen.core.api.biz.IBizService;
import cn.com.rexen.core.api.biz.JsonStatus;
import cn.com.rexen.demo.entities.CarApplyBean;

/**
 * @author sunlf
 */
public interface ICarApplyBeanService extends IBizService<CarApplyBean> {
    JsonStatus startProcess(String id);

    JsonStatus completeTask(String taskId, String accepted, String comment);
}
