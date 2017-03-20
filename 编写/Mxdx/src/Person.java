
public class Person {
	
	public String name;
	public String gender;
	public int age;
	public Person(){
		this.name="寒冰";
	}
	public Person(String name){
		this.name =name;
	}
	public void work(){
		System.out.println(this.name+"的工作理念：干活挣钱有饭吃");
	}
	
	public void work(String name,String gender,int age){
		System.out.println("自我介绍一下");
		System.out.println("姓名:"+this.name);
		System.out.println("性别:"+this.gender);
		System.out.println("年龄:"+this.age);
	}
	public void work(String contect){
		int age =this.age;
		System.out.println(this.name +age+"岁的工作理念："+contect);
		
	}
}











