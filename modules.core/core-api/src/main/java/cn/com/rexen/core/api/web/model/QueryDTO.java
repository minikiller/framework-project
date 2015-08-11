package cn.com.rexen.core.api.web.model;

/**
 * 查询模型类
 * @author majian <br/>
 *         date:2015-8-10
 * @version 1.0.0
 */
public abstract class QueryDTO {
    private int start; //开始指针
    private int limit; //每页显示
    private int page; //第几页

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }
}
