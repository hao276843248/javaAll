package cn.hao.camera.entity;

public class Camera {
	
	private Long id;
	private String title;
	private Integer pixel;
	private Double zoom;
	private Double lcd;
	private String color;
	private Double price;
	private String image;
	//相机与品牌的多对一关系
	private Brand brand;
	//相机与类型的多对一关系
	private Type type;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Integer getPixel() {
		return pixel;
	}
	public void setPixel(Integer pixel) {
		this.pixel = pixel;
	}
	public Double getZoom() {
		return zoom;
	}
	public void setZoom(Double zoom) {
		this.zoom = zoom;
	}
	public Double getLcd() {
		return lcd;
	}
	public void setLcd(Double lcd) {
		this.lcd = lcd;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public Brand getBrand() {
		return brand;
	}
	public void setBrand(Brand brand) {
		this.brand = brand;
	}
	public Type getType() {
		return type;
	}
	public void setType(Type type) {
		this.type = type;
	}

	
	
	
}




