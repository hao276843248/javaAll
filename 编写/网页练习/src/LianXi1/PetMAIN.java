package LianXi1;

import java.util.Scanner;

public class PetMAIN {
	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		System.out.println("��ӭ����������꣡");
		System.out.println("��������Ҫ�����ĳ������֣�");
		String newname=input.next();
		System.out.println("��ѡ�������������ͣ�1������2����죩");
		int x=input.nextInt();
		switch (x) {
			case 1:
				Pet dog=new Dog();
				System.out.println("��ѡ�񹷹�����(1����������������   2����������Ħ)");
				String leix="��������������";
				int a=input.nextInt();
				if(a==1){
					leix="��������Ħ";
				}
				System.out.println("�����빷���Ľ���ֵ��1-100����");
				dog.setJiankzhi(input.nextInt());
				int jkz=dog.getJiankzhi();
				dog=new Dog(newname, jkz, 0, leix);
				Dog dg=(Dog) dog;
				dg.show();
				break;
			case 2:
				Pet qe=new QiE();
				System.out.println("��ѡ������Ա�(1��Q��   2��Q��)");
				String sex="Q��";
				int b=input.nextInt();
				if(b==1){
					sex="Q��";
				}
				System.out.println("���������Ľ���ֵ��1-100����");
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
