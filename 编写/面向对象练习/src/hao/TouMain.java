package hao;

import java.util.Scanner;

public class TouMain {
	
	public static TouService touservice=new TouService();
	public static void main(String []args){
		Scanner input=new Scanner(System.in);
		System.out.println("-----ͶƱϵͳ------");
		System.out.println("��һ������Ӻ�ѡ��");
		do {
			add();
			System.out.println("�Ƿ����(Y/N)");
			String a=input.next();
			if(a.equalsIgnoreCase("N")){
				break;
			}
		} while (true);
		System.out.println("�ڶ�������ѡ��ͶƱ");
		do {
			tou();
			System.out.println("�Ƿ����(Y/N)");
			String a=input.next();
			if(a.equalsIgnoreCase("N")){
				break;
			}
		} while (true);
		show();
	}
	
	public static void add(){
		Scanner input=new Scanner(System.in);
		System.out.println("�������ѡ��������");
		String name=input.next();
		int x=touservice.addren(name);
		if(x==-1){
			System.out.println("��ѡ���Ѵ���");
		}
	}
	public static void tou(){
		Scanner input=new Scanner(System.in);
		System.out.println("�������ѡ��������");
		String name=input.next();
		int x=touservice.addren(name);
		if(x==-2){
			System.out.println("ͶƱ�ɹ�");
		}else{
			System.out.println("ͶƱʧ��");
		}
	}
	public static void show(){
		Ren ren[]=touservice.show();
		for (int i = 0; i < ren.length; i++) {
			System.out.println(i+1+"\t"+ren[i].getName()+"\t"+ren[i].getPiao());
		}
	}
}
