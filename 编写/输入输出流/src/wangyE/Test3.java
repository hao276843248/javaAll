package wangyE;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Test3 {
	public static void main(String[] args) {
		File f=new File("f:\\�ҵ��ഺ������.txt");
		FileInputStream fis=null;
		FileOutputStream fos=null;
		if(!f.exists()){
			try {
				f.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		try {
			fis=new FileInputStream("f:\\�ҵ��ഺ������.txt");
			fos=new FileOutputStream("f:\\�ҵ��ഺ������.txt");
			String a="�ҵ��ഺ��������������������������";
			byte[] c=a.getBytes();
			fos.write(c, 0, c.length);
			
			while(fis.read()!=-1){
				System.out.print(fis.read());
			}
			fis.close();
			fos.close();
			} catch (Exception e) {
			System.out.println("");
		}
	}
}
