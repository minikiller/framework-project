package cn.com.rexen.kalix.dashboard.entities;



import cn.com.rexen.core.api.persistence.PersistentEntity;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

/**
 * 自定义用户面板
 * @author chenyanxu
 */
@Entity
@Table(name = "sys_dashboard")
@Inheritance(strategy = InheritanceType.JOINED)
public class DashboardBean extends PersistentEntity {

}
