package cn.com.rexen.workflow.api.model;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by sunlf on 2015/7/3.
 * 用于extjs的grid返回列表数据
 */
public class JsonData {
    private int totalCount;
    private List data = new ArrayList<>();

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public List getData() {
        return data;
    }

    public void setData(List data) {
        this.data = data;
    }
}
