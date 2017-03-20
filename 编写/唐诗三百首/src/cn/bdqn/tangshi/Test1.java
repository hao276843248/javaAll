package cn.bdqn.tangshi;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Writer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.sun.corba.se.impl.ior.WireObjectKeyTemplate;
import com.sun.istack.internal.FinalArrayList;

public class Test1 {
	public static void main(String[] args) {
		String regex="^\\d{3}(.*)：(.*)$";
		
		Pattern pattern=Pattern.compile(regex);
		
		BufferedReader br=null;
		
		Writer writer=null;
		try {
			InputStream is=new FileInputStream("唐诗三百首.txt");
			InputStreamReader isr=new InputStreamReader(is,"UTF-8");
			br=new BufferedReader(isr);
			
			String str=null;
			
			while((str=br.readLine())!=null){
				if(str.trim().equals("")){
					continue;	
				}
				Matcher matcher=pattern.matcher(str);
				
				if(matcher.matches()){
					String author=matcher.group(1);
					
					String title=matcher.group(2);
					
					if(writer!=null){
						writer.close();
						
					}
					writer=new FileWriter("E:\\aaaa\\"+author+"_"+title+".txt");
				}
				writer.write(str+"\r\n");
			}
			System.out.println("处理完毕");
			
		} catch (Exception e) {
			System.out.println("文件操作是发生错误"+e.getMessage());
		}finally{
			if(br!=null){
				try {
					br.close();
				} catch (Exception e2) {
					System.out.println("关闭输入流发生错误");
				}
			}
		}
	}
}
