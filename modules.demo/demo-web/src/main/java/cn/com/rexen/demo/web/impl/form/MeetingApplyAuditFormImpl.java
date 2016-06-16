package cn.com.rexen.demo.web.impl.form;

import cn.com.rexen.demo.api.Const;
import cn.com.rexen.workflow.core.impl.AbstractAuditHandler;

/**
 * Created by sunlf on 2016/2/25.
 * 会议室使用申请审批页面实现类
 */
public class MeetingApplyAuditFormImpl extends AbstractAuditHandler {
    @Override
    public String getProcessDefinitionId() {
        return Const.PROCESS_MEETING_APPLY_KEY_NAME;
    }

    @Override
    public String getFormClass() {
        return "kalix.demo.meetingApply.view.MeetingApplyViewForm";
    }
}
