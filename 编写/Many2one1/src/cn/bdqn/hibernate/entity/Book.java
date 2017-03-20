package cn.bdqn.hibernate.entity;

public class Book {
	
	private Integer id;
	private String author;
	private String title;
	private double price;
	private String pic;
	
	//表示图书与出版社之间的多对一关系
	private Publisher publisher;

	public Book() {
		// TODO Auto-generated constructor stub
	}
	

	public Book(String author, String title, double price, String pic) {
		super();
		this.author = author;
		this.title = title;
		this.price = price;
		this.pic = pic;
	}






	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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

	public Publisher getPublisher() {
		return publisher;
	}

	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}
	
	
	
	
	
}
