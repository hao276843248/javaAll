
public class Test1 implements Runnable{
	private int a;
	@Override
	public void run() {
		try {
			while(a<=100){
				System.out.println(a+"---"+"****");
				a++;
				Thread.sleep(1000);
			}
		
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
}
