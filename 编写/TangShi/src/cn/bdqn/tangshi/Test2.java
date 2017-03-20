package cn.bdqn.tangshi;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test2 {
	//使用正则表达式验证电话号码
	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		System.out.println("请输入电话号码:");
		String phone=input.next();
		
		//010-85457891或0316-3085214
		String regex="^(\\d{3}-\\d{8})|(\\d{4}-\\d{7})$";
		//创建Pattern对象
		Pattern pattern=Pattern.compile(regex);
		//对用户输入的内容进行匹配，获得Matcher对象
		Matcher matcher=pattern.matcher(phone);
		//获得匹配结果
		boolean result=matcher.matches();
		
		if(result==true){
			System.out.println("电话符合格式要求");
		}
		else{
			System.out.println("电话不符合格式要求");
		}
		
		
	}

}












