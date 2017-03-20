package CH0909;

public class ShpinText {
	public static void main(String[] args) {
		Shpin sp1=new Shpin();
		sp1.show();
		System.out.println();
		Shpin sp2=new Shpin("台式机",103023913, "宏基", 5000,10);
		sp2.show();
		System.out.println();
		Shpin sp3=new Shpin();
		sp3.setPinpai("联想");
		sp3.setName("游戏本");
		sp3.setNume(1233210);
		sp3.setDanjia(-12);
		sp3.setGeshu(-213123);
		sp3.show1();
	}
}
