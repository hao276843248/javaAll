package asd;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

public class asd {
	public static void main(String[] args) {
		ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
		//ʵ�ʿ�����JavaMailSenderͨ��setter����ע��
		JavaMailSender sender=(JavaMailSender)ctx.getBean("mailSender");
	
		//�������ʼ�����
		SimpleMailMessage msg = new SimpleMailMessage();  
		//���÷����˵�ַ��Ӧ����mailSender���õ��˻�һ��
		msg.setFrom("276843248@qq.com"); 
		//�����ռ��˵�ַ 
		msg.setTo("276843248@qq.com");  
		//�����ʼ�����
		msg.setSubject("����һ��������Ĳ����ʼ�");  
		//�����ʼ�����
		msg.setText("����һ��������Ĳ����ʼ�");  
	
		//�����ʼ�
		sender.send(msg);
	}
	
}
