package LianXi1;

public class Dog extends Pet {
	private String leixing;
	
	public Dog() {
	}
	
	public Dog(String name, int jiankzhi, int love,String leixing) {
		super(name, jiankzhi, love);
		this.leixing=leixing;
	}
	
	public String getLeixing(){
		return leixing;
	}
	public void setLeixing(String leixing){
		this.leixing=leixing;

	}
	public void show(){
		System.out.println("我的名字叫"+getName()+",健康值是"+getJiankzhi()+",和主人的亲密度是"+getLove()+",我的类型是"+getLeixing());
	}


}
