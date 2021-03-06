package cn.bdqn.hibernate.entity;

import java.util.HashSet;
import java.util.Set;

public class Student {

	private Integer id;
	private String name;
	
	private Set<Result> results=new HashSet<Result>();

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

	public Set<Result> getResults() {
		return results;
	}

	public void setResults(Set<Result> results) {
		this.results = results;
	}
	
	
	
}
