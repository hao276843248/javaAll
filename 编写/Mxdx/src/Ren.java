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
		if(gender.equals("��")||gender.equals("Ů")){
			this.gender =gender;
		}else{
			System.out.println("�����Ա𲻺Ϸ���������");
			this.gender="��";
		}
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		if(age>=0&&age<=120){
			this.age = age;	
		}else{
			System.out.println("��������Ϊ"+age+",�����䲻�Ϸ���������");
			this.age=18;
		}
	}
	
	public void Show(){
		System.out.println("���ҽ���һ��");
		System.out.println("����:"+this.name);
		System.out.println("�Ա�:"+this.getGender());
		System.out.println("����:"+this.getAge()+"��");
	}
	
	
}



