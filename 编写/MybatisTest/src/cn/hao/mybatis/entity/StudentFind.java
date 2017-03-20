package cn.hao.mybatis.entity;

import java.util.Date;
/*
 * ����
 * �Ա�
 * ����
 * ����γ�
 * ʱ��  1:�Ѳ� 2:ҵ��        
 * ѧ��
 * ״̬   1:������ 2:�ѽɷ� 3���ѷ���
 * ��ϵ��ʽ
 * ��ѯ����
 */
public class StudentFind {
	private int id;
	private String name;
	private String sex;
	private int age;
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


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
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


	public StudentFind(int id, String name, String sex, int age, String course,
			String education, String contact, String time, String state, Date addTime) {
		super();
		this.id = id;
		this.name = name;
		this.sex = sex;
		this.age = age;
		this.course = course;
		this.education = education;
		this.contact = contact;
		this.time = time;
		this.state = state;
		this.addTime = addTime;
	}
	
}
