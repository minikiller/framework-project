package cn.com.rexen.demo.core.biz;

import cn.com.rexen.demo.api.biz.ICarApplyBeanService;
import cn.com.rexen.demo.api.dao.ICarApplyBeanDao;
import cn.com.rexen.demo.core.Const;
import cn.com.rexen.demo.entities.CarApplyBean;
import cn.com.rexen.workflow.core.impl.WorkflowGenericBizServiceImpl;

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
     * 添加处理人的名字到实体中
     *
     * @param currentTaskName
     * @param bean
     */
    @Override
    public void writeClaimResult(String currentTaskName, String userName,CarApplyBean bean) {

        if (currentTaskName.equals("正处级领导审核")) //申请部门负责人签字
            bean.setDepUser(userName);
        else if (currentTaskName.equals("副校级领导审核")) //副校级领导审核
            bean.setManagerUser(userName);
        else if (currentTaskName.equals("校务部副部长审核")) //校务部签字
            bean.setSchoolUser(userName);
        else if (currentTaskName.equals("校党委书记审核")) //校务部主管领导审批（市外）
            bean.setSchoolManagerUser(userName);

    }



}
