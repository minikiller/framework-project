package cn.com.rexen.core.api.web.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sunlf on 2015/7/14.
 */
public class BodyBean {
    private List<ApplicationBean> applicationBeanList = new ArrayList<>();

    public List<ApplicationBean> getApplicationBeanList() {
        return applicationBeanList;
    }

    public void setApplicationBeanList(List<ApplicationBean> applicationBeanList) {
        this.applicationBeanList = applicationBeanList;
    }
}
