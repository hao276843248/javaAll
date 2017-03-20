package asd;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

public class asd {
	public static void main(String[] args) {
		ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
		//实际开发中JavaMailSender通过setter方法注入
		JavaMailSender sender=(JavaMailSender)ctx.getBean("mailSender");
	
		//创建简单邮件对象
		SimpleMailMessage msg = new SimpleMailMessage();  
		//设置发件人地址，应当与mailSender设置的账户一致
		msg.setFrom("276843248@qq.com"); 
		//设置收件人地址 
		msg.setTo("276843248@qq.com");  
		//设置邮件标题
		msg.setSubject("这是一封带附件的测试邮件");  
		//设置邮件内容
		msg.setText("这是一封带附件的测试邮件");  
	
		//发送邮件
		sender.send(msg);
	}
	
}
