package cn.hao.camera.entity;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Brand entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "BRAND", schema = "SCOTT")
public class Brand implements java.io.Serializable {

	// Fields

	private Long id;
	private String name;
	private Set<Camera> cameras = new HashSet<Camera>(0);

	// Constructors

	/** default constructor */
	public Brand() {
	}

	/** minimal constructor */
	public Brand(Long id, String name) {
		this.id = id;
		this.name = name;
	}

	/** full constructor */
	public Brand(Long id, String name, Set<Camera> cameras) {
		this.id = id;
		this.name = name;
		this.cameras = cameras;
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

	@Column(name = "NAME", nullable = false)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "brand")
	public Set<Camera> getCameras() {
		return this.cameras;
	}

	public void setCameras(Set<Camera> cameras) {
		this.cameras = cameras;
	}

}