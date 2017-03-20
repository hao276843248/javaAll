package cn.bdqn.tangshi;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Writer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test2 {
	public static void main(String[] args) {
		String a="^//d{3}(.*)��(.*)$";
		InputStream is=null;
		BufferedReader br=null;
		Writer write=null;
		Pattern pattern=Pattern.compile(a);
		
		try {
			is=new FileInputStream("��ʫ������.txt");
			InputStreamReader isr=new InputStreamReader(is);
			br=new BufferedReader(isr);
			String str=null;
			while ((str=br.readLine())!=null) {
				if(str.trim()==""){
					continue;
				}
				Matcher m=pattern.matcher(str);
				if(m.matches()){
					String name=m.group(1);
					String timo=m.group(0);
					if(write!=null){
						write.close();
					}
					write=new FileWriter("D:\\test\\"+name+"_"+timo+".txt");
				}
				write.write(str+"\r\n");
			}
			System.out.println("�������");
		} catch (Exception e) {
			System.out.println("�����ļ�����"+e.getMessage());
		}finally{
			if(br!=null){
				try {
					br.close();
				} catch (IOException e) {
					System.out.println("�ر�����������"+e.getMessage());
				}
				
			}
		}
		
	}
}
