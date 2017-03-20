package TOI;

public class TestWit {
	public static void main(String[] args) {
		TestAccount r=new TestAccount();
		Thread one=new Thread(r);
		Thread two=new Thread(r);
		one.setName("张三");
		two.setName("张三的妻子");
		one.start();
		two.start();
	}
}
