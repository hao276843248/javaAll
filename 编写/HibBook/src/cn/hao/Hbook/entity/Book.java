package cn.hao.Hbook.entity;

import java.util.Date;

	/*
  3      id NUMBER(9) PRIMARY KEY,
  4      pid NUMBER(9) NOT NULL,
  5      author NVARCHAR2(50) NOT NULL,
  6      title NVARCHAR2(200) NOT NULL,
  7      price NUMBER(7,2) NOT NULL,
  8      pubdate date,
  9      pic VARCHAR2(50) NOT NULL
	 * 
	 * */
public class Book {
	private Integer id;
	private Integer pid;
	private String author;
	private String title;
	private Double price;
	private Date pubdate;
	private String pic;
	public Book() {
		// TODO Auto-generated constructor stub
	}
	public Book(Integer id, Integer pid, String author, String title,
			Double price, Date pubdate, String pic) {
		super();
		this.id = id;
		this.pid = pid;
		this.author = author;
		this.title = title;
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
	public Integer getPid() {
		return pid;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
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
	

	
	
}
