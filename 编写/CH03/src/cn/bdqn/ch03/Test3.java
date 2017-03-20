package cn.bdqn.ch03;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class Test3 {

	//演示使用数据流写数据
	public static void main(String[] args) {
		//数据输出流
		DataOutputStream dos=null;
		try {
			//创建文件输出流
			OutputStream os=new FileOutputStream("D:\\stu1.data");
			//创建数据输出流，内部包装文件输出流
			dos=new DataOutputStream(os);
			//向数据文件输出字符串内容
			dos.writeUTF("张三");
			dos.writeInt(22);
			dos.writeDouble(1.75);
			
			System.out.println("输出完毕");
			
		} catch (Exception e) {
			System.out.println("输出数据时发生错:"+e.getMessage());
		}
		finally{
			if(dos!=null){
				try {
					dos.close();
				} catch (IOException e) {
					System.out.println("关闭输出流时发生错误");
				}
			}
		}
		
	}
	
}
