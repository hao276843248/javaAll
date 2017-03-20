package cn.bdqn.mybatis.entity;

import java.util.List;


//相机品牌
public class Brand {
	private long id;
	private String name;
	//品牌和相机之间的一对多关系，一个品牌可以关联多个相机
	private List<Camera> cameras;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Camera> getCameras() {
		return cameras;
	}
	public void setCameras(List<Camera> cameras) {
		this.cameras = cameras;
	}
	
	
	
}








