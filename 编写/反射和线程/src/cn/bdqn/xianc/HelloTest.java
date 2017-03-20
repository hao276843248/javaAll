package cn.bdqn.xianc;

public class HelloTest {
	public static void main(String[] args) throws InterruptedException {
		Thread t1=new Thread(new Test());
		Thread t2=new Thread(new Test());
		//t1.setPriority(1);
		//t2.setPriority(10);
		t1.start();
		t2.start();
		t2.join();
		
	}
}
