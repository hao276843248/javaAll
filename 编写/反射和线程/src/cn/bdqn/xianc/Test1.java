package cn.bdqn.xianc;

public class Test1 {
	public static void main(String[] args) {
		MyThread a=new MyThread();
		a.start();
		System.out.println("v2---"+a.v2);
		System.out.println("v1---"+a.v1);
		
	}
}
