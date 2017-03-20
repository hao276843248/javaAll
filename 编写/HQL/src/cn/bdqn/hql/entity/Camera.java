package cn.bdqn.hql.entity;

public class Camera {

	private Long id;
	private Long typeId;
	private Long brandId;
	private String title;
	private int pixel;
	private double zoom;
	private double lcd;
	private String color;
	private double price;
	private String image;
	private int status;
	
	public Camera() {
		// TODO Auto-generated constructor stub
	}
	
	public Camera(String title,double price,int pixel) {
		this.title=title;
		this.price=price;
		this.pixel=pixel;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getTypeId() {
		return typeId;
	}
	public void setTypeId(Long typeId) {
		this.typeId = typeId;
	}
	public Long getBrandId() {
		return brandId;
	}
	public void setBrandId(Long brandId) {
		this.brandId = brandId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getPixel() {
		return pixel;
	}
	public void setPixel(int pixel) {
		this.pixel = pixel;
	}
	public double getZoom() {
		return zoom;
	}
	public void setZoom(double zoom) {
		this.zoom = zoom;
	}
	public double getLcd() {
		return lcd;
	}
	public void setLcd(double lcd) {
		this.lcd = lcd;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
	
	
	
}
