package cn.com.rexen.kalix.dashboard.entities;



import cn.com.rexen.core.api.persistence.PersistentEntity;

import javax.persistence.*;

/**
 * 自定义用户面板
 * @author chenyanxu
 */
@Entity
@Table(name = "sys_dashboard")
@Inheritance(strategy = InheritanceType.JOINED)
public class DashboardBean extends PersistentEntity {
    private Long userId;
    @Lob
    private String defaultContent;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getDefaultContent() {
        return defaultContent;
    }

    public void setDefaultContent(String defaultContent) {
        this.defaultContent = defaultContent;
    }
}
