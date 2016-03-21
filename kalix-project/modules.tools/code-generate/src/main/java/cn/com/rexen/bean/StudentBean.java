package cn.com.rexen.bean;

import java.util.Date;

/**
 * Created by zangyanming on 2016/1/11.
 */
public class StudentBean {

    /**
     * @describe 姓名
     * @validator 不能为空
     */
    private String name;
    /**
     * @describe 性别
     */
    private String sex;
    /**
     * @describe 出生日期
     */
    private Date birthday;
    /**
     * @describe 年龄
     * @validator 介于1与120之间
     */
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
