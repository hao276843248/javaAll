package LianXi1;

import java.util.Scanner;

public class PetMAIN {
	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		System.out.println("欢迎您来到宠物店！");
		System.out.println("请输入你要领养的宠物名字：");
		String newname=input.next();
		System.out.println("请选择领养宠物类型（1、狗狗2、企鹅）");
		int x=input.nextInt();
		switch (x) {
			case 1:
				Pet dog=new Dog();
				System.out.println("请选择狗狗种类(1、聪明的拉布拉多   2、呆呆的萨摩)");
				String leix="聪明的拉布拉多";
				int a=input.nextInt();
				if(a==1){
					leix="呆呆的萨摩";
				}
				System.out.println("请输入狗狗的健康值（1-100）：");
				dog.setJiankzhi(input.nextInt());
				int jkz=dog.getJiankzhi();
				dog=new Dog(newname, jkz, 0, leix);
				Dog dg=(Dog) dog;
				dg.show();
				break;
			case 2:
				Pet qe=new QiE();
				System.out.println("请选择企鹅性别(1、Q仔   2、Q妹)");
				String sex="Q妹";
				int b=input.nextInt();
				if(b==1){
					sex="Q仔";
				}
				System.out.println("请输入企鹅的健康值（1-100）：");
				qe.setJiankzhi(input.nextInt());
				int jkz1=qe.getJiankzhi();
				qe=new QiE(newname,jkz1, 0, sex);
				QiE asd=(QiE) qe;
				asd.show();
				break;
			default:
				break;
		}	
		
	}
}
