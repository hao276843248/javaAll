package CH0909;

public class Shpin {
	private String name;
	private int nume;
	private String pinpai;
	private double danjia;
	private double geshu;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getNume() {
		
		return nume;
	}
	public void setNume(int nume) {
		if(nume<1){
			System.out.println("��������,����(1)");
			this.nume=1;
			return;
		}else{
			this.nume = nume;
		}
	}
	public String getPinpai() {
		return pinpai;
	}
	public void setPinpai(String pinpai) {
		this.pinpai = pinpai;
	}
	public double getDanjia() {
		
		return danjia;
	}
	public void setDanjia(double danjia) {
		if(danjia<0){
			System.out.println("���ۼ۸���������4999Ԫ");
			this.danjia=4999;
			return;
		}else{
			this.danjia=danjia;
		}
	}
	public double getGeshu() {
		return geshu;
	}
	public void setGeshu(double geshu) {
		if(geshu<0){
			System.out.println("������������1��");
			geshu=1;
		}else{
			this.geshu = geshu;
		}
	}
	public Shpin() {
		name="�ʼǱ�";
		nume=19900808;
		pinpai="����";
		danjia=3999;
		geshu=1;
	}
	public Shpin(String name,int nume,String pinpai,double danjia,double geshu){
		this.name=name;
		this.nume=nume;
		this.pinpai=pinpai;
		this.danjia=danjia;
		this.geshu=geshu;
	}
	public void show(){
		System.out.println("��Ʒ���(����):"+this.nume+"\n��Ʒ����:"+this.name+"\n��ƷƷ��:"+this.pinpai+"\n��Ʒ����(Ԫ):"+this.danjia+"\n��Ʒ����:"+this.geshu);
	}
	public void show1(){
		System.out.println("��Ʒ���(����):"+this.getNume()+"\n��Ʒ����:"+this.name+"\n��ƷƷ��:"+this.pinpai+"\n��Ʒ����(Ԫ):"+this.getDanjia()+"\n��Ʒ����:"+this.getGeshu());
	}
}
