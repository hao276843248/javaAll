package 读取网页WEB服务;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.Scanner;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;



public class Test {
	public static String getXML(String city){
		StringBuilder sb=new StringBuilder(5000);
		try {
			city=URLEncoder.encode(city,"UTF-8");
			
			String urlStr="http://www.webxml.com.cn/WebServices/WeatherWS.asmx/getWeather?theCityCode="+city+"&theUserID=";			
			System.out.println(urlStr);
			
			URL url=new URL(urlStr);
			//打开连接
			URLConnection conn=url.openConnection();
			//获得输入流
			InputStream is=conn.getInputStream();
			InputStreamReader isr=new InputStreamReader(is);
			BufferedReader br=new BufferedReader(isr);
			
			String str=null;
			while((str=br.readLine())!=null){
				sb.append(str);
			}
			br.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return sb.toString();
	}
	public static void main(String[] args) {
		try {
			Scanner input=new Scanner(System.in);
	
			System.out.println("请输入城市名称:");
			String city=input.next();
			
			city=URLEncoder.encode(city,"UTF-8");			
			String urlStr="http://www.webxml.com.cn/WebServices/WeatherWS.asmx/getWeather?theCityCode="+city+"&theUserID=";
			
			
			DocumentBuilderFactory dbf=DocumentBuilderFactory.newInstance();
			DocumentBuilder db=dbf.newDocumentBuilder();
			Document doc=db.parse(urlStr);
			Element rootEl=doc.getDocumentElement();
			
			String wendu=rootEl.getElementsByTagName("String").item(4).getTextContent();
			String kongq=rootEl.getElementsByTagName("String").item(5).getTextContent();
			String taiy=rootEl.getElementsByTagName("String").item(6).getTextContent();
			
			System.out.println(wendu);
			System.out.println(kongq);
			System.out.println(taiy);
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
		
		
		
	}
}

