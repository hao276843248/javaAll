package LiaoTianChengXu;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		
		System.out.println("�����뱾���˿ںţ�");
		int duankou=input.nextInt();
		
		System.out.println("������Է�ip��");
		String ip=input.next();
		
		System.out.println("�Է��˿ں�");
		int duiduankou=input.nextInt();
		System.out.println("�������ǳƣ�");
		String name=input.next();
		
		JieShouXinXI jie=new JieShouXinXI( duankou);
		FaSongXinXi fa=new FaSongXinXi(ip, duiduankou, name);
		
		jie.start();
		fa.start();
	}
}
