
public class Test extends Thread{
	private int a=1;
	public void run() {
		try {
			while(a<=100){
				System.out.println(a+" !");
				a++;
				Thread.sleep(1000);
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
