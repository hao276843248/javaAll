package cn.hao.contact.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * Group entity. @author MyEclipse Persistence Tools
 */

public class Group implements java.io.Serializable {

	// Fields

	private Integer id;
	private String name;
	private Set contacts = new HashSet(0);

	// Constructors

	/** default constructor */
	public Group() {
	}

	/** minimal constructor */
	public Group(String name) {
		this.name = name;
	}

	/** full constructor */
	public Group(String name, Set contacts) {
		this.name = name;
		this.contacts = contacts;
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

	public Set getContacts() {
		return this.contacts;
	}

	public void setContacts(Set contacts) {
		this.contacts = contacts;
	}

}