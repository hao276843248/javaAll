package cn.bdqn.tangshi;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test2 {
	//ʹ��������ʽ��֤�绰����
	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		System.out.println("������绰����:");
		String phone=input.next();
		
		//010-85457891��0316-3085214
		String regex="^(\\d{3}-\\d{8})|(\\d{4}-\\d{7})$";
		//����Pattern����
		Pattern pattern=Pattern.compile(regex);
		//���û���������ݽ���ƥ�䣬���Matcher����
		Matcher matcher=pattern.matcher(phone);
		//���ƥ����
		boolean result=matcher.matches();
		
		if(result==true){
			System.out.println("�绰���ϸ�ʽҪ��");
		}
		else{
			System.out.println("�绰�����ϸ�ʽҪ��");
		}
		
		
	}

}












