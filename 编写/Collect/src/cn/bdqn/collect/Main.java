package cn.bdqn.collect;

public class Main {

	public static void main(String[] args) {

		String savePath="D:\\content";
	
		//创建分组采集线程
		CollectThread t1=new CollectThread(1,2,10, savePath);
		CollectThread t2=new CollectThread(3,4,10, savePath);
		CollectThread t3=new CollectThread(5,6,10, savePath);
		CollectThread t4=new CollectThread(7,8,10, savePath);
		CollectThread t5=new CollectThread(9,10,10, savePath);
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
		
		
	}
	
}
