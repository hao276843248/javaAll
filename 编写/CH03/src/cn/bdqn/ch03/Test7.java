package cn.bdqn.ch03;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;

public class Test7 {

	//使用对象输入流反序列化对象数据
	public static void main(String[] args) {
		
		ObjectInputStream ois=null;
		try {
			//创建字节文件输入流
			InputStream is=new FileInputStream("D:\\student.ser");
			//创建对象输入流
			ois=new ObjectInputStream(is);
			//反序列化对象
			Student stu=(Student)ois.readObject();
			
			System.out.println(stu.getId());
			System.out.println(stu.getName());
			System.out.println(stu.getAge());
			System.out.println(stu.getWeight());
			
			
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
