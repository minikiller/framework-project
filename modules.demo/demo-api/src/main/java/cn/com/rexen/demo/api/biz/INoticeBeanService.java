package cn.com.rexen.demo.api.biz;

import cn.com.rexen.core.api.biz.IBizService;
import cn.com.rexen.core.api.biz.JsonStatus;
import cn.com.rexen.demo.entities.NoticeBean;

import java.util.List;

/**
 * @类描述：公告管理
 * @创建人： sunlf
 * @创建时间：2014/10/10
 * @修改人：
 * @修改时间：
 * @修改备注：
 */
public interface INoticeBeanService extends IBizService {
    List<NoticeBean> query(String title);

    JsonStatus startProcess(String id);

    JsonStatus completeTask(String taskId, String accepted, String comment);
    JsonStatus completeTask(String taskId);
}
