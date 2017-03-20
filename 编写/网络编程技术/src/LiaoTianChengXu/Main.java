package LiaoTianChengXu;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		
		System.out.println("请输入本机端口号：");
		int duankou=input.nextInt();
		
		System.out.println("请输入对方ip：");
		String ip=input.next();
		
		System.out.println("对方端口号");
		int duiduankou=input.nextInt();
		System.out.println("请输入昵称：");
		String name=input.next();
		
		JieShouXinXI jie=new JieShouXinXI( duankou);
		FaSongXinXi fa=new FaSongXinXi(ip, duiduankou, name);
		
		jie.start();
		fa.start();
	}
}
