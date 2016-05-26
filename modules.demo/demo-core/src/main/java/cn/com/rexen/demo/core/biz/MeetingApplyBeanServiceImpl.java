package cn.com.rexen.demo.core.biz;

import cn.com.rexen.core.api.biz.JsonStatus;
import cn.com.rexen.core.api.persistence.JsonData;
import cn.com.rexen.core.util.BeanUtil;
import cn.com.rexen.core.util.SerializeUtil;
import cn.com.rexen.demo.api.biz.IMeetingApplyBeanService;
import cn.com.rexen.demo.api.dao.IMeetingApplyBeanDao;
import cn.com.rexen.demo.core.Const;
import cn.com.rexen.demo.entities.MeetingApplyBean;
import cn.com.rexen.meetingroom.api.biz.IMeetingroomBeanService;
import cn.com.rexen.workflow.core.impl.WorkflowGenericBizServiceImpl;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author chenyanxu
 */
public class MeetingApplyBeanServiceImpl extends WorkflowGenericBizServiceImpl<IMeetingApplyBeanDao, MeetingApplyBean> implements IMeetingApplyBeanService {
    private IMeetingroomBeanService meetingroomBeanService;

    public IMeetingroomBeanService getMeetingroomBeanService() {
        return meetingroomBeanService;
    }

    public void setMeetingroomBeanService(IMeetingroomBeanService meetingroomBeanService) {
        this.meetingroomBeanService = meetingroomBeanService;
    }

    @Override
    public String getProcessKeyName() {
        return Const.PROCESS_MEETING_APPLY_KEY_NAME;
    }

    @Override
    public Map getVariantMap(Map map, MeetingApplyBean bean) {
        return map;
    }

    @Override
    public void writeClaimResult(String currentTaskId, String userName, MeetingApplyBean bean) throws NoSuchMethodException {
        try {
            // 将属性的首字符大写，方便构造get，set
            String name = currentTaskId.substring(0, 1).toUpperCase() + currentTaskId.substring(1);
            Method method = MeetingApplyBean.class.getDeclaredMethod("set" + name, String.class);
            method.invoke(bean, userName);
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

//        if (currentTaskName.equals("校务部文秘综合干事")) //申请部门负责人签字
//            bean.setDepUser(userName);
//        else if (currentTaskName.equals("校务部行政事务办主管")) //副校级领导审核
//            bean.setSchoolAdminUser(userName);
//        else if (currentTaskName.equals("校务部副部长")) //校务部签字
//            bean.setSchoolUser(userName);
//        else if (currentTaskName.equals("发起部门会议纪要审批")) //校务部主管领导审批（市外）
//            bean.setLaunchManagerUser(userName);
    }

    @Override
    public JsonData getAllEntityByQuery(int page, int limit, String jsonStr) {
        JsonData jsonData = new JsonData();
        jsonData = super.getAllEntityByQuery(page, limit, jsonStr);

        List beans = jsonData.getData();
        List ids = BeanUtil.getBeanFieldValueList(beans, "meetingroomId");
        List values = this.meetingroomBeanService.getFieldValuesByIds(ids.toArray(), "name");
        BeanUtil.setBeanListFieldValues(beans, "meetingroomName", values);

        jsonData.setTotalCount((long) beans.size());
        jsonData.setData(beans);

        return jsonData;
    }

    @Override
    public JsonStatus checkDateTime(String jsonStr) {
        MeetingApplyBean entity = SerializeUtil.unserializeJson(jsonStr, MeetingApplyBean.class);
        JsonStatus jsonStatus = new JsonStatus();
        long id;
        if (entity.getId() == 0) {
            id = -1;
        } else {
            id = entity.getId();
        }

        long meetingroomId = entity.getMeetingroomId();
        Date meetingDate = entity.getMeetingDate();
        Date beginTime = entity.getBeginTime();
        Date endTime = entity.getEndTime();
        Date beginDateTime = meetingDate;
        beginDateTime.setHours(beginTime.getHours());
        beginDateTime.setMinutes(beginTime.getMinutes());
        Date endDateTime = meetingDate;
        endDateTime.setHours(endTime.getHours());
        endDateTime.setMinutes(endTime.getMinutes());

        try {
            Date row_beginTime, row_endTime, row_beginDateTime, row_endDateTime;
            List<MeetingApplyBean> list = dao.find("select ob from MeetingApplyBean ob where ob.id <> ?1 and ob.meetingroomId=?2", id, meetingroomId);
            for (int i = 0; i < list.size(); i++) {
                row_beginTime = list.get(i).getBeginTime();
                row_endTime = list.get(i).getEndTime();
                row_beginDateTime = list.get(i).getMeetingDate();
                row_endDateTime = row_beginDateTime;

                row_beginDateTime.setHours(row_beginTime.getHours());
                row_beginDateTime.setMinutes(row_beginTime.getMinutes());
                row_endDateTime.setHours(row_endTime.getHours());
                row_endDateTime.setMinutes(row_endTime.getMinutes());
                if (beginDateTime.compareTo(row_beginDateTime) > 0 && beginDateTime.compareTo(row_endDateTime) < 0) {
                    jsonStatus.setMsg("1");
                    break;
                }
                if (endDateTime.compareTo(row_beginDateTime) > 0 && endDateTime.compareTo(row_endDateTime) < 0) {
                    jsonStatus.setMsg("1");
                    break;
                }
            }
            if (list.size() <= 0) {
                jsonStatus.setMsg("0");
            }
            jsonStatus.setSuccess(true);

        } catch (Exception e) {
            jsonStatus.setSuccess(false);
        }
        return jsonStatus;
    }
}
