package cn.com.rexen.demo.web.impl.form;

import cn.com.rexen.demo.api.Const;
import cn.com.rexen.workflow.api.web.IFormHandler;

/**
 * Created by sunlf on 2016/2/25.
 * 会议室使用申请审批页面实现类
 */
public class MeetingApplyAuditFormImpl implements IFormHandler {
    @Override
    public String getFormKey() {
        return "audit.form";
    }

    @Override
    public String getProcessDefinitionId() {
        return Const.PROCESS_MEETING_APPLY_KEY_NAME;
    }

    @Override
    public String getComponentClass() {
        return "kalix.demo.meetingApply.view.MeetingApplyViewForm";
    }
}
