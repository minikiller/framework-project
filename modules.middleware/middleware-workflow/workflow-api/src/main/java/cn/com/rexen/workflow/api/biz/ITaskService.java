package cn.com.rexen.workflow.api.biz;

import cn.com.rexen.core.api.IService;
import cn.com.rexen.workflow.api.model.JsonData;

/**
 * Created by sunlf on 2015/7/31.
 */
public interface ITaskService extends IService {
    JsonData getTasks(int page, int limit);
}
