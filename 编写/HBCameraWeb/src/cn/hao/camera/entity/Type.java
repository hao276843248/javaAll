package cn.hao.camera.entity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


//�������
public class Type {
	private long id;
	private String name;
	//���ͺ����֮���һ�Զ��ϵ��һ��Ʒ�ƿ��Թ���������
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
