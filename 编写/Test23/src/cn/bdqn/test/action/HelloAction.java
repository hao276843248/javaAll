package cn.bdqn.test.action;

import com.opensymphony.xwork2.ActionSupport;

public class HelloAction extends ActionSupport{
	
	private String name;
	private int age;
	private double height;

	
	@Override
	public String execute() throws Exception {
		System.out.println("µ˜”√¡ÀHelloAction");
		System.out.println("name="+name);
		System.out.println("age="+age);
		System.out.println("height="+height);
		return NONE;
	}
	
	
	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public double getHeight() {
		return height;
	}
	
	public void setHeight(double height) {
		this.height = height;
	}
}





