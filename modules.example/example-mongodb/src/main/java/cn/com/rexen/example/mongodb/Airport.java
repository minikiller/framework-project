package cn.com.rexen.example.sequoiadb;

import org.javers.core.metamodel.annotation.DiffIgnore;

/**
 * Created by rmaia on 2/11/15.
 */
public class Airport {
    @DiffIgnore
    private int id;
    private AirportName name;
    private String city;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public AirportName getName() {
        return name;
    }

    public void setName(AirportName name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}

