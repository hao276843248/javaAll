package hao;

import java.util.Scanner;
	/*��ϰһ:
	����һ�����飬�����ĸ�ͬѧ������
	��ԭ�������ݵĻ����ϣ�׷��һ����ͬѧ������
	����:
	1.����ԭ���飬�����ĸ�ͬѧ����
	2.���������飬����Ϊԭ���鳤��+1
	3.ʹ��ѭ����ԭ�������ݸ��Ƶ���������
	4.����ͬѧ������ӵ����������һ��Ԫ����*/
public class SHUzu {

	public static void main(String[] args){
		Scanner input=new Scanner(System.in);
		String[] a=new String[]{"��","��","��","��"};
		String[] b=new String[5];
		for(int i=0;i<a.length;i++){
			System.out.print(a[i]);
			b[i]=a[i];
		}System.out.println();
		System.out.println("��������ͬѧ������");
		b[4] =input.next();
		for(int i=0;i<5;i++){
			System.out.print(b[i]+",");
		}
		System.out.println();
	}
	
}
