package cn.bdqn.ch03;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class Test6 {

	//ͨ��������������л���������
	public static void main(String[] args) {
		
		Student stu=new Student(1,"����",23,85.5);
		
		//���������
		ObjectOutputStream oos=null;
		try {
			//�����ļ��ֽ������
			OutputStream os=new FileOutputStream("D:\\student.ser");
			//�������������
			oos=new ObjectOutputStream(os);
			
			//���л�����
			oos.writeObject(stu);
			
			System.out.println("���л��ɹ���");
			
			
			
		} catch (Exception e) {
			System.out.println("�����������ʱ��������:"+e.getMessage());
		}
		finally{
			if(oos!=null){
				try {
					oos.close();
				} catch (IOException e) {
					System.out.println("�ر������ʱ��������");
				}
			}
		}
		
		
	}
	
}
