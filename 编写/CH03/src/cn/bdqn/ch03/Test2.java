package cn.bdqn.ch03;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Test2 {
	//ʹ���ֽ����ӻ����������ļ�
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

			//�����ֽ����黺����
			byte[] buffer=new byte[1024];
			//ʵ�ʶ�ȡ���ֽ���
			int i=0;
			//ʹ��whileѭ�����϶�ȡ�ֽ����ݣ���䵽������������
			//����Ѿ������ļ�ĩβ���򷵻�-1
			while((i=is.read(buffer))!=-1){
				//ͨ�����������������е��ֽ�����
				os.write(buffer,0,i);
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









