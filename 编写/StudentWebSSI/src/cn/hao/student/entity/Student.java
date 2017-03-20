package cn.hao.student.entity;

import java.sql.Timestamp;
import java.util.Date;

/**
 * Student entity. @author MyEclipse Persistence Tools
 */

public class Student implements java.io.Serializable {

	// Fields

	private Integer id;
	private String name;
	private String gender;
	private Timestamp brithday;
	private String pic;

	// Constructors

	/** default constructor */
	public Student() {
	}

	/** full constructor */
	public Student(Integer id, String name, String gender, Timestamp brithday,
			String pic) {
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.brithday = brithday;
		this.pic = pic;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Timestamp getBrithday() {
		return this.brithday;
	}

	public void setBrithday(Timestamp brithday) {
		this.brithday = brithday;
	}

	public String getPic() {
		return this.pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}

}