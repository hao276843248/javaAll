	package hao;

import java.util.Scanner;

public class Test8 {

	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		String[][] ku={{"ƻ��","apple"},{"�㽶","banana"},{"����","orange"},{"ѧ��","student"},{"��ʦ","teacher"},{"ʱ��","time"},{"�к�","boy"},{"Ů��","girl"},{"�༶","class"},{"��","good"},{"��","book"},{"��","com"},{"ȥ","go"}};
		int shu=5;
		int[] zu =new int[5];
		out:for(int i=0;i<5;i++){
				int random=(int)(Math.random()*13);
				for(int j=0;j<i;j++){
					if(zu[j]==random){
						i--;
						continue out;
					}
				}
				zu[i]=random;
				System.out.println("������["+ku[zu[i]][0]+"]��Ӣ�ĵ��ʣ�");
				String a=input.next();
				if(a.equalsIgnoreCase(ku[zu[i]][1])){
					System.out.println("�����!");
				}else{
					System.out.println("�����!");
					shu--;
				}
		}
		System.out.println("------------------------------------");
		System.out.println("���Խ��������"+shu+"�⣬��5��");
	}
}
