package cn.com.rexen.demo.core.biz;

import cn.com.rexen.demo.api.biz.ICarApplyBeanService;
import cn.com.rexen.demo.api.dao.ICarApplyBeanDao;
import cn.com.rexen.demo.core.Const;
import cn.com.rexen.demo.entities.CarApplyBean;
import cn.com.rexen.workflow.core.impl.WorkflowGenericBizServiceImpl;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

/**
 * @author chenyanxu
 */
public class CarApplyBeanServiceImpl extends WorkflowGenericBizServiceImpl<ICarApplyBeanDao, CarApplyBean> implements ICarApplyBeanService {

    @Override
    public String getProcessKeyName() {
        return Const.PROCESS_CAR_APPLY_KEY_NAME;
    }

    @Override
    public Map getVariantMap(Map map,CarApplyBean bean) {
        map.put("city", bean.isCity());
        return map;
    }

    /**
     * 通过反射，添加处理人的名字到实体中
     * @param currentTaskId 对应流程定义中的userTaskId
     * @param userName 处理人的名字
     * @param bean 业务实体类
     */
    @Override
    public void writeClaimResult(String currentTaskId, String userName,CarApplyBean bean) throws NoSuchMethodException {
        try {
            // 将属性的首字符大写，方便构造get，set
            String name = currentTaskId.substring(0, 1).toUpperCase() + currentTaskId.substring(1);
            Method method = CarApplyBean.class.getDeclaredMethod("set"+name,String.class);
            method.invoke(bean,userName);
        }  catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        /*if (currentTaskName.equals("正处级领导审核")) //申请部门负责人签字
            bean.setDepUser(userName);
        else if (currentTaskName.equals("副校级领导审核")) //副校级领导审核
            bean.setManagerUser(userName);
        else if (currentTaskName.equals("校务部副部长审核")) //校务部签字
            bean.setSchoolUser(userName);
        else if (currentTaskName.equals("校党委书记审核")) //校务部主管领导审批（市外）
            bean.setSchoolManagerUser(userName);*/

    }



}
