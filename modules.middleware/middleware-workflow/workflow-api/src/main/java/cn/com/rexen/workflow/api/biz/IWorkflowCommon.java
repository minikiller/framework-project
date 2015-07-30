package cn.com.rexen.workflow.api.biz;

import cn.com.rexen.core.api.IService;
import cn.com.rexen.workflow.api.model.BizDataDTO;
import cn.com.rexen.workflow.api.model.FormDTO;
import org.activiti.engine.task.Task;

/**
 * Created by sunlf on 2015/7/30.
 * 用于获得Form和BizData数据的服务
 */
public interface IWorkflowCommon extends IService {
    FormDTO getForm(Task task);

    BizDataDTO getBizData(String processDefinitionId);
}
