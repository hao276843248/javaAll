package bao1;

public class Person {
	public String name;
	private int age;
	private String gender;
	private String bsd;
	private String nume;
	private String zhuzhi;
	
	

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getBsd() {
		
		return bsd;
	}

	public void setBsd(String bsd) {
		this.bsd = bsd;
	}

	public String getNume() {
		return nume;
	}

	public void setNume(String nume) {
		this.nume = nume;
	}

	public String getZhuzhi() {
		return zhuzhi;
	}

	public void setZhuzhi(String zhuzhi) {
		this.zhuzhi = zhuzhi;
	}

	public void  pout(){
		System.out.println(name+"\n"+age+"\n"+gender+"\n"+bsd+"\n"+nume+"\n"+zhuzhi);
	}	
		
	
}
