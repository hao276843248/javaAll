package ke01;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class TestCPT {
	public static void main(String[] args) {
		CPT pc=new CPT("因特尔",8,"SSD");
		
		ObjectOutputStream oos=null;
		try{
			OutputStream os=new FileOutputStream("E:\\CPT.TXT");
			oos=new ObjectOutputStream(os);
			oos.writeObject(pc);
			System.out.println("序列化成功！");
		}catch (Exception e) {
			System.out.println("输出对象数据时发生错误:"+e.getMessage());
		}
		finally{
			if(oos!=null){
				try {
					oos.close();
				} catch (IOException e) {
					System.out.println("关闭输出流时发生错误");
				}
			}
		}
	}
}
