package cn.com.rexen.demo.web.impl.form;

import cn.com.rexen.demo.api.Const;
import cn.com.rexen.workflow.api.web.IFormHandler;

/**
 * Created by sunlf on 2016/2/25.
 * 印章申请审批页面实现类
 */
public class SealApplyAuditFormImpl implements IFormHandler {
    @Override
    public String getFormKey() {
        return "audit.form";
    }

    @Override
    public String getProcessDefinitionId() {
        return Const.PROCESS_SEAL_APPLY_KEY_NAME;
    }

    @Override
    public String getComponentClass() {
        return "kalix.demo.carApply.view.CarApplyViewForm";
    }
}
