package CH0345C;

import java.util.Scanner;

public class Verify {
	public static void main(String[] args) {
		boolean fileCorrect=false;
		boolean emailCorrect=false;
		System.out.println("--��ӭ������ҵ�ύϵͳ--");
		Scanner input=new Scanner(System.in);
		System.out.println("������Java�ļ�����");
		String fileName=input.next();
		System.out.println("�������������");
		String email=input.next();
		int index=fileName.lastIndexOf(".");
		if(index!=-1 && index!=0 && fileName.substring(index+1, fileName.length()).equals("java")){
			fileCorrect=true;
		}else{
			System.out.println("�ļ�����Ч��");
		}
		
		
		if(email.indexOf('@')!=-1 && email.indexOf('.')>email.indexOf('@')){
			emailCorrect=true;
		}else{
			System.out.println("E-mail��Ч��");
		}
		
		if(fileCorrect&&emailCorrect){
			System.out.println("�ύ��ҵ�ɹ�");
		}else{
			System.out.println("�ύ��ҵʧ��");
		}
		
	}
}
