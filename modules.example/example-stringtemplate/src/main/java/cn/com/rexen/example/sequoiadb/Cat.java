package cn.com.rexen.example.sequoiadb;

/**
 * Created by sunlf on 2015/9/18.
 */
public class Cat {
    private String name;
    private int age;

    /**
     * @builder
     */
    public Cat(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
