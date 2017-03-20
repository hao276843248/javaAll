package cn.hao.Hbook.entity;

import java.util.HashSet;
import java.util.Set;

public class Publisher {
	private Integer id;
	private String name;
	private Set<Book> book=new HashSet<Book>();
	
	public Publisher() {
		// TODO Auto-generated constructor stub
	}
	public Publisher(String name) {
		this.name=name;
	}
	
	public Publisher(Integer id, String name, Set<Book> book) {
		super();
		this.id = id;
		this.name = name;
		this.book = book;
	}

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
	public Set<Book> getBook() {
		return book;
	}
	public void setBook(Set<Book> book) {
		this.book = book;
	}
	
	
}
