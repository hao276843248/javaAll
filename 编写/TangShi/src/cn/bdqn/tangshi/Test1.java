package cn.bdqn.tangshi;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test1 {

	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		System.out.println("������һ���ַ�����");
		String str=input.next();
		
		//��д������ʽ
		//�ж��ַ��������а���hello
		//String regex=".{3}hello.{2}";
		//�ж��ַ��������Ƿ���hello��ʼ
		//String regex="^hello.*";
		//�ж��ַ��������Ƿ���hello����
		String regex=".*hello$";
		
		//����������ʽ����
		Pattern pattern=Pattern.compile(regex);
		//���û���������ݽ���ƥ�䣬���ƥ��������
		//Matcher����ƥ��Ľ��
		Matcher matcher=pattern.matcher(str);
		//���ƥ����
		boolean result=matcher.matches();
		System.out.println(result);
		
		
	}
}




