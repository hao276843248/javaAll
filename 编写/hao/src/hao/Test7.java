package hao;

import java.util.Scanner;

public class Test7 {
	public static void main(String[] args) {
		Scanner input=new Scanner (System.in);
		int a;
		int e=-1;
		String d;
		String[][] b={{"9787111213826","Java���˼��"},{"9787302209768","Java Web���Ͽ������߹���"},{"9787121213137","Java����Ա���Ա���"},{"9787512361881","Java������"},{"9787302388982","Java ѧϰ�ʼ�"},{"9787121093739","��ͨHibernate"},{"9787115321954","Java����Ա����֮��"},{"9787115356307","Javaѧϰָ��"},{"9787115351869","Java���ģʽ�����о�"},{"9787121202506","Java������"}};
		double[] c={71.50,74.60,36.50,57.50,57.10,63.80,75.70,107.20,40.20,66.60};
		do{
			System.out.println("*******************��ӭʹ��ͼ����Ϣ��ѯϵͳ*******************");
			System.out.println("1.��ISBN��ѯ");
			System.out.println("2.���۸��ѯ");
			System.out.println("3.�˳�ϵͳ");
			System.out.println("------------------------------------------------------");
			System.out.println("��ѡ��:");
			a=input.nextInt();
			if(a==1){
				System.out.println("������ISBN��:");
				d=input.next();
				for(int i=0;i<10;i++){
					if(d.equals(b[i][0])){
						e=i;
					}
				}
				System.out.println("��ѯ�������:");
				System.out.println("------------------------------------------------------");
				System.out.println("ISBN               ����                                             ��Ǯ");
				if(e!=-1){
					System.out.println(b[e][0]+"     "+b[e][1]+"     "+c[e]);
				}else{
					System.out.println("�Բ���û���ҵ���ؼ�¼��");
				}
				System.out.println("");
				
			}else if(a==2){
				System.out.println("��������ͼ�");
				double i=input.nextDouble();
				System.out.println("��������߼�");
				double j=input.nextDouble();
				System.out.println("��ѯ�������:");
				System.out.println("------------------------------------------------------");
				System.out.println("ISBN               ����                                             ��Ǯ");
				for(int k=0;k<10;k++){
					if(i<c[k]&&c[k]<j){
						System.out.println(b[k][0]+"     "+b[k][1]+"       "+c[k]);
						e=k;
					}
				}
				if(e==-1){
					System.out.println("�Բ���û���ҵ���ؼ�¼��");
				}
				System.out.println("");
			}
		}while(a!=3);
		
	}
	
}
