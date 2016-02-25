package cn.com.rexen.core.system.impl;

import cn.com.rexen.core.api.system.IPolling;
import cn.com.rexen.core.api.system.IPollingService;
import cn.com.rexen.core.api.system.model.PollingBean;
import cn.com.rexen.core.system.manager.PollingManager;
import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zangyanming on 2016/2/25.
 */
public class PollingServiceImpl implements IPollingService {
    @Override
    public List<PollingBean> getPollingList() {
        List<PollingBean> pollingBeans = new ArrayList<>();
        List<IPolling> pollingList = PollingManager.getInstall().getPollingList();
        if (pollingList != null && pollingList.size() > 0) {
            Mapper mapper = new DozerBeanMapper();
            for (IPolling polling : pollingList) {
                PollingBean pollingBean = mapper.map(polling, PollingBean.class);
                pollingBeans.add(pollingBean);
            }
        }
        return pollingBeans;
    }
}
