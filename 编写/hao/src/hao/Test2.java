package hao;

import java.util.Scanner;

public class Test2 {

	public static void main(String[] args) {
		Scanner input = new Scanner (System.in);
		System.out.println("��������ĳɼ�(����0.5����)");
		double a;
		do{
			
			a=input.nextDouble();
			if(a<60&&a!=0.5){
				System.out.println("�ɼ�������");
			}else if(a>=60&&a<=100){
				System.out.println("�ɼ��ϸ�");
			}else if(a==0.5){
				break;
			}
		}while(a!=0.5);
		
	}	
}
