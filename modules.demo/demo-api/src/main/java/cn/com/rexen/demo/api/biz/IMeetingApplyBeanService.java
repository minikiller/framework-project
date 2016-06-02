package cn.com.rexen.demo.api.biz;

import cn.com.rexen.core.api.biz.IBizService;
import cn.com.rexen.core.api.biz.JsonStatus;
import cn.com.rexen.core.api.persistence.JsonData;
import cn.com.rexen.demo.entities.MeetingApplyBean;

import java.util.Date;

/**
 * @author sunlf
 */
public interface IMeetingApplyBeanService extends IBizService<MeetingApplyBean> {
    JsonStatus startProcess(String id);
    JsonStatus completeTask(String taskId, String accepted, String comment);

    JsonStatus checkDateTime(String jsonStr);

    //会议室预约情况
    JsonData reservation(Date date);

    JsonData reservation(long roomId, Date date);
}
