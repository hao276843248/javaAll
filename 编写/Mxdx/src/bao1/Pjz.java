package bao1;

import java.util.Scanner;

public class Pjz {
	public int he;
	public int geshu;
	Scanner input=new Scanner(System.in);
	public int qiuHe(){
		System.out.println("�����뼸��ѧ��:");
		this.geshu=input.nextInt();
		for (int i = 0; i < this.geshu; i++) {
			System.out.println("������ɼ�");
			he+=input.nextInt();
		}
		return he;
	}
	public void  pjz(){
		double pjz=he/geshu;
		System.out.println("ƽ��ֵΪ:"+pjz);
	}
	
	
	public static void main(String[] args) {
		Pjz ping=new Pjz();
		ping.qiuHe();
		ping.pjz();
	}
	
}





