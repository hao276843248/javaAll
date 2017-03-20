package LianXi1;

public class QiE extends Pet {
	private String sex;
	
	public QiE() {
	}
	
	public  QiE(String name, int jiankzhi, int love,String sex) {
		super(name, jiankzhi, love);
		this.sex=sex;
	}


	public String getSex() {
		return sex;
	}


	public void setSex(String sex) {
		this.sex = sex;
	}
	
	public void show(){
		System.out.println("我的名字叫"+getName()+",健康值是"+getJiankzhi()+",和主人的亲密度是"+getLove()+",我的性别是"+getSex());
	}
	
}
