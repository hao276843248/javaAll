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
		//ʵ�ʿ�����JavaMailSenderͨ��setter����ע��
		JavaMailSender sender=(JavaMailSender)ctx.getBean("mailSender");

		//����Mime�ʼ�����
		MimeMessage msg = sender.createMimeMessage();
		//MimeMessageHelper��������mime�ʼ��ĸ�����ɲ���
		MimeMessageHelper helper = new MimeMessageHelper(msg, true);  
		//���÷�����
		helper.setFrom("276843248@qq.com");  
		//�����ռ���
		helper.setTo("276843248@qq.com");  
		//�����ʼ��ı���
		helper.setSubject("����һ��������Ĳ����ʼ�");  
		//�����ʼ����ı�����
		helper.setText("����һ��������Ĳ����ʼ�");  
		//�����ʼ��ķ�������
		helper.setSentDate(new Date());
		//����ʼ�����	
		FileSystemResource file = new FileSystemResource(new File("D:\\temp\\jquery-1.11.1.js"));  
		String fileName="jquery-1.11.1.js";			
		//���������������
		fileName=MimeUtility.encodeText(fileName);
		helper.addAttachment(fileName,file); 

		//�����ʼ�
		sender.send(msg);  




		
	}
}
