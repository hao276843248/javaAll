package hao;

import java.util.Scanner;

public class Test1 {

	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		System.out.println("请输入你的出生年份");
		int S=input.nextInt();
		switch(S%12){
		case 0:
			System.out.println("你的生肖为猴");
			break;
		case 1:
			System.out.println("你的生肖为鸡");
			break;
		case 2:
			System.out.println("你的生肖为狗");
			break;
		case 3:
			System.out.println("你的生肖为猪");
			break;
		case 4:
			System.out.println("你的生肖为鼠");
			break;
		case 5:
			System.out.println("你的生肖为牛");
			break;
		case 6:
			System.out.println("你的生肖为虎");
			break;
		case 7:
			System.out.println("你的生肖为兔");
			break;
		case 8:
			System.out.println("你的生肖为龙");
			break;
		case 9:
			System.out.println("你的生肖为蛇");
			break;
		case 10:
			System.out.println("你的生肖为马");
			break;
		case 11:
			System.out.println("你的生肖为羊");
			break;
		}
	}
	
}
