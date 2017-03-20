package cn.bdqn.tangshi;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.Writer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
	
	public static void main(String[] args) {
		//����ƥ������е�������ʽ
		String regex="^\\d{3}(.*)��(.*)$";
		//����Pattern����
		Pattern pattern=Pattern.compile(regex);
		
		//�����ַ�������
		BufferedReader br=null;
		//�ַ������
		Writer writer=null;
		try {
			InputStream is=new FileInputStream("��ʫ������.txt");
			InputStreamReader isr=new InputStreamReader(is,"UTF-8");
			br=new BufferedReader(isr);
			
			String str=null;
			
			while((str=br.readLine())!=null){
				//�����ȡ���հ��У�����������Ĳ���
				if(str.trim().equals("")){
					continue;
				}				
				//�жϵ�ǰ��ȡ���ǲ��Ǳ�����
				Matcher matcher=pattern.matcher(str);
				//�����ȡ���Ǳ�����
				if(matcher.matches()){
					//�������
					String author=matcher.group(1);
					//��ñ���
					String title=matcher.group(2);
					//���֮ǰ�Ѿ���������ر���
					if(writer!=null){
						writer.close();
					}					
					//���´��������
					writer=new FileWriter("D:\\test\\"+author+"_"+title+".txt");					
				}
				
				writer.write(str+"\r\n");
				
			}
			System.out.println("�������");
			
			
			
		} catch (Exception e) {
			System.out.println("�����ļ�ʱ��������:"+e.getMessage());
		}
		finally{
			if(br!=null){
				try {
					br.close();
				} catch (IOException e) {
					System.out.println("�ر�������ʱ��������");
				}
			}
			if(writer!=null){
				try{
					writer.close();
				} catch (IOException e) {
					System.out.println("�ر������ʱ��������");
				}
			}
		}
	}

}
