package cn.hao.house.enetity;

import java.util.Date;

/**
 * House entity. @author MyEclipse Persistence Tools
 */

public class House implements java.io.Serializable {

	// Fields

	private Long id;
	private Users users;
	private Types types;
	private Street street;
	private String title;
	private String description;
	private Long price;
	private Date pubdate;
	private Long floorage;
	private String contact;

	// Constructors

	/** default constructor */
	public House() {
	}

	/** full constructor */
	public House(Users users, Types types, Street street, String title,
			String description, Long price, Date pubdate, Long floorage,
			String contact) {
		this.users = users;
		this.types = types;
		this.street = street;
		this.title = title;
		this.description = description;
		this.price = price;
		this.pubdate = pubdate;
		this.floorage = floorage;
		this.contact = contact;
	}

	// Property accessors

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Users getUsers() {
		return this.users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	public Types getTypes() {
		return this.types;
	}

	public void setTypes(Types types) {
		this.types = types;
	}

	public Street getStreet() {
		return this.street;
	}

	public void setStreet(Street street) {
		this.street = street;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getPrice() {
		return this.price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

	public Date getPubdate() {
		return this.pubdate;
	}

	public void setPubdate(Date pubdate) {
		this.pubdate = pubdate;
	}

	public Long getFloorage() {
		return this.floorage;
	}

	public void setFloorage(Long floorage) {
		this.floorage = floorage;
	}

	public String getContact() {
		return this.contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

}