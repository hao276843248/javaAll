package hao;

import java.util.Scanner;

/*��ϰ2:��д����ģ���̳�����
	    �̳��ڹ������ʱ���Ը��ݹ˿͹���Ľ������ʵ����Żݡ�
	    ���۵Ĺ�����:
	    ����û��������Ʒ����500Ԫ��������
	Ҫ��: 1.�����û�����Ĺ������������ۺ���
	       ��ʾ:�ж�����û��Ĺ��������500Ԫ����:
	       ���ۺ���=������*0.9
	    2.��������ǰӦ���ʵ���ʾ
	��ʾ:
	    ����ʹ��if�ṹ���*/
public class Test4 {

	public static void main(String[] args){
		Scanner input=new Scanner(System.in);
		int a;
		double b;
		do{
			System.out.println("��������Ĺ��������0������");
			a=input.nextInt();
			if(a>500){
				b=a*0.9;
				System.out.println("��ô����Żݣ����ۺ���Ϊ"+b);
			}else if(a!=0){
				System.out.println("û�д����Żݣ�");
			}
		}while(a!=0);
	}
	
}













