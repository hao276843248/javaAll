package bao1;

public class Wendu {
	public void zhuan(double she){
		System.out.println("»ªÊÏÎÂ¶ÈÎª£º"+(she*9/5+32));
	}
	
	public static void main(String[] args) {
		Wendu hua=new Wendu();
		
		hua.zhuan(53);
	}
	
}
