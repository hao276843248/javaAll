package cn.bdqn.mybatis.entity;

import java.util.List;


//���Ʒ��
public class Brand {
	private long id;
	private String name;
	//Ʒ�ƺ����֮���һ�Զ��ϵ��һ��Ʒ�ƿ��Թ���������
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








