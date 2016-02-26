package cn.com.rexen.core.impl.system;

import cn.com.rexen.core.api.system.IPollingManagerService;
import cn.com.rexen.core.api.system.IPollingService;
import cn.com.rexen.core.api.system.model.PollingBean;
import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zangyanming on 2016/2/25.
 */
public class PollingManagerServiceImpl implements IPollingManagerService {
    @Override
    public List<PollingBean> getPollingList() {
        List<PollingBean> pollingBeans = new ArrayList<>();
        List<IPollingService> pollingList = PollingManager.getInstall().getPollingList();
        if (pollingList != null && pollingList.size() > 0) {
            Mapper mapper = new DozerBeanMapper();
            for (IPollingService polling : pollingList) {
                PollingBean pollingBean = mapper.map(polling, PollingBean.class);
                pollingBeans.add(pollingBean);
            }
        }
        return pollingBeans;
    }
}
