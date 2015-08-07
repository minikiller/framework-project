package cn.com.rexen.demo.web.impl;

import cn.com.rexen.demo.api.Const;
import cn.com.rexen.workflow.api.web.IBizDataHandler;

/**
 * Created by sunlf on 2015/8/5.
 */
public class DemoBizDataFormImpl implements IBizDataHandler {
    @Override
    public String getBizName() {
        return "Demo Data";
    }

    @Override
    public String getComponentClass() {

        return "Kalix.demo.view.NoticeShowForm";
    }

    @Override
    public String getProcessDefinitionId() {
        return Const.WORKFLOW_PROCESS_KEY;
    }
}
