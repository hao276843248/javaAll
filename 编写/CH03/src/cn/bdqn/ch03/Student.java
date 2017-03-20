package cn.bdqn.ch03;

import java.io.Serializable;

public class Student implements Serializable {
	//默认地，系统会为实现了Serializable接口的类自动分配序列化版本号
	//这个版本号每次重新编译都会更新，会导致反序列化失败
	//可以手工地在类中显式定义版本号，使之固定不变
	
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
