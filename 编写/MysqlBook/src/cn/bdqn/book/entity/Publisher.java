package cn.bdqn.book.entity;

import java.util.HashSet;
import java.util.Set;


public class Publisher {

	private Integer id;
	private String name;
	
	private Set<Book> books=new HashSet<Book>();
		
	public Publisher() {
		// TODO Auto-generated constructor stub
	}
	
	public Publisher(String name) {
		super();
		this.name = name;
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

	public Set<Book> getBooks() {
		return books;
	}
	public void setBooks(Set<Book> books) {
		this.books = books;
	}
}









