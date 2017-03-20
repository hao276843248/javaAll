package wangyE;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.Buffer;

public class Test4 {
	public static void main(String[] args) {
		FileReader fr=null;
		FileWriter fw=null;
		BufferedReader br = null;
		BufferedWriter bw = null;
		
		try {
			fr=new FileReader("f:\\我的青春我做主.txt");
			br=new BufferedReader(fr);
			
			fw=new FileWriter("G:\\as.txt");
			bw=new BufferedWriter(fw);
			
			String a =null;
			StringBuffer sb=new StringBuffer();
			while ((a=br.readLine())!=null) {
				sb.append(a);
			}
			System.out.println(sb);
			
			a=sb.toString();
			a=a.replace("{三}", "四asd asd");
			System.out.println(a);
			bw.write(a);
			bw.flush();
		} catch (Exception e) {
			System.out.println("操作文件时发生错误"+e.getMessage());
		}finally{
			try {
				br.close();
				fr.close();
				bw.close();
				fw.close();
			} catch (IOException e) {
				System.out.println("关闭流是发生错误"+e.getMessage());
			}
		}
	}
}
