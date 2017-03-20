package cn.bdqn.mybatis.entity;

public class Book {

	private int id;
	private String author;
	private String title;
	private String publisher;
	private double price;
	private String pic;
	
	public Book() {
		// TODO Auto-generated constructor stub
	}

	public Book(int id, String author, String title, String publisher,
			double price,String pic) {
		super();
		this.id = id;
		this.author = author;
		this.title = title;
		this.publisher = publisher;
		this.price = price;
		this.pic=pic;
	}




	public Book(String author, String title, String publisher, double price,String pic) {
		super();
		this.author = author;
		this.title = title;
		this.publisher = publisher;
		this.price = price;
		this.pic=pic;
	}




	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getPic() {
		return pic;
	}
	public void setPic(String pic) {
		this.pic = pic;
	}
	
	
}
