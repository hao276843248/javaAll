package cn.bdqn.ch03;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class Test3 {

	//��ʾʹ��������д����
	public static void main(String[] args) {
		//���������
		DataOutputStream dos=null;
		try {
			//�����ļ������
			OutputStream os=new FileOutputStream("D:\\stu1.data");
			//����������������ڲ���װ�ļ������
			dos=new DataOutputStream(os);
			//�������ļ�����ַ�������
			dos.writeUTF("����");
			dos.writeInt(22);
			dos.writeDouble(1.75);
			
			System.out.println("������");
			
		} catch (Exception e) {
			System.out.println("�������ʱ������:"+e.getMessage());
		}
		finally{
			if(dos!=null){
				try {
					dos.close();
				} catch (IOException e) {
					System.out.println("�ر������ʱ��������");
				}
			}
		}
		
	}
	
}
