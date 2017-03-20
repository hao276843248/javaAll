package cn.bdqn.ch03;

import java.io.FileOutputStream;
import java.io.PrintStream;

public class Test5 {

	//重定向标准输出
	public static void main(String[] args)throws Exception{
		PrintStream printStream=new PrintStream(new FileOutputStream("D:\\sysout.txt"));
		System.setOut(printStream);
		System.out.println("Hello,world!");
		
	}
	
}






