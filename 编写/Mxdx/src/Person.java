
public class Person {
	
	public String name;
	public String gender;
	public int age;
	public Person(){
		this.name="����";
	}
	public Person(String name){
		this.name =name;
	}
	public void work(){
		System.out.println(this.name+"�Ĺ�������ɻ���Ǯ�з���");
	}
	
	public void work(String name,String gender,int age){
		System.out.println("���ҽ���һ��");
		System.out.println("����:"+this.name);
		System.out.println("�Ա�:"+this.gender);
		System.out.println("����:"+this.age);
	}
	public void work(String contect){
		int age =this.age;
		System.out.println(this.name +age+"��Ĺ������"+contect);
		
	}
}











