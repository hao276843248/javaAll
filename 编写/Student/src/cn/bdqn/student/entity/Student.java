package cn.bdqn.student.entity;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Transient;

import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Student entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "student", catalog = "student")
public class Student implements java.io.Serializable {

	// Fields

	private Integer id;
	private Education education;
	private Course course;
	private String name;
	private String sex;
	private Timestamp birthday;
	private String contact;
	private Integer time;
	private Integer stat;
	private Timestamp addTime;

	// Constructors

	/** default constructor */
	public Student() {
	}

	/** full constructor */
	public Student(Education education, Course course, String name, String sex,
			Timestamp birthday, String contact, Integer time, Integer stat,
			Timestamp addTime) {
		this.education = education;
		this.course = course;
		this.name = name;
		this.sex = sex;
		this.birthday = birthday;
		this.contact = contact;
		this.time = time;
		this.stat = stat;
		this.addTime = addTime;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "eid", nullable = false)
	public Education getEducation() {
		return this.education;
	}

	public void setEducation(Education education) {
		this.education = education;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cid", nullable = false)
	public Course getCourse() {
		return this.course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	@Column(name = "name", nullable = false, length = 20)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "sex", nullable = false, length = 1)
	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	@Column(name = "birthday", nullable = false, length = 19)
	public Timestamp getBirthday() {
		return this.birthday;
	}

	public void setBirthday(Timestamp birthday) {
		this.birthday = birthday;
	}

	@Column(name = "contact", nullable = false, length = 20)
	public String getContact() {
		return this.contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	@Column(name = "time", nullable = false)
	public Integer getTime() {
		return this.time;
	}

	public void setTime(Integer time) {
		this.time = time;
	}

	@Column(name = "stat", nullable = false)
	public Integer getStat() {
		return this.stat;
	}

	public void setStat(Integer stat) {
		this.stat = stat;
	}

	@Column(name = "addTime", nullable = false, length = 19,updatable=false)
	public Timestamp getAddTime() {
		return this.addTime;
	}

	public void setAddTime(Timestamp addTime) {
		this.addTime = addTime;
	}

	@Transient
	public int getAge(){
		return (int)((System.currentTimeMillis()-birthday.getTime())/(1000*60*60*24*365L));
	}
	
}










