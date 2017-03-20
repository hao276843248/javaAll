package cn.bdqn.ch03;

import java.io.Serializable;

public class Student implements Serializable {
	//Ĭ�ϵأ�ϵͳ��Ϊʵ����Serializable�ӿڵ����Զ��������л��汾��
	//����汾��ÿ�����±��붼����£��ᵼ�·����л�ʧ��
	//�����ֹ�����������ʽ����汾�ţ�ʹ֮�̶�����
	
	private static final long serialVersionUID = 8426595267067549927L;
	
	private int id;
	private String name;
	private int age;
	private double weight;
	
	public Student() {
		// TODO Auto-generated constructor stub
	}

	public Student(int id, String name, int age,double weight) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.weight=weight;
	}



	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	
	
}
