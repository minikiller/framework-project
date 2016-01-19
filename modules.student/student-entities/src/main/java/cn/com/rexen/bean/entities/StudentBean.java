package cn.com.rexen.bean.entities;

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
@Table(name = "Kalix_student")
public class StudentBean extends PersistentEntity {
    	/**
    	*@describe 姓名
    	*/
    	private String name;
    	public String getName(){
    		return this.name;
    	}

    	public void setName(String name) {
    		this.name = name;
    	}

    	/**
    	*@describe 是否党员
    	*/
    	private boolean party;
    	public boolean isParty(){
    		return this.party;
    	}

    	public void setParty(boolean party) {
    		this.party = party;
    	}

    	/**
    	*@describe 性别
    	*/
    	private String sex;
    	public String getSex(){
    		return this.sex;
    	}

    	public void setSex(String sex) {
    		this.sex = sex;
    	}

    	/**
    	*@describe 出生日期
    	*/
		@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone ="GMT+8")
    	private Date birthday;
    	public Date getBirthday(){
    		return this.birthday;
    	}

    	public void setBirthday(Date birthday) {
    		this.birthday = birthday;
    	}

    	/**
    	*@describe 年龄
    	*/
    	private int age;
    	public int getAge(){
    		return this.age;
    	}

    	public void setAge(int age) {
    		this.age = age;
    	}


}
