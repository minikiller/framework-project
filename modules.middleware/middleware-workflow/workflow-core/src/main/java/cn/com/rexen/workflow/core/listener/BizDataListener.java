package cn.com.rexen.workflow.core.listener;

import cn.com.rexen.workflow.api.web.IBizDataHandler;
import cn.com.rexen.workflow.core.manager.BizDataManager;
import org.apache.log4j.Logger;

/**
 * @类描述：业务数据监听者
 * @创建人： sunlingfeng
 * @创建时间：2014/9/12
 * @修改人：
 * @修改时间：
 * @修改备注：
 */

public class BizDataListener {
    private static Logger logger = Logger.getLogger(BizDataListener.class);

    /**
     * 监听到BizData
     *
     * @param bizDataHandler
     */
    public void bind(IBizDataHandler bizDataHandler) {
        logger.info("workflow bizData" + bizDataHandler.getProcessDefinitionId() + " is binded!");
        BizDataManager.getInstall().put(bizDataHandler);

    }


    /**
     * Form被移除
     *
     * @param bizDataHandler
     */
    public void unbind(IBizDataHandler bizDataHandler) {
        logger.info("workflow bizData " + bizDataHandler.getProcessDefinitionId() + " is unbound!");
        BizDataManager.getInstall().remove(bizDataHandler);
    }

}
