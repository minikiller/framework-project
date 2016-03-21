package cn.com.rexen.kalix.demo.camel.model;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.Date;

@Entity
@XmlType
@XmlRootElement
@Table(name = "example_newperson")
//@NamedQuery(name = "getAll", query = "select x from Person x")
public class NewPerson {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
//    @Column(name = "id_")
    private long id;
    private String name;
    private String twitterName;
    private Date createDate = new Date();

    public NewPerson() {
    }

    public NewPerson(String name, String twitterName) {
        super();
        this.name = name;
        this.twitterName = twitterName;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTwitterName() {
        return twitterName;
    }

    public void setTwitterName(String twitterName) {
        this.twitterName = twitterName;
    }

    @Override
    public String toString() {
        return "NewPerson{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", twitterName='" + twitterName + '\'' +
                ", createDate=" + createDate +
                '}';
    }
}
