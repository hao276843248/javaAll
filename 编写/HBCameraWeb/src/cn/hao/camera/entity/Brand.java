package cn.hao.camera.entity;

import java.util.HashSet;

import java.util.Set;


//相机品牌
public class Brand {
	private Long id;
	private String name;
	//品牌和相机之间的一对多关系，一个品牌可以关联多个相机
	private Set<Camera> cameras=new HashSet<Camera>();
	
	public Brand() {
		// TODO Auto-generated constructor stub
	}
	public Brand(Long id, String name, Set<Camera> cameras) {
		super();
		this.id = id;
		this.name = name;
		this.cameras = cameras;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Set<Camera> getCameras() {
		return cameras;
	}
	public void setCameras(Set<Camera> cameras) {
		this.cameras = cameras;
	}
	
}








