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
		System.out.println("�ҵ����ֽ�"+getName()+",����ֵ��"+getJiankzhi()+",�����˵����ܶ���"+getLove()+",�ҵ�������"+getLeixing());
	}


}
