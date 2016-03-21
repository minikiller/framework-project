package cn.com.rexen.demo.core.biz;

import cn.com.rexen.demo.api.biz.ISealApplyBeanService;
import cn.com.rexen.demo.api.dao.ISealApplyBeanDao;
import cn.com.rexen.demo.core.Const;
import cn.com.rexen.demo.entities.SealApplyBean;
import cn.com.rexen.workflow.core.impl.WorkflowGenericBizServiceImpl;

import java.util.Map;

/**
 * @author chenyanxu
 */
public class SealApplyBeanServiceImpl extends WorkflowGenericBizServiceImpl<ISealApplyBeanDao, SealApplyBean> implements ISealApplyBeanService {

    @Override
    public String getProcessKeyName() {
        return Const.PROCESS_SEAL_APPLY_KEY_NAME;
    }

    @Override
    public void writeClaimResult(String currentTaskName, String userName, SealApplyBean bean) {

    }

    @Override
    public Map getVariantMap(Map map, SealApplyBean bean) {
        return map;
    }

}
