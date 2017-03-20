package cn.bdqn.hibernate.entity;

public class Book {
	
	private Integer id;
	private Integer pid;
	private String author;
	private String title;
	private double price;
	private String pic;
	
	public Book() {
		// TODO Auto-generated constructor stub
	}
	
	public Book(Integer pid, String author, String title, double price,
			String pic) {
		super();
		this.pid = pid;
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
