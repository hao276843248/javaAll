package cn.hao.camera.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Camera entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "CAMERA", schema = "SCOTT")
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
	@Id
	@Column(name = "ID", unique = true, nullable = false, precision = 10, scale = 0)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "TYPEID", nullable = false)
	public Types getTypes() {
		return this.types;
	}

	public void setTypes(Types types) {
		this.types = types;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "BRANDID", nullable = false)
	public Brand getBrand() {
		return this.brand;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}

	@Column(name = "TITLE", nullable = false)
	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Column(name = "PIXEL", nullable = false, precision = 8, scale = 0)
	public Integer getPixel() {
		return this.pixel;
	}

	public void setPixel(Integer pixel) {
		this.pixel = pixel;
	}

	@Column(name = "ZOOM", nullable = false, precision = 8)
	public Double getZoom() {
		return this.zoom;
	}

	public void setZoom(Double zoom) {
		this.zoom = zoom;
	}

	@Column(name = "LCD", nullable = false, precision = 8)
	public Double getLcd() {
		return this.lcd;
	}

	public void setLcd(Double lcd) {
		this.lcd = lcd;
	}

	@Column(name = "COLOR", nullable = false)
	public String getColor() {
		return this.color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Column(name = "PRICE", nullable = false, precision = 8)
	public Double getPrice() {
		return this.price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@Column(name = "IMAGE", nullable = false, length = 100)
	public String getImage() {
		return this.image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@Column(name = "STATUS", nullable = false, precision = 8, scale = 0)
	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

}