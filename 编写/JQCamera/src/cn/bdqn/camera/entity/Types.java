package cn.bdqn.camera.entity;

import java.util.HashSet;
import java.util.Set;

import org.apache.struts2.json.annotations.JSON;

/**
 * Types entity. @author MyEclipse Persistence Tools
 */

public class Types implements java.io.Serializable {

	// Fields

	private Long id;
	private String name;
	private Set cameras = new HashSet(0);

	// Constructors

	/** default constructor */
	public Types() {
	}

	/** minimal constructor */
	public Types(Long id, String name) {
		this.id = id;
		this.name = name;
	}

	/** full constructor */
	public Types(Long id, String name, Set cameras) {
		this.id = id;
		this.name = name;
		this.cameras = cameras;
	}

	// Property accessors

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}
	@JSON(serialize=false)
	public Set getCameras() {
		return this.cameras;
	}

	public void setCameras(Set cameras) {
		this.cameras = cameras;
	}

}