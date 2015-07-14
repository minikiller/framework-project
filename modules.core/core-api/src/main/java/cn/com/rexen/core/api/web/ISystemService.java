package cn.com.rexen.core.api.web;

import cn.com.rexen.core.api.web.model.ApplicationBean;
import cn.com.rexen.core.api.web.model.SystemBean;

import java.util.List;

/**
 * Created by sunlf on 2015/7/13.
 * osgi rest service
 */
public interface ISystemService {
    SystemBean getSystem();

    List<ApplicationBean> getApplicationList();
}
