package cn.bdqn.test.action;

import cn.bdqn.test.entity.Person;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class HelloAction3 extends ActionSupport implements ModelDriven<Person>{
	
	private Person person=new Person();

	@Override
	public Person getModel() {
		return person;
	}
	
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





