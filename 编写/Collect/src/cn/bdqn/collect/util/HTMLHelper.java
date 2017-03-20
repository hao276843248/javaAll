package cn.bdqn.collect.util;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class HTMLHelper {

	public static String getHTML(String target,String encoding)throws Exception{
		//����URL����
		URL url=new URL(target);
		//������
		URLConnection conn= url.openConnection();
		//���������
		InputStream is=conn.getInputStream();
		//����ת����
		InputStreamReader isr=new InputStreamReader(is,encoding);
		//����������
		BufferedReader br=new BufferedReader(isr);
		
		StringBuilder sb=new StringBuilder();
		//��������Ϊ��λ��ȡҳ������
		String str=null;
		
		while((str=br.readLine())!=null){
			sb.append(str);
			sb.append("\r\n");
		}
		
		//�ر���
		br.close();
		
		return sb.toString();
	}
	
}
