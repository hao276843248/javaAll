package bao1;

public class Student {
	public String name;
	public int age;
	public String gender;
	public String bsd;
	public String nume;
	public String zhuzhi;
	
	public Student(String name,int age,String gender,String bsd,String nume,String zhuzhi) {
		this.name=name;
		this.age=age;
		this.bsd=bsd;
		this.gender=gender;
		this.nume=nume;
		this.zhuzhi=zhuzhi;
	}
	public void show(){
		System.out.println(name+"\n"+age+"\n"+gender+"\n"+bsd+"\n"+nume+"\n"+zhuzhi);
	}
	
	public static void main(String[] args) {
		Student stu1=new Student("����",19,"Ů","2000-12-10","20931203841","�԰׽�");
		stu1.show();
		Person stu2=new Person();
		stu2.name="�������";
		stu2.setAge(18);
		stu2.setBsd("1996.10.18");
		stu2.setNume("1991561433");
		stu2.setZhuzhi("������ͨ����");
		stu2.setGender("man");
		stu2.pout();
	}	
	
}
