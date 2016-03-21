package cn.com.rexen.core.api.system;

import cn.com.rexen.core.api.IService;
import cn.com.rexen.core.api.system.model.PollingBean;

import java.util.List;

/**
 * Created by zangyanming on 2016/2/25.
 * 轮询服务管理接口
 */
public interface IPollingManagerService extends IService {
    List<PollingBean> getPollingList();
}
