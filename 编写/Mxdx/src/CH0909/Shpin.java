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
			System.out.println("设置有误,重置(1)");
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
			System.out.println("单价价格有误！重置4999元");
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
			System.out.println("数量有误！重置1个");
			geshu=1;
		}else{
			this.geshu = geshu;
		}
	}
	public Shpin() {
		name="笔记本";
		nume=19900808;
		pinpai="戴尔";
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
		System.out.println("商品编号(整数):"+this.nume+"\n商品名称:"+this.name+"\n商品品牌:"+this.pinpai+"\n商品单价(元):"+this.danjia+"\n商品数量:"+this.geshu);
	}
	public void show1(){
		System.out.println("商品编号(整数):"+this.getNume()+"\n商品名称:"+this.name+"\n商品品牌:"+this.pinpai+"\n商品单价(元):"+this.getDanjia()+"\n商品数量:"+this.getGeshu());
	}
}
