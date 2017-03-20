package cn.hao.book.entity;

import java.util.Date;

public class Book {
	private Integer id;
	private String title;
	private String author;
	private Double price;
	private Date pubdate;
	private String pic;
	
	private Publisher publisher;
	
	public Book() {
		// TODO Auto-generated constructor stub
	}
	
	public Book(Integer id,String title, String author, Double price, Date pubdate,
			String pic) {
		super();
		this.id = id;
		this.title = title;
		this.author = author;
		this.price = price;
		this.pubdate = pubdate;
		this.pic = pic;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
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
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Date getPubdate() {
		return pubdate;
	}
	public void setPubdate(Date pubdate) {
		this.pubdate = pubdate;
	}
	public String getPic() {
		return pic;
	}
	public void setPic(String pic) {
		this.pic = pic;
	}
	public Publisher getPublisher() {
		return publisher;
	}
	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}
	public Book(Integer id, String title, String author, Double price,
			Date pubdate, String pic, Publisher publisher) {
		super();
		this.id = id;
		this.title = title;
		this.author = author;
		this.price = price;
		this.pubdate = pubdate;
		this.pic = pic;
		this.publisher = publisher;
	}
	
	
	
	
	
}
