package QunLiao;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		
		System.out.println("������˿ں�");
		int duankou=input.nextInt();
		System.out.println("������㲥��ַ");
		String ip=input.next();
		System.out.println("�������ǳ�");
		String name=input.next();
		FaSong fa=new FaSong(ip, duankou, name);
		JieShou jie=new JieShou(duankou);
		fa.start();
		jie.start();
		
		
	}
}
