package cn.bdqn.collect.util;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class HTMLHelper {

	public static String getHTML(String target,String encoding)throws Exception{
		//创建URL对象
		URL url=new URL(target);
		//打开连接
		URLConnection conn= url.openConnection();
		//获得输入流
		InputStream is=conn.getInputStream();
		//创建转换流
		InputStreamReader isr=new InputStreamReader(is,encoding);
		//创建缓冲流
		BufferedReader br=new BufferedReader(isr);
		
		StringBuilder sb=new StringBuilder();
		//用来以行为单位读取页面内容
		String str=null;
		
		while((str=br.readLine())!=null){
			sb.append(str);
			sb.append("\r\n");
		}
		
		//关闭流
		br.close();
		
		return sb.toString();
	}
	
}
