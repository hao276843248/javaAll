package cn.bdqn.test.action;

import cn.bdqn.test.entity.Person;

import com.opensymphony.xwork2.ActionSupport;

public class HelloAction2 extends ActionSupport{
	
	private Person person;

	
	@Override
	public String execute() throws Exception {
		System.out.println("µ˜”√¡ÀHelloAction");
		System.out.println("name="+person.getName());
		System.out.println("age="+person.getAge());
		System.out.println("height="+person.getHeight());
		return NONE;
	}
	
	
	public Person getPerson() {
		return person;
	}
	
	public void setPerson(Person person) {
		this.person = person;
	}
	
	
}





