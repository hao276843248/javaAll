package wangyE;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;



public class Test2 {
	public static void main(String[] args) {
		 
		BufferedReader br=null;
		InputStreamReader is;
		FileInputStream fr=null;
		try {
			fr=new FileInputStream("F:\\�ҵ��ഺ������.txt");
			is=new InputStreamReader(fr,"Gbk");
			br=new BufferedReader(is);
			StringBuffer sbf=new StringBuffer();
			String line=null;
			
			while((line=br.readLine())!=null){
				sbf.append(line);
			}
			System.out.println("�滻ǰ:"+sbf);
			String a=System.getProperty("file.encoding");
			System.out.println(a);
		} catch (Exception e) {
			System.out.println("�����ļ���������"+e.getMessage());
		}finally{
			try {
				fr.close();
				br.close();
			} catch (IOException e) {
				System.out.println("�ر�����������"+e.getMessage());
			}
		}
	}
}
