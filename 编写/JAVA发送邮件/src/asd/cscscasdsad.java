package asd;

import java.io.File;
import java.util.Date;

import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeUtility;



import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

public class cscscasdsad {
	public static void main(String[] args) throws Exception{
		ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
		//实际开发中JavaMailSender通过setter方法注入
		JavaMailSender sender=(JavaMailSender)ctx.getBean("mailSender");

		//创建Mime邮件对象
		MimeMessage msg = sender.createMimeMessage();
		//MimeMessageHelper用来设置mime邮件的各个组成部分
		MimeMessageHelper helper = new MimeMessageHelper(msg, true);  
		//设置发件人
		helper.setFrom("276843248@qq.com");  
		//设置收件人
		helper.setTo("276843248@qq.com");  
		//设置邮件的标题
		helper.setSubject("这是一封带附件的测试邮件");  
		//设置邮件的文本内容
		helper.setText("这是一封带附件的测试邮件");  
		//设置邮件的发送日期
		helper.setSentDate(new Date());
		//添加邮件附件	
		FileSystemResource file = new FileSystemResource(new File("D:\\temp\\jquery-1.11.1.js"));  
		String fileName="jquery-1.11.1.js";			
		//解决中文乱码问题
		fileName=MimeUtility.encodeText(fileName);
		helper.addAttachment(fileName,file); 

		//发送邮件
		sender.send(msg);  




		
	}
}
