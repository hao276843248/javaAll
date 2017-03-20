package cn.hao.mybatis.entity;

import java.util.Date;

/*
    id NUMBER(9) PRIMARY KEY,        --学生编号
    name NVARCHAR2(20) NOT NULL,     --姓名        
    sex NCHAR(1) NOT NULL,           --性别
    birthday DATE NOT NULL,          --生日
    cid NUMBER(9) NOT NULL,          --课程编号
    eid NUMBER(9) NOT NULL,          --学历编号
    contact NVARCHAR2(20) NOT NULL,  --联系方式    
    time NUMBER(9) NOT NULL,         --上课时间 1:脱产 2:业余        
    state NUMBER(9) NOT NULL,        --状态 1:跟进中 2:已缴费 3：已放弃
    addTime DATE NOT NULL            --咨询日期
 */
public class Student {

	private int id;
	private String name;
	private String sex;
	private Date birthary;
	private int cid;
	private int eid;
	private String contact;
	private int time;
	private int state;
	private Date addTime;
	
	public Student() {
		// TODO Auto-generated constructor stub
	}
	public Student(String name, String sex, Date birthary, int cid, int eid,
			String contact, int time, int state, Date addTime) {
		super();
		this.name = name;
		this.sex = sex;
		this.birthary = birthary;
		this.cid = cid;
		this.eid = eid;
		this.contact = contact;
		this.time = time;
		this.state = state;
		this.addTime = addTime;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
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
	public Date getBirthary() {
		return birthary;
	}
	public void setBirthary(Date birthary) {
		this.birthary = birthary;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public int getTime() {
		return time;
	}
	public void setTime(int time) {
		this.time = time;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public Date getAddTime() {
		return addTime;
	}
	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}
	
	
	
	
	
	
}
