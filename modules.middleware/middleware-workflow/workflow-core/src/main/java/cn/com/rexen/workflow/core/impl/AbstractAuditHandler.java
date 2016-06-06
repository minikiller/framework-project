package cn.com.rexen.workflow.core.impl;

import cn.com.rexen.workflow.api.web.IFormHandler;

/**
 * Created by Administrator on 2016/6/2.
 */
public abstract class AbstractAuditHandler implements IFormHandler {
    /**
     * 获得form的key
     *
     * @return
     */
    @Override
    public String getFormKey() {
        return "audit.form";
    }

    /**
     * 获得extjs的窗口类名称
     *
     * @return
     */
    @Override
    public String getWindowClass() {
        return "kalix.workflow.approve.view.ApproveWindow";
    }
}
