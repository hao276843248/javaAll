package cn.hao.test;

import java.util.Map;

import javax.swing.plaf.basic.BasicSliderUI.ActionScroller;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class aaaAction extends ActionSupport{
	private String name;
	private int age;
	private double hight;
	private String zhiye;
	private String sex;
	
	
	@Override
	public String execute() throws Exception {
		System.out.println(name);
		System.out.println(age);
		System.out.println(hight);
		System.out.println(zhiye);
		System.out.println(sex);
		Map<String,Object> reqMap=(Map<String, Object>) ActionContext.getContext().get("request");
		reqMap.put("name", name);
		reqMap.put("age", age);
		reqMap.put("hight", hight);
		reqMap.put("zhiye", zhiye);
		reqMap.put("sex", sex);
		return SUCCESS;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public double getHight() {
		return hight;
	}


	public void setHight(double hight) {
		this.hight = hight;
	}


	public String getZhiye() {
		return zhiye;
	}


	public void setZhiye(String zhiye) {
		this.zhiye = zhiye;
	}


	public String getSex() {
		return sex;
	}


	public void setSex(String sex) {
		this.sex = sex;
	}
	
	
}
