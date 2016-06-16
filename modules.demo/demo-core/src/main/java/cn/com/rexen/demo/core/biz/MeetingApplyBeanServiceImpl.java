/**
 * @author zangyanming
 * checkDateTime函数检测会议室申请中的开始时间与结束时间范围内，会议室是否被占用
 */
package cn.com.rexen.demo.core.biz;

import cn.com.rexen.core.api.biz.JsonStatus;
import cn.com.rexen.core.api.persistence.JsonData;
import cn.com.rexen.core.api.persistence.PersistentEntity;
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
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

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
        jsonStatus.setMsg("0");
        long id;
        if (entity.getId() == 0) {
            id = -1;
        } else {
            id = entity.getId();
        }

        long meetingroomId = entity.getMeetingroomId();
        //Date meetingDate = entity.getMeetingDate();

        Date beginDateTime = new Date();
        Date beginTime = entity.getBeginTime();
        beginDateTime.setYear(entity.getMeetingDate().getYear());
        beginDateTime.setMonth(entity.getMeetingDate().getMonth());
        beginDateTime.setDate(entity.getMeetingDate().getDate());
        beginDateTime.setHours(beginTime.getHours());
        beginDateTime.setMinutes(beginTime.getMinutes());
        beginDateTime.setSeconds(beginTime.getSeconds());

        Date endDateTime = new Date();//entity.getMeetingDate();
        Date endTime = entity.getEndTime();
        endDateTime.setYear(entity.getMeetingDate().getYear());
        endDateTime.setMonth(entity.getMeetingDate().getMonth());
        endDateTime.setDate(entity.getMeetingDate().getDate());
        endDateTime.setHours(endTime.getHours());
        endDateTime.setMinutes(endTime.getMinutes());
        endDateTime.setSeconds(endTime.getSeconds());

        try {
            Date row_beginTime, row_endTime, row_beginDateTime, row_endDateTime;
            List<MeetingApplyBean> list = dao.find("select ob from MeetingApplyBean ob where ob.id <> ?1 and ob.meetingroomId=?2", id, meetingroomId);
            for (int i = 0; i < list.size(); i++) {
                row_beginTime = list.get(i).getBeginTime();
                row_endTime = list.get(i).getEndTime();

                row_beginDateTime = new Date();
                row_beginDateTime.setYear(list.get(i).getMeetingDate().getYear());
                row_beginDateTime.setMonth(list.get(i).getMeetingDate().getMonth());
                row_beginDateTime.setDate(list.get(i).getMeetingDate().getDate());
                row_beginDateTime.setHours(row_beginTime.getHours());
                row_beginDateTime.setMinutes(row_beginTime.getMinutes());
                row_beginDateTime.setSeconds(row_beginTime.getSeconds());

                row_endDateTime = new Date();
                row_endDateTime.setYear(list.get(i).getMeetingDate().getYear());
                row_endDateTime.setMonth(list.get(i).getMeetingDate().getMonth());
                row_endDateTime.setDate(list.get(i).getMeetingDate().getDate());
                row_endDateTime.setHours(row_endTime.getHours());
                row_endDateTime.setMinutes(row_endTime.getMinutes());
                row_endDateTime.setSeconds(row_endTime.getSeconds());

                if (beginDateTime.before(row_beginDateTime) && endDateTime.after(row_beginDateTime)) {
                    jsonStatus.setMsg("1");
                    break;
                }
                if (Math.abs(beginDateTime.getTime() - row_beginDateTime.getTime()) < 1000) {
                    jsonStatus.setMsg("1");
                    break;
                }
                if (beginDateTime.after(row_beginDateTime) && beginDateTime.before(row_endDateTime)) {
                    jsonStatus.setMsg("1");
                    break;
                }
            }

            jsonStatus.setSuccess(true);
        } catch (Exception e) {
            jsonStatus.setMsg("1");
            jsonStatus.setSuccess(false);
        }
        return jsonStatus;
    }

    @Override
    public JsonData reservation(Date date) {
        if (date == null) return null;
        JsonData jsonData = new JsonData();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String dateStr = df.format(date);
        List<PersistentEntity> beans = dao.findByNativeSql("select ob from MeetingApplyBean ob where ob.meetingDate >=1? and ob.meetingDate <=2?", MeetingApplyBean.class, dateStr + "00:00:00", dateStr + "23:59:59");

        jsonData.setData(beans);
        jsonData.setTotalCount((long) beans.size());
        return jsonData;
    }

    @Override
    public JsonData reservation(long roomId, Date date) {
        if (date == null) return null;
        JsonData jsonData = new JsonData();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String dateStr = df.format(date);
        List<PersistentEntity> beans = dao.findByNativeSql("select ob from MeetingApplyBean ob where ob.meetingRoomId = ?1 ob.meetingDate >= 2? and ob.meetingDate <= 3?", MeetingApplyBean.class, roomId, dateStr + "00:00:00", dateStr + "23:59:59");

        jsonData.setData(beans);
        jsonData.setTotalCount((long) beans.size());
        return jsonData;
    }
}
