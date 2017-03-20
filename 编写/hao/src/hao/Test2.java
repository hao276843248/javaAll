package hao;

import java.util.Scanner;

public class Test2 {

	public static void main(String[] args) {
		Scanner input = new Scanner (System.in);
		System.out.println("请输入你的成绩(输入0.5结束)");
		double a;
		do{
			
			a=input.nextDouble();
			if(a<60&&a!=0.5){
				System.out.println("成绩不几格");
			}else if(a>=60&&a<=100){
				System.out.println("成绩合格");
			}else if(a==0.5){
				break;
			}
		}while(a!=0.5);
		
	}	
}
