package cn.bdqn.xianc;

public class Test implements Runnable {

	
	public void run() {
		String name=Thread.currentThread().getName();
		System.out.println("获得");
		for (int i = 1; i <=100; i++) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(name+"！"+i+"次输出hello");
		}
		
		
	}

}
