package cn.com.rexen.demo.core.biz;

import cn.com.rexen.demo.api.biz.ISealApplyBeanService;
import cn.com.rexen.demo.api.dao.ISealApplyBeanDao;
import cn.com.rexen.demo.core.Const;
import cn.com.rexen.demo.entities.SealApplyBean;
import cn.com.rexen.workflow.core.impl.WorkflowGenericBizServiceImpl;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
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
    public void writeClaimResult(String currentTaskId, String userName, SealApplyBean bean) throws NoSuchMethodException {
        try {
            // 将属性的首字符大写，方便构造get，set
            String name = currentTaskId.substring(0, 1).toUpperCase() + currentTaskId.substring(1);
            Method method = SealApplyBean.class.getDeclaredMethod("set" + name, String.class);
            method.invoke(bean, userName);
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Map getVariantMap(Map map, SealApplyBean bean) {
        return map;
    }

}
