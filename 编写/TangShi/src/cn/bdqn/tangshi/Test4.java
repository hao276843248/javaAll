package cn.bdqn.tangshi;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test4 {
	public static void main(String[] args) {
		
		Scanner input=new Scanner(System.in);
		System.out.println("������绰����:");
		String phone=input.next();
		
		String regex="^((\\d{3})-(\\d{8}))|((\\d{4})-(\\d{7}))$";
		//����Pattern����
		Pattern pattern=Pattern.compile(regex);
		//���û���������ݽ���ƥ�䣬���Matcher����
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
			
			System.out.println("������:"+quHao);
			System.out.println("������:"+zuoJi);
		}
		
		
	}
}







