package CH0909;

public class ShpinText {
	public static void main(String[] args) {
		Shpin sp1=new Shpin();
		sp1.show();
		System.out.println();
		Shpin sp2=new Shpin("̨ʽ��",103023913, "���", 5000,10);
		sp2.show();
		System.out.println();
		Shpin sp3=new Shpin();
		sp3.setPinpai("����");
		sp3.setName("��Ϸ��");
		sp3.setNume(1233210);
		sp3.setDanjia(-12);
		sp3.setGeshu(-213123);
		sp3.show1();
	}
}
