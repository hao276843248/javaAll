package ke01;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class TestCPTqu {
	public static void main(String[] args) {
		ObjectInputStream ois=null;
		try{
			InputStream is=new FileInputStream("E:\\CPT.txt");
			
			ois=new ObjectInputStream(is);
			
			CPT a=(CPT)ois.readObject();
			System.out.println(a.getCpu());
			System.out.println(a.getNc());
			System.out.println(a.getYp());
			
			
			
		} catch (Exception e) {
			System.out.println("读取对象数据时发生错误:"+e.getMessage());
		}
		finally{
			if(ois!=null){
				try {
					ois.close();
				} catch (IOException e) {
					System.out.println("关闭输入流时发生错误");
				}
			}
		}
	}
}
