package cn.bdqn.camera.entity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


//���Ʒ��
public class Brand {
	private Long id;
	private String name;
	//Ʒ�ƺ����֮���һ�Զ��ϵ��һ��Ʒ�ƿ��Թ���������
	private Set<Camera> cameras=new HashSet<Camera>();
	
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








