package cn.bdqn.hibernate.entity;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Emp {
	
	private Integer id;
	private String name;
	
	private Set<Project> projects=new HashSet<Project>();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Project> getProjects() {
		return projects;
	}

	public void setProjects(Set<Project> projects) {
		this.projects = projects;
	}

	
	
}
