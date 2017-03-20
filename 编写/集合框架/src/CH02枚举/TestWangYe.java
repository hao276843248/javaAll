package CH02枚举;

import java.util.Scanner;

public class TestWangYe {
	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		System.out.println("请选择单元");
		
		
		DY a = null;
		switch(a){
			case U1:
				System.out.println("第一单元");
				break;
			case U2:
				System.out.println("第二单元");
				break;
			case U3:
				System.out.println("第三单元");
				break;
		}
		
		
	}
}
