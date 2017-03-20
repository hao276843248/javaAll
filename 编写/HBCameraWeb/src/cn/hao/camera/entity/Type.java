package cn.hao.camera.entity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


//相机类型
public class Type {
	private long id;
	private String name;
	//类型和相机之间的一对多关系，一个品牌可以关联多个相机
	private Set<Camera> cameras=new HashSet<Camera>();
	public Type() {
		// TODO Auto-generated constructor stub
	}
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
	public Set<Camera> getCameras() {
		return cameras;
	}
	public void setCameras(Set<Camera> cameras) {
		this.cameras = cameras;
	}
	
	
}
