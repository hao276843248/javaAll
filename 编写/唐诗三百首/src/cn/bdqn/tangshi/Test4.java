package cn.bdqn.tangshi;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Test4 {
	public static void main(String[] args) {
		try {
			Properties props=new Properties();
			Class c=Test4.class;
			
			InputStream is=c.getResourceAsStream("/test.properties");
			
			
			props.load(is);
			System.out.println(props.getProperty("ID"));
			System.out.println(props.getProperty("name"));
			System.out.println(props.getProperty("age"));
			System.out.println(props.getProperty("address"));
		} catch (IOException e) {
			System.out.println("´íÎó");
			e.printStackTrace();
		}
		
		
		
	}
}
