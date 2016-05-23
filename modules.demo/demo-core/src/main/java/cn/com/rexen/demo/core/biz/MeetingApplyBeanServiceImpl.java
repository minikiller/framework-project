package cn.com.rexen.demo.core.biz;

import cn.com.rexen.demo.api.biz.IMeetingApplyBeanService;
import cn.com.rexen.demo.api.dao.IMeetingApplyBeanDao;
import cn.com.rexen.demo.core.Const;
import cn.com.rexen.demo.entities.MeetingApplyBean;
import cn.com.rexen.workflow.core.impl.WorkflowGenericBizServiceImpl;

import java.util.Map;

/**
 * @author chenyanxu
 */
public class MeetingApplyBeanServiceImpl extends WorkflowGenericBizServiceImpl<IMeetingApplyBeanDao, MeetingApplyBean> implements IMeetingApplyBeanService {
    @Override
    public String getProcessKeyName() {
        return Const.PROCESS_MEETING_APPLY_KEY_NAME;
    }

    @Override
    public Map getVariantMap(Map map, MeetingApplyBean bean) {
        return map;
    }

    @Override
    public void writeClaimResult(String currentTaskName, String userName, MeetingApplyBean bean) {
        if (currentTaskName.equals("校务部文秘综合干事")) //申请部门负责人签字
            bean.setDepUser(userName);
        else if (currentTaskName.equals("校务部行政事务办主管")) //副校级领导审核
            bean.setSchoolAdminUser(userName);
        else if (currentTaskName.equals("校务部副部长")) //校务部签字
            bean.setSchoolUser(userName);
        else if (currentTaskName.equals("发起部门会议纪要审批")) //校务部主管领导审批（市外）
            bean.setSchoolUser(userName);
    }
}
