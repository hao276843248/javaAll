package hao;

import java.util.Scanner;

public class Shuzu3 {

	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		String[] a=new String[]{"��","��","��","��","��","ԥ","��","��","³","��","��","��","��","��","ǭ","��","��","��","��","��","��","��","��","��","��","��","��","��","��","��","��","��","��","̨"};
		String[] b=new String[]{"����","���","�Ϻ�","����","�ӱ�","����","����","����","ɽ��","ɽ��","�㶫","����","�Ĵ�","����","����","����","�ຣ","����","����","����","����","������","�㽭","����","����","����","����","����","���ɹ�","�½�","����","���","����","̨��"};
		String c;
		int d=0;
		do{
			System.out.println("�������ȫ��(����0����)");
			c=input.next();
			if("0".equals(c)){
				break;
			}
			for(int i=0;i<b.length;i++){
				if(c.equals(b[i])){
					System.out.println(a[i]);
				}
				
			}
		}while(d<10);
	}
	
}
