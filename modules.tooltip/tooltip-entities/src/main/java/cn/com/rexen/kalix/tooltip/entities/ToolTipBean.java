package cn.com.rexen.kalix.tooltip.entities;



import cn.com.rexen.core.api.persistence.PersistentEntity;

import javax.persistence.*;

/**
 * @author chenyanxu
 */
@Entity
@Table(name = "sys_tooltip")
@Inheritance(strategy = InheritanceType.JOINED)
public class ToolTipBean extends PersistentEntity {
    private String name;
    @Lob
    private String content;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
