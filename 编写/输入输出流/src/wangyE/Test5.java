package wangyE;

import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Test5 {
	public static void main(String[] args) {
		DataInputStream din=null;
		DataOutputStream don=null;
		FileInputStream is=null;
		FileOutputStream ot=null;
		
		try {
			is=new FileInputStream("f:\\Soul.of.Dark.CHS.HD.rar");
			din=new DataInputStream(is);
			byte[] ac=new byte[1024];
			ot=new FileOutputStream("e:\\a.rar");
			don=new DataOutputStream(ot);
			int a ;
			while((a=din.read(ac))!=-1 ){
				don.write(ac,0,ac.length);
			}
		
			System.out.println("���Ƴɹ���");
		} catch (Exception e) {
			System.out.println("�����ļ�����"+e.getMessage());
		}finally{
			try {
				is.close();
				ot.close();
				din.close();
				don.close();
			} catch (IOException e) {
				System.out.println("�رմ���"+e.getMessage());
			}
			
		}
	}
}
