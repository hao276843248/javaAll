package wangyE;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Test {
	public static void main(String[] args) {
		FileOutputStream fos = null;
		FileInputStream fis=null;
		try {
			fis=new FileInputStream("E:\\�������.txt"); 
			fos=new FileOutputStream("d:\\�������.txt");
			
			String mess="good good study day day up!";
			byte[] words=mess.getBytes();
			fos.write(words);
			//System.out.println(len);
			
			//int num=fis.read();
			//System.out.println(num);
			int a;
			while((a=fis.read())!=-1){
				System.out.print((char)a);
			}
			
			fis.close();
		} catch (FileNotFoundException e) {
			System.out.println("������ʱ��������"+e.getMessage());
		}catch (IOException e){
			
		}finally{
			
			try {
				fos.close();
			} catch (IOException e) {
				System.out.println("�ر���ʱ�����쳣"+e.getMessage());
			}
		}
		
	}
}
