package hao;

import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		System.out.println("�����븸�׵�Ѫ��");
		String fu=input.next();
		System.out.println("������ĸ�׵�Ѫ��");
		String mu=input.next();
		if("a".equalsIgnoreCase(fu)&&"a".equalsIgnoreCase(mu)){
			System.out.println("��Ů�����е�Ѫ��:A,O");
			System.out.println("��Ů�������е�Ѫ��:B,AB");
		}else if("a".equalsIgnoreCase(fu)&&"b".equalsIgnoreCase(mu)){
			System.out.println("��Ů�����е�Ѫ��:A,B,AB,O");
			System.out.println("��Ů�������е�Ѫ��:��");
		}else if("a".equalsIgnoreCase(fu)&&"ab".equalsIgnoreCase(mu)){
			System.out.println("��Ů�����е�Ѫ��:A,B,AB");
			System.out.println("��Ů�������е�Ѫ��:O");
		}else if("a".equalsIgnoreCase(fu)&&"o".equalsIgnoreCase(mu)){
			System.out.println("��Ů�����е�Ѫ��:A,O");
			System.out.println("��Ů�������е�Ѫ��:B,AB");
		}else if("b".equalsIgnoreCase(fu)&&"b".equalsIgnoreCase(mu)){
			System.out.println("��Ů�����е�Ѫ��:B,O");
			System.out.println("��Ů�������е�Ѫ��:A,AB");
		}else if("b".equalsIgnoreCase(fu)&&"o".equalsIgnoreCase(mu)){
			System.out.println("��Ů�����е�Ѫ��:A,B,AB");
			System.out.println("��Ů�������е�Ѫ��:O");
		}else if("b".equalsIgnoreCase(fu)&&"ab".equalsIgnoreCase(mu)){
			System.out.println("��Ů�����е�Ѫ��:B,O");
			System.out.println("��Ů�������е�Ѫ��:A,AB");
		}else if("ab".equalsIgnoreCase(fu)&&"o".equalsIgnoreCase(mu)){
			System.out.println("��Ů�����е�Ѫ��:A,B");
			System.out.println("��Ů�������е�Ѫ��:O,AB");
		}else if("ab".equalsIgnoreCase(fu)&&"ab".equalsIgnoreCase(mu)){
			System.out.println("��Ů�����е�Ѫ��:A,B,AB");
			System.out.println("��Ů�������е�Ѫ��:O");
		}else if("o".equalsIgnoreCase(fu)&&"o".equalsIgnoreCase(mu)){
			System.out.println("��Ů�����е�Ѫ��:O");
			System.out.println("��Ů�������е�Ѫ��:A,B,AB");
		}
		
	}
	
}
