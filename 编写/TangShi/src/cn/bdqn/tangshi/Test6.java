package cn.bdqn.tangshi;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Test6 {
	public static void main(String[] args) {
		try {
			Properties props=new Properties();
			//获得Test6的类型信息
			Class c=Test6.class;
			//获得类路径下的文件的输入流
			InputStream is=c.getResourceAsStream("/test.properties");
			//加载属性文件中的键值对
			props.load(is);
			System.out.println(props.getProperty("id"));
			System.out.println(props.getProperty("name"));
			System.out.println(props.getProperty("address"));
			System.out.println(props.getProperty("age"));
			
		} catch (IOException e) {
			System.out.println("加载数据时发生异常:"+e.getMessage());
		}
		
	}
}






