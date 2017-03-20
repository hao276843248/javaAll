package cn.bdqn.ch03;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class Test6 {

	//通过对象输出流序列化对象数据
	public static void main(String[] args) {
		
		Student stu=new Student(1,"张三",23,85.5);
		
		//对象输出流
		ObjectOutputStream oos=null;
		try {
			//创建文件字节输出流
			OutputStream os=new FileOutputStream("D:\\student.ser");
			//创建对象输出流
			oos=new ObjectOutputStream(os);
			
			//序列化对象
			oos.writeObject(stu);
			
			System.out.println("序列化成功！");
			
			
			
		} catch (Exception e) {
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
