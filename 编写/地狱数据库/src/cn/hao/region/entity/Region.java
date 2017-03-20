package cn.hao.region.entity;

/**
 * Region entity. @author MyEclipse Persistence Tools
 */

public class Region implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer parentId;
	private String name;

	// Constructors

	/** default constructor */
	public Region() {
	}

	/** minimal constructor */
	public Region(String name) {
		this.name = name;
	}

	/** full constructor */
	public Region(Integer parentId, String name) {
		this.parentId = parentId;
		this.name = name;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getParentId() {
		return this.parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

}