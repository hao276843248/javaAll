package cn.bdqn.tangshi;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class test {
	public static void main(String[] args) {
		 Pattern p = Pattern.compile("^d+$");  //��ҪҪ�жϵ��ַ���; 
		 Matcher m = p.matcher("1asd234532323"); 
		 if(m.matches()) {  
			 System.out.println("��ȷ,����������ɵ�"); 
			 }else {  
				 System.out.println("����,������������ɵ�"); 
			}
	
	}
}
