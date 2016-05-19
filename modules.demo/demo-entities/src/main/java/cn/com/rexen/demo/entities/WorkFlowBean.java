package cn.com.rexen.demo.entities;

import cn.com.rexen.core.api.persistence.PersistentEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @类描述：用车申请管理
 * @创建人： sunlf
 * @创建时间：2016/2/24
 * @修改人：
 * @修改时间：
 * @修改备注：
 */

@Entity
@Table(name = "act_re_procdef_temp")
public class WorkFlowBean extends PersistentEntity {
    private String category;
    private long cnt;
    private String title;
    private String imgurl;
    private String description;
    private String flowurl;

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public long getCnt() {
        return cnt;
    }

    public void setCnt(long cnt) {
        this.cnt = cnt;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImgurl() {
        return imgurl;
    }

    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFlowurl() {
        return flowurl;
    }

    public void setFlowurl(String flowurl) {
        this.flowurl = flowurl;
    }
}
