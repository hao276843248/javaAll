package hao;

import java.util.Scanner;

public class asdasd {
	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		int[] a=new int[10];
		System.out.println("������10����");
		for (int i = 0; i <10; i++) {
			a[i]=input.nextInt();
		}
		System.out.print("�����ʮ����Ϊ");
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i]+",");
		}
		System.out.println();
		int sum1=0,sum2=0,sum3=0,sum4=0;
		for (int i = 0; i < a.length; i++) {
			if(a[i]==1){
				sum1++;
			}else if(a[i]==2){
				sum2++;
			}else if(a[i]==3){
				sum3++;
			}else{
				sum4++;
			}
		}
		System.out.println("����1�ĸ���Ϊ"+sum1);
		System.out.println("����2�ĸ���Ϊ"+sum2);
		System.out.println("����3�ĸ���Ϊ"+sum3);
		System.out.println("�Ƿ����ֵĸ���Ϊ"+sum4);
	}
}
