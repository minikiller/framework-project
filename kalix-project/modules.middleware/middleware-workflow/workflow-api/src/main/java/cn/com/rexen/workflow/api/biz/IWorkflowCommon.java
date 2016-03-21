package cn.com.rexen.workflow.api.biz;

import cn.com.rexen.core.api.IService;
import cn.com.rexen.workflow.api.model.BizDataDTO;
import cn.com.rexen.workflow.api.model.FormDTO;

/**
 * Created by sunlf on 2015/7/30.
 * 用于获得Form和BizData数据的服务
 */
public interface IWorkflowCommon extends IService {
    FormDTO getForm(String taskId);

    BizDataDTO getBizData(String processDefinitionId);
}
