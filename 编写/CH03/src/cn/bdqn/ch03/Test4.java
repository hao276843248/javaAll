package cn.bdqn.ch03;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Test4 {

	//ʹ����������ȡ����
	public static void main(String[] args) {
		
		//����������
		DataInputStream dis=null;
		try {
			//�����ļ�������
			InputStream is=new FileInputStream("D:\\stu1.data");
			//��������������
			dis=new DataInputStream(is);
			//��ȡ����ʱ˳��Ҫ��д�����ݵ�˳��һ��
			//��ȡ����
			String name=dis.readUTF();
			//��ȡ����
			int age=dis.readInt();			
			//��ȡ���
			double height=dis.readDouble();
			
			System.out.println(name);
			System.out.println(age);
			System.out.println(height);
			
		} catch (Exception e) {
			System.out.println("��ȡ����ʱ��������:"+e.getMessage());
		}
		finally{
			if(dis!=null){
				try {
					dis.close();
				} catch (IOException e) {
					System.out.println("�ر�������ʱ��������");
				}				
			}
		}
		
	}
	
}
