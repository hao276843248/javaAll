package QunLiao;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		
		System.out.println("ÇëÊäÈë¶Ë¿ÚºÅ");
		int duankou=input.nextInt();
		System.out.println("ÇëÊäÈë¹ã²¥µØÖ·");
		String ip=input.next();
		System.out.println("ÇëÊäÈëêÇ³Æ");
		String name=input.next();
		FaSong fa=new FaSong(ip, duankou, name);
		JieShou jie=new JieShou(duankou);
		fa.start();
		jie.start();
		
		
	}
}
