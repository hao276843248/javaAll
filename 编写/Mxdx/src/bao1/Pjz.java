package bao1;

import java.util.Scanner;

public class Pjz {
	public int he;
	public int geshu;
	Scanner input=new Scanner(System.in);
	public int qiuHe(){
		System.out.println("请输入几个学生:");
		this.geshu=input.nextInt();
		for (int i = 0; i < this.geshu; i++) {
			System.out.println("请输入成绩");
			he+=input.nextInt();
		}
		return he;
	}
	public void  pjz(){
		double pjz=he/geshu;
		System.out.println("平均值为:"+pjz);
	}
	
	
	public static void main(String[] args) {
		Pjz ping=new Pjz();
		ping.qiuHe();
		ping.pjz();
	}
	
}





