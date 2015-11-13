package <packageName>.entities;

import cn.com.rexen.core.api.persistence.PersistentEntity;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * @类描述：
 * @创建人：
 * @创建时间：
 * @修改人：
 * @修改时间：
 * @修改备注：
 */
 //todo 修改模型定义
@Entity
@DynamicInsert
@DynamicUpdate
@Table(name = "roffice_<pomName>")
public class <beanName>Bean extends PersistentEntity {
    private String name;//项目名称
    @NotNull(message = "'标题'是必填项")
    private String title;   //标题
    @NotNull(message = "'内容'是必填项")
    private String content; //内容
    private String publishPeople;//发布人
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Date publishDate;//发布时间

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
