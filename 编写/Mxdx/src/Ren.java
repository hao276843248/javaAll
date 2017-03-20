import java.util.Scanner;


public class Ren {
	private String name;
	private String gender;
	private int age;
	private String bsd;
	
	
	public String getBsd() {
		
		return bsd;
	}
	public void setBsd(String bsd) {
		this.bsd = bsd;
	}

	Scanner input=new Scanner (System.in);
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name=name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		if(gender.equals("男")||gender.equals("女")){
			this.gender =gender;
		}else{
			System.out.println("输入性别不合法，将重置");
			this.gender="男";
		}
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		if(age>=0&&age<=120){
			this.age = age;	
		}else{
			System.out.println("输入年龄为"+age+",该年龄不合法，将重置");
			this.age=18;
		}
	}
	
	public void Show(){
		System.out.println("自我介绍一下");
		System.out.println("姓名:"+this.name);
		System.out.println("性别:"+this.getGender());
		System.out.println("年龄:"+this.getAge()+"岁");
	}
	
	
}



