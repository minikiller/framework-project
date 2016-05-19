package cn.com.rexen.demo.web.impl.form;

import cn.com.rexen.demo.api.Const;
import cn.com.rexen.workflow.api.web.IBizDataHandler;

/**
 * Created by sunlf on 2016/2/25.
 * 工作流历史查看显示业务数据
 */
public class MeetingApplyBizDataFormImpl implements IBizDataHandler {
    @Override
    public String getBizName() {
        return "Demo Data";
    }

    @Override
    public String getComponentClass() {
        return "kalix.demo.meetingApply.view.MeetingApplyViewForm";
    }

    @Override
    public String getProcessDefinitionId() {
        return Const.PROCESS_MEETING_APPLY_KEY_NAME;
    }
}
