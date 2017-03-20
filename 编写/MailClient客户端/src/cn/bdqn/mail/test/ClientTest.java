package cn.bdqn.mail.test;

import java.io.File;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.bdqn.mail.ws.IMailWebService;
import cn.bdqn.mail.ws.MailParam;

public class ClientTest {
	
	public static void main(String[] args) {
		ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
		
		IMailWebService service=(IMailWebService)ctx.getBean("mailService");
		
		
		MailParam mailParam=new MailParam();
		mailParam.setUserName("admin");
		mailParam.setPassword("123456");
		
		mailParam.setSender("276843248@qq.com");
		mailParam.setReceiver("276843248@qq.com");
		mailParam.setSubject("测试邮件");
		mailParam.setText("测试邮件内容");
		
		FileDataSource fds=new FileDataSource(new File("D:\\report_data2.txt"));
		DataHandler dh=new DataHandler(fds);
		mailParam.setFileData(dh);
		
		mailParam.setFileName("CSS 2.0 中文手册.chm");
		
		int r=service.sendMail(mailParam);

		System.out.println(r);
	}

}
