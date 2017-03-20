package cn.bdqn.ch03;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Test2 {
	//使用字节流加缓冲区复制文件
	public static void main(String[] args) {
		//创建用来从源文件中读取字节数据的输入流
		InputStream is=null;
		//创建用来向目标文件输出字节数据的输出流
		OutputStream os=null;
		
		try {
			//创建文件字节输入流对象
			is=new FileInputStream("D:\\Adobe Reader_9.3.0.148.exe");
			//创建文件字节输出流对象
			os=new FileOutputStream("C:\\Adobe Reader_9.3.0.148.exe");

			//创建字节数组缓冲区
			byte[] buffer=new byte[1024];
			//实际读取的字节数
			int i=0;
			//使用while循环不断读取字节数据，填充到缓冲区数组中
			//如果已经读到文件末尾，则返回-1
			while((i=is.read(buffer))!=-1){
				//通过输出流输出缓冲区中的字节数据
				os.write(buffer,0,i);
			}			
			
			System.out.println("复制完毕");
			
		} catch (Exception e) {
			System.out.println("复制文件时发生错误:"+e.getMessage());
		}
		finally{
			if(is!=null){
				try {
					is.close();
				} catch (IOException e) {
					System.out.println("关闭输入流时发生错误");
				}
			}
			if(os!=null){
				try {
					os.close();
				} catch (IOException e) {
					System.out.println("关闭输出流时发生错误");
				}
			}
			
			
		}
		
	}
	
}









