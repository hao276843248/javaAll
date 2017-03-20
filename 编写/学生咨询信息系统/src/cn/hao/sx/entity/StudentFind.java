package cn.hao.sx.entity;

import java.util.Date;
/*
 * 姓名
 * 性别
 * 年龄(生日)
 * 意向课程
 * 时间  1:脱产 2:业余        
 * 学历
 * 状态   1:跟进中 2:已缴费 3：已放弃
 * 联系方式
 * 咨询日期
 */
public class StudentFind {
	private int id;
	private String name;
	private String sex;
	private Date birthday;
	private String course;
	private String education;
	private String contact;
	private String time;
	private String state;
	private Date addTime;
	
	
	public StudentFind() {
		// TODO Auto-generated constructor stub
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


	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}


	public String getCourse() {
		return course;
	}


	public void setCourse(String course) {
		this.course = course;
	}


	public String getEducation() {
		return education;
	}


	public void setEducation(String education) {
		this.education = education;
	}


	public String getContact() {
		return contact;
	}


	public void setContact(String contact) {
		this.contact = contact;
	}


	public String getTime() {
		return time;
	}


	public void setTime(String time) {
		this.time = time;
	}


	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}


	public Date getAddTime() {
		return addTime;
	}


	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}


	public StudentFind(int id, String name, String sex, Date birthday, String course,
			String education, String contact, String time, String state, Date addTime) {
		super();
		this.id = id;
		this.name = name;
		this.sex = sex;
		this.birthday = birthday;
		this.course = course;
		this.education = education;
		this.contact = contact;
		this.time = time;
		this.state = state;
		this.addTime = addTime;
	}
	
	public String getS(){
		if(Integer.parseInt(state)==1){
			return "跟进中";
		}else if(Integer.parseInt(state)==2){
			return "已缴费";
		}else {
			return "已放弃";
		}
	}
	public int getAge(){
		return (int)((System.currentTimeMillis()-birthday.getTime())/(1000*60*60*24*365L));
	}
}
