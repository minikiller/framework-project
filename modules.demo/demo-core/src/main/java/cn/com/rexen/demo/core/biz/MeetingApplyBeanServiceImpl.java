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

    }
}
