package cn.hao.book.util;

public class Context {

	public static ThreadLocal tl=new ThreadLocal();
	
	public static Object get(){
		return tl.get();
	}
	
	public static void set(Object obj){
		tl.set(obj);
	}
}
