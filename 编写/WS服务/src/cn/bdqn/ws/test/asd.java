package cn.bdqn.ws.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.bdqn.ws.ip.ArrayOfString;
import cn.bdqn.ws.ip.IpAddressSearchWebServiceSoap;

public class asd {

	public static void main(String[] args) {
		ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
		IpAddressSearchWebServiceSoap ipService=(IpAddressSearchWebServiceSoap)ctx.getBean("ipService");
		
		ArrayOfString result=ipService.getCountryCityByIp("202.106.42.122");
		
		List<String> strs=result.getString();
		
		for(String str:strs){
			System.out.println(str);
		}
	}
}
