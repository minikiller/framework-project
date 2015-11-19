package cn.com.rexen.demo.entities;

import cn.com.rexen.core.api.persistence.WorkflowEntity;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * @类描述：公告管理
 * @创建人： zhangqingxin
 * @创建时间：2014/10/10
 * @修改人：
 * @修改时间：
 * @修改备注：
 */
@Entity
@Table(name = "sys_demo")
@Inheritance(strategy = InheritanceType.JOINED)
/*@TypeDef(name = "jsonb", typeClass = JSONBUserType.class, parameters = {
        @Parameter(name = JSONBUserType.CLASS,
                value = "cn.com.rexen.demo.entities.NoticeBean")})*/
public class NoticeBean extends WorkflowEntity {
    @NotNull(message = "'标题'是必填项")
    private String title;   //标题
    @NotNull(message = "'内容'是必填项")
    private String content; //内容
    private String publishPeople;//发布人
    private Date publishDate;//发布时间

    /*@Type(type = "jsonb")
    private List<JSONBDocument> documents;*/

    /*public NoticeBean() {
        documents = new ArrayList<>();
    }

    public List<JSONBDocument> getDocuments() {
        return documents;
    }

    public void setDocuments(List<JSONBDocument> documents) {
        this.documents = documents;
    }*/

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPublishPeople() {
        return publishPeople;
    }

    public void setPublishPeople(String publishPeople) {
        this.publishPeople = publishPeople;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    @Override
    public String toString() {
        return "NoticeBean{" +
                "id='" + getId() + '\'' +
                "content='" + content + '\'' +
                ", title='" + title + '\'' +
                ", publishPeople='" + publishPeople + '\'' +
                ", publishDate=" + publishDate +
                '}';
    }
}
