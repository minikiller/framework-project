package cn.com.rexen.demo.web.impl.form;

import cn.com.rexen.demo.api.Const;
import cn.com.rexen.workflow.core.impl.AbstractEndHandler;

/**
 * Created by sunlf on 2015/8/4.
 * 审批页面实现类
 */
public class DemoEndFormImpl extends AbstractEndHandler {
    @Override
    public String getProcessDefinitionId() {
        return Const.PROCESS_SEAL_APPLY_KEY_NAME;
    }

    @Override
    public String getFormClass() {
        return "kalix.demo.sealApply.view.SealApplyViewForm";
    }
}
