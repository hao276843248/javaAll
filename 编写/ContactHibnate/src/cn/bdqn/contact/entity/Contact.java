package cn.bdqn.contact.entity;

import java.sql.Timestamp;

/**
 * Contact entity. @author MyEclipse Persistence Tools
 */

public class Contact implements java.io.Serializable {

	// Fields

	private Integer id;
	private Group group;
	private User user;
	private String name;
	private String title;
	private String sex;
	private String photo;
	private Timestamp birthday;
	private String phone;
	private String email;
	private String qq;
	private String address;
	private String description;

	// Constructors

	/** default constructor */
	public Contact() {
	}

	/** full constructor */
	public Contact(Group group, User user, String name, String title,
			String sex, String photo, Timestamp birthday, String phone,
			String email, String qq, String address, String description) {
		this.group = group;
		this.user = user;
		this.name = name;
		this.title = title;
		this.sex = sex;
		this.photo = photo;
		this.birthday = birthday;
		this.phone = phone;
		this.email = email;
		this.qq = qq;
		this.address = address;
		this.description = description;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Group getGroup() {
		return this.group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getPhoto() {
		return this.photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public Timestamp getBirthday() {
		return this.birthday;
	}

	public void setBirthday(Timestamp birthday) {
		this.birthday = birthday;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getQq() {
		return this.qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}