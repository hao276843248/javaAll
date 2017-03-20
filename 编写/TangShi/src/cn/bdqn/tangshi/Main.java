package cn.bdqn.tangshi;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.Writer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
	
	public static void main(String[] args) {
		//定义匹配标题行的正则表达式
		String regex="^\\d{3}(.*)：(.*)$";
		//创建Pattern对象
		Pattern pattern=Pattern.compile(regex);
		
		//缓冲字符输入流
		BufferedReader br=null;
		//字符输出流
		Writer writer=null;
		try {
			InputStream is=new FileInputStream("唐诗三百首.txt");
			InputStreamReader isr=new InputStreamReader(is,"UTF-8");
			br=new BufferedReader(isr);
			
			String str=null;
			
			while((str=br.readLine())!=null){
				//如果读取到空白行，则跳过后面的操作
				if(str.trim().equals("")){
					continue;
				}				
				//判断当前读取的是不是标题行
				Matcher matcher=pattern.matcher(str);
				//如果读取的是标题行
				if(matcher.matches()){
					//获得作者
					String author=matcher.group(1);
					//获得标题
					String title=matcher.group(2);
					//如果之前已经打开流，则关闭流
					if(writer!=null){
						writer.close();
					}					
					//重新创建输出流
					writer=new FileWriter("D:\\test\\"+author+"_"+title+".txt");					
				}
				
				writer.write(str+"\r\n");
				
			}
			System.out.println("处理完毕");
			
			
			
		} catch (Exception e) {
			System.out.println("操作文件时发生错误:"+e.getMessage());
		}
		finally{
			if(br!=null){
				try {
					br.close();
				} catch (IOException e) {
					System.out.println("关闭输入流时发生错误");
				}
			}
			if(writer!=null){
				try{
					writer.close();
				} catch (IOException e) {
					System.out.println("关闭输出流时发生错误");
				}
			}
		}
	}

}
