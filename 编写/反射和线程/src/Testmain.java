
public class Testmain {
	public static void main(String[] args) {
		Test a=new Test();
		a.start();
		
		Test1 b=new Test1();
		Thread c=new Thread(b);
		Thread d=new Thread(b);
		d.start();
		c.start();
	}
}
