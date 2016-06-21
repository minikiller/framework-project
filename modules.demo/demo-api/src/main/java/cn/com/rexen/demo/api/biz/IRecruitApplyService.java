package cn.com.rexen.demo.api.biz;

import cn.com.rexen.core.api.biz.IBizService;
import cn.com.rexen.core.api.biz.JsonStatus;
import cn.com.rexen.demo.entities.RecruitApplyBean;

/**
 * Created by Administrator on 2016/6/15.
 */
public interface IRecruitApplyService extends IBizService<RecruitApplyBean> {
    JsonStatus startProcess(String id);

    JsonStatus completeTask(String taskId, String accepted, String comment);
}
