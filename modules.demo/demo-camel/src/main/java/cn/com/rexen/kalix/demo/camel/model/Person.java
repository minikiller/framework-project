package cn.com.rexen.kalix.demo.camel.model;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@Entity
@XmlType
@XmlRootElement
@Table(name = "example_person")
@NamedQuery(name = "getAll", query = "select x from Person x")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
//    @Column(name = "id_")
    private long id;
    private String name;
    private String twitterName;

    public Person() {
    }

    public Person(String name, String twitterName) {
        super();
        this.name = name;
        this.twitterName = twitterName;
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

}
