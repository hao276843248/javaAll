package cn.bdqn.xianc;

public class MyThread extends Thread {
	public String v1;
	public String v2;
	
	@Override
	public void run() {
		v1="v1aa";
		v2="v2aa";
	}
}
