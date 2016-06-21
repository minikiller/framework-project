package cn.com.rexen.demo.core.biz;

import cn.com.rexen.demo.api.biz.IRecruitApplyService;
import cn.com.rexen.demo.api.dao.IRecruitApplyDao;
import cn.com.rexen.demo.core.Const;
import cn.com.rexen.demo.entities.RecruitApplyBean;
import cn.com.rexen.workflow.core.impl.WorkflowGenericBizServiceImpl;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

/**
 * Created by zangyanming on 2016/6/15.
 */
public class RecruitApplyServiceImpl extends WorkflowGenericBizServiceImpl<IRecruitApplyDao, RecruitApplyBean> implements IRecruitApplyService {
    /**
     * 获得工作流主键名称，需要子类重载
     *
     * @return
     */
    @Override
    public String getProcessKeyName() {
        return Const.PROCESS_RECRUIT_APPLY_KEY_NAME;
    }

    /**
     * 添加处理人的名字到实体中
     *
     * @param currentTaskId
     * @param userName
     * @param bean
     */
    @Override
    public void writeClaimResult(String currentTaskId, String userName, RecruitApplyBean bean) throws NoSuchMethodException {
        try {
            // 将属性的首字符大写，方便构造get，set
            String name = currentTaskId.substring(0, 1).toUpperCase() + currentTaskId.substring(1);
            Method method = RecruitApplyBean.class.getDeclaredMethod("set" + name, String.class);
            method.invoke(bean, userName);
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    /**
     * 加入流程环节变量到map中
     *
     * @param map
     * @param bean
     * @return
     */
    @Override
    public Map getVariantMap(Map map, RecruitApplyBean bean) {
        return map;
    }
}
