package cn.com.rexen.demo.web.impl;

import cn.com.rexen.demo.api.Const;
import cn.com.rexen.workflow.api.web.IFormHandler;

/**
 * Created by sunlf on 2015/8/4.
 * 审批页面实现类
 */
public class DemoModifyFormImpl implements IFormHandler {
    @Override
    public String getFormKey() {
        return "modify.form";
    }

    @Override
    public String getProcessDefinitionId() {
        return Const.WORKFLOW_PROCESS_KEY;
    }

    @Override
    public String getComponentClass() {
        return "Kalix.demo.view.ModifyWindow";
    }
}
