package TOI;

public class TestWit {
	public static void main(String[] args) {
		TestAccount r=new TestAccount();
		Thread one=new Thread(r);
		Thread two=new Thread(r);
		one.setName("����");
		two.setName("����������");
		one.start();
		two.start();
	}
}
