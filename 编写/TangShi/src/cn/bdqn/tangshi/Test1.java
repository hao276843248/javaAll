package cn.bdqn.tangshi;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test1 {

	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		System.out.println("请输入一个字符串：");
		String str=input.next();
		
		//编写正则表达式
		//判断字符串内容中包含hello
		//String regex=".{3}hello.{2}";
		//判断字符串内容是否以hello开始
		//String regex="^hello.*";
		//判断字符串内容是否以hello结束
		String regex=".*hello$";
		
		//创建正则表达式对象
		Pattern pattern=Pattern.compile(regex);
		//对用户输入的内容进行匹配，获得匹配器对象
		//Matcher代表匹配的结果
		Matcher matcher=pattern.matcher(str);
		//获得匹配结果
		boolean result=matcher.matches();
		System.out.println(result);
		
		
	}
}




