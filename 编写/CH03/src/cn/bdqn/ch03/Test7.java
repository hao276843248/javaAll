package cn.bdqn.ch03;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;

public class Test7 {

	//ʹ�ö��������������л���������
	public static void main(String[] args) {
		
		ObjectInputStream ois=null;
		try {
			//�����ֽ��ļ�������
			InputStream is=new FileInputStream("D:\\student.ser");
			//��������������
			ois=new ObjectInputStream(is);
			//�����л�����
			Student stu=(Student)ois.readObject();
			
			System.out.println(stu.getId());
			System.out.println(stu.getName());
			System.out.println(stu.getAge());
			System.out.println(stu.getWeight());
			
			
		} catch (Exception e) {
			System.out.println("��ȡ��������ʱ��������:"+e.getMessage());
		}
		finally{
			if(ois!=null){
				try {
					ois.close();
				} catch (IOException e) {
					System.out.println("�ر�������ʱ��������");
				}
			}
		}
		
	}
	
}
