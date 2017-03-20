package cn.bdqn.tangshi;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test4 {
	public static void main(String[] args) {
		
		Scanner input=new Scanner(System.in);
		System.out.println("请输入电话号码:");
		String phone=input.next();
		
		String regex="^((\\d{3})-(\\d{8}))|((\\d{4})-(\\d{7}))$";
		//创建Pattern对象
		Pattern pattern=Pattern.compile(regex);
		//对用户输入的内容进行匹配，获得Matcher对象
		Matcher matcher=pattern.matcher(phone);
		
		boolean result=matcher.matches();
		
		if(result==true){
			//System.out.println(matcher.group(0));
			String quHao=matcher.group(2);
			String zuoJi=matcher.group(3);
			if(quHao==null){
				quHao=matcher.group(5);
				zuoJi=matcher.group(6);
			}
			
			System.out.println("区号是:"+quHao);
			System.out.println("座机是:"+zuoJi);
		}
		
		
	}
}







