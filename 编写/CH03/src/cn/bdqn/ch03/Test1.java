package cn.bdqn.ch03;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Test1 {
	//ʹ���ֽ��������ļ�
	public static void main(String[] args) {
		//����������Դ�ļ��ж�ȡ�ֽ����ݵ�������
		InputStream is=null;
		//����������Ŀ���ļ�����ֽ����ݵ������
		OutputStream os=null;
		
		try {
			//�����ļ��ֽ�����������
			is=new FileInputStream("D:\\Adobe Reader_9.3.0.148.exe");
			//�����ļ��ֽ����������
			os=new FileOutputStream("C:\\Adobe Reader_9.3.0.148.exe");

			int value=0;
			//ʹ��whileѭ��ÿ�δ�Ŀ���ļ��ж�ȡ1�ֽ�����
			//����Ѿ���ȡ���ļ���ĩβ���򷵻�-1
			while((value=is.read())!=-1){
				//ͨ�������������д����Ŀ���ļ�
				os.write(value);
			}
			
			System.out.println("�������");
			
		} catch (Exception e) {
			System.out.println("�����ļ�ʱ��������:"+e.getMessage());
		}
		finally{
			if(is!=null){
				try {
					is.close();
				} catch (IOException e) {
					System.out.println("�ر�������ʱ��������");
				}
			}
			if(os!=null){
				try {
					os.close();
				} catch (IOException e) {
					System.out.println("�ر������ʱ��������");
				}
			}
			
			
		}
		
	}
	
}









