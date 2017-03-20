package hao;

import java.util.Scanner;

public class TouMain {
	
	public static TouService touservice=new TouService();
	public static void main(String []args){
		Scanner input=new Scanner(System.in);
		System.out.println("-----投票系统------");
		System.out.println("第一步：添加候选人");
		do {
			add();
			System.out.println("是否继续(Y/N)");
			String a=input.next();
			if(a.equalsIgnoreCase("N")){
				break;
			}
		} while (true);
		System.out.println("第二步：候选人投票");
		do {
			tou();
			System.out.println("是否继续(Y/N)");
			String a=input.next();
			if(a.equalsIgnoreCase("N")){
				break;
			}
		} while (true);
		show();
	}
	
	public static void add(){
		Scanner input=new Scanner(System.in);
		System.out.println("请输入候选人姓名：");
		String name=input.next();
		int x=touservice.addren(name);
		if(x==-1){
			System.out.println("候选人已存在");
		}
	}
	public static void tou(){
		Scanner input=new Scanner(System.in);
		System.out.println("请输入候选人姓名：");
		String name=input.next();
		int x=touservice.addren(name);
		if(x==-2){
			System.out.println("投票成功");
		}else{
			System.out.println("投票失败");
		}
	}
	public static void show(){
		Ren ren[]=touservice.show();
		for (int i = 0; i < ren.length; i++) {
			System.out.println(i+1+"\t"+ren[i].getName()+"\t"+ren[i].getPiao());
		}
	}
}
