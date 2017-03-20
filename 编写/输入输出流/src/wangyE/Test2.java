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
			fr=new FileInputStream("F:\\我的青春我做主.txt");
			is=new InputStreamReader(fr,"Gbk");
			br=new BufferedReader(is);
			StringBuffer sbf=new StringBuffer();
			String line=null;
			
			while((line=br.readLine())!=null){
				sbf.append(line);
			}
			System.out.println("替换前:"+sbf);
			String a=System.getProperty("file.encoding");
			System.out.println(a);
		} catch (Exception e) {
			System.out.println("操作文件发生错误"+e.getMessage());
		}finally{
			try {
				fr.close();
				br.close();
			} catch (IOException e) {
				System.out.println("关闭流发生错误"+e.getMessage());
			}
		}
	}
}
