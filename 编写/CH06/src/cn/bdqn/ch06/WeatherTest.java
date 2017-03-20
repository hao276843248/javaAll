package cn.bdqn.ch06;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.Scanner;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class WeatherTest {

	public static String getXML(String city){
		StringBuilder sb=new StringBuilder(5000);
		try {
			//�Գ����������±���
			city=URLEncoder.encode(city,"UTF-8");
			
			String urlStr="http://www.webxml.com.cn/WebServices/WeatherWS.asmx/getWeather?theCityCode="+city+"&theUserID=";			
			System.out.println(urlStr);
			
			URL url=new URL(urlStr);
			//������
			URLConnection conn=url.openConnection();
			//���������
			InputStream is=conn.getInputStream();
			InputStreamReader isr=new InputStreamReader(is,"UTF-8");
			BufferedReader br=new BufferedReader(isr);
			
			String str=null;
			while((str=br.readLine())!=null){
				sb.append(str);
			}
			
			br.close();
		} catch (Exception e) {			
			e.printStackTrace();
		}		
		return sb.toString();
	}
	
	public static void main(String[] args) {
		try {
			//String xml=getXML("����");
			Scanner input=new Scanner(System.in);
			System.out.println("�������������:");
			String city=input.next();
			
			city=URLEncoder.encode(city,"UTF-8");			
			String urlStr="http://www.webxml.com.cn/WebServices/WeatherWS.asmx/getWeather?theCityCode="+city+"&theUserID=";
			
			DocumentBuilderFactory dbf=DocumentBuilderFactory.newInstance();
			DocumentBuilder db=dbf.newDocumentBuilder();
			Document doc=db.parse(urlStr);
			Element rootEl=doc.getDocumentElement();
			
			String shiKuang=rootEl.getElementsByTagName("string").item(4).getTextContent();
			String zhiLiang=rootEl.getElementsByTagName("string").item(5).getTextContent();
			String chengshi=rootEl.getElementsByTagName("string").item(0).getTextContent()+" "+rootEl.getElementsByTagName("string").item(1).getTextContent();
			
			System.out.println(chengshi);
			System.out.println(shiKuang);
			System.out.println(zhiLiang);
			
		} catch (Exception e) {
			System.out.println("��ȡ����Ԥ����Ϣʱ��������");
		}
		
		
	}
	
}











