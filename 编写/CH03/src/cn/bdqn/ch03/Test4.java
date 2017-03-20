package cn.bdqn.ch03;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Test4 {

	//使用数据流读取数据
	public static void main(String[] args) {
		
		//数据输入流
		DataInputStream dis=null;
		try {
			//创建文件输入流
			InputStream is=new FileInputStream("D:\\stu1.data");
			//创建数据输入流
			dis=new DataInputStream(is);
			//读取数据时顺序要与写入数据的顺序一致
			//读取姓名
			String name=dis.readUTF();
			//读取年龄
			int age=dis.readInt();			
			//读取身高
			double height=dis.readDouble();
			
			System.out.println(name);
			System.out.println(age);
			System.out.println(height);
			
		} catch (Exception e) {
			System.out.println("读取数据时发生错误:"+e.getMessage());
		}
		finally{
			if(dis!=null){
				try {
					dis.close();
				} catch (IOException e) {
					System.out.println("关闭输入流时发生错误");
				}				
			}
		}
		
	}
	
}
