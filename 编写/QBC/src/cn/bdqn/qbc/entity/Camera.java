package cn.bdqn.qbc.entity;

/**
 * Camera entity. @author MyEclipse Persistence Tools
 */

public class Camera implements java.io.Serializable {

	// Fields

	private Long id;
	private Types types;
	private Brand brand;
	private String title;
	private Integer pixel;
	private Double zoom;
	private Double lcd;
	private String color;
	private Double price;
	private String image;
	private Integer status;

	// Constructors

	/** default constructor */
	public Camera() {
	}

	/** full constructor */
	public Camera(Long id, Types types, Brand brand, String title,
			Integer pixel, Double zoom, Double lcd, String color, Double price,
			String image, Integer status) {
		this.id = id;
		this.types = types;
		this.brand = brand;
		this.title = title;
		this.pixel = pixel;
		this.zoom = zoom;
		this.lcd = lcd;
		this.color = color;
		this.price = price;
		this.image = image;
		this.status = status;
	}

	// Property accessors

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Types getTypes() {
		return this.types;
	}

	public void setTypes(Types types) {
		this.types = types;
	}

	public Brand getBrand() {
		return this.brand;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getPixel() {
		return this.pixel;
	}

	public void setPixel(Integer pixel) {
		this.pixel = pixel;
	}

	public Double getZoom() {
		return this.zoom;
	}

	public void setZoom(Double zoom) {
		this.zoom = zoom;
	}

	public Double getLcd() {
		return this.lcd;
	}

	public void setLcd(Double lcd) {
		this.lcd = lcd;
	}

	public String getColor() {
		return this.color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Double getPrice() {
		return this.price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getImage() {
		return this.image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

}