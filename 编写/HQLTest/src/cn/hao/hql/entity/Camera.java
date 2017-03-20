package cn.hao.hql.entity;

public class Camera {
	private Long id;
	private Long brandid;
	private Long typeid;
	private String title;
	private Integer pixel;
	private Double zoom;
	private Double lcd;
	private String color;
	private Double price;
	private String image;
	private Integer status;
	
	public Camera() {
	
	}
	
	
	public Camera(String title, Integer pixel, Double price) {
		super();
		this.title = title;
		this.pixel = pixel;
		this.price = price;
	}


	public Camera(Long id, Long brandid, Long typeid, String title,
			Integer pixel, Double zoom, Double lcd, String color,
			Double price, String image, Integer status) {
		super();
		this.id = id;
		this.brandid = brandid;
		this.typeid = typeid;
		this.title = title;
		this.pixel = pixel;
		this.zoom = zoom;
		this.lcd = lcd;
		this.color = color;
		this.price = price;
		this.image = image;
		this.status = status;
	}


	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getBrandid() {
		return brandid;
	}
	public void setBrandid(Long brandid) {
		this.brandid = brandid;
	}
	public Long getTypeid() {
		return typeid;
	}
	public void setTypeid(Long typeid) {
		this.typeid = typeid;
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
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	
	
	
}
