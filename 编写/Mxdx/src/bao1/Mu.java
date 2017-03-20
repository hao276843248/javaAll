package bao1;

public class Mu {
	public void zhuan(double ping){
		System.out.println("Ä¶ÊýÎª:"+((ping+ping/2)*0.001));
	}
	
	
	public static void main(String[] args) {
		Mu mu=new Mu();
		mu.zhuan(200);
	}
}
