package cn.bdqn.tangshi;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test3 {
	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		System.out.println("请输入Email:");
		String email=input.next();
		
		String regex="\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*";
		Pattern pattern=Pattern.compile(regex);
		Matcher matcher=pattern.matcher(email);
		
		boolean result=matcher.matches();
		
		if(result==true){
			System.out.println("Email格式有效");
		}
		else{
			System.out.println("Email格式无效");
		}
		
		
	}
}











