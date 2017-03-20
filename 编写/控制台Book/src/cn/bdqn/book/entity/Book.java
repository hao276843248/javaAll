package cn.bdqn.book.entity;

import java.util.Date;

public class Book {
	private int id;
	private String title;
	private String author;
	private double price;
	private Date pubDate;
	private String publisher;
	
	public Book() {
		// TODO Auto-generated constructor stub
	}

	
	
	public Book(String title, String author, double price, Date pubDate,
			String publisher) {
		super();
		this.title = title;
		this.author = author;
		this.price = price;
		this.pubDate = pubDate;
		this.publisher = publisher;
	}



	public Book(int id, String title, String author, double price,
			Date pubDate, String publisher) {
		super();
		this.id = id;
		this.title = title;
		this.author = author;
		this.price = price;
		this.pubDate = pubDate;
		this.publisher = publisher;
	}



	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Date getPubDate() {
		return pubDate;
	}
	public void setPubDate(Date pubDate) {
		this.pubDate = pubDate;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	
	
}
