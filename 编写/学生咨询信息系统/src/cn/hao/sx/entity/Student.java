package cn.hao.sx.entity;

import java.util.Date;

/*
    id NUMBER(9) PRIMARY KEY,        --ѧ�����
    name NVARCHAR2(20) NOT NULL,     --����        
    sex NCHAR(1) NOT NULL,           --�Ա�
    birthday DATE NOT NULL,          --����
    cid NUMBER(9) NOT NULL,          --�γ̱��
    eid NUMBER(9) NOT NULL,          --ѧ�����
    contact NVARCHAR2(20) NOT NULL,  --��ϵ��ʽ    
    time NUMBER(9) NOT NULL,         --�Ͽ�ʱ�� 1:�Ѳ� 2:ҵ��        
    state NUMBER(9) NOT NULL,        --״̬ 1:������ 2:�ѽɷ� 3���ѷ���
    addTime DATE NOT NULL            --��ѯ����
 */
public class Student {

	private int id;
	private String name;
	private String sex;
	private Date birthday;
	private int cid;
	private int eid;
	private String contact;
	private int time;
	private int state;
	private Date addTime;
	
	public Student() {
		// TODO Auto-generated constructor stub
	}
	
	
	public Student(int id, String name, String sex, Date birthday, int cid,
			int eid, String contact, int time, int state, Date addTime) {
		super();
		this.id = id;
		this.name = name;
		this.sex = sex;
		this.birthday = birthday;
		this.cid = cid;
		this.eid = eid;
		this.contact = contact;
		this.time = time;
		this.state = state;
		this.addTime = addTime;
	}


	public Student(String name, String sex, Date birthday, int cid, int eid,
			String contact, int time, int state, Date addTime) {
		super();
		this.name = name;
		this.sex = sex;
		this.birthday = birthday;
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
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
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
