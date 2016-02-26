package cn.com.rexen.core.api.system;

import cn.com.rexen.core.api.system.model.PollingBean;

import java.util.List;

/**
 * Created by zangyanming on 2016/2/25.
 */
public interface IPollingService {
    List<PollingBean> getPollingList();
}
