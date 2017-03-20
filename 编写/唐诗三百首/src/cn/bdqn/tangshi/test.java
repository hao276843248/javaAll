package cn.bdqn.tangshi;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class test {
	public static void main(String[] args) {
		 Pattern p = Pattern.compile("^d+$");  //需要要判断的字符串; 
		 Matcher m = p.matcher("1asd234532323"); 
		 if(m.matches()) {  
			 System.out.println("正确,是由数字组成的"); 
			 }else {  
				 System.out.println("错误,不是由数字组成的"); 
			}
	
	}
}
