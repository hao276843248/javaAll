package cn.bdqn.mail.job;

import java.io.File;
import java.util.List;

import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeUtility;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import cn.bdqn.mail.Constants;
import cn.bdqn.mail.entity.Email;
import cn.bdqn.mail.service.IEmailService;
@Component("sendMailJob")
public class SendMailJob {

	private String tempPath="D:\\temp";
	private IEmailService emailService;
	private JavaMailSender javaMailSender;
	
	@Autowired
	public void setEmailService(IEmailService emailService) {
		this.emailService = emailService;
	}
	
	@Autowired
	public void setJavaMailSender(JavaMailSender javaMailSender) {
		this.javaMailSender = javaMailSender;
	}
	
	public void doJob(){
		//获得所有未发送邮件列表
		List<Email> emails=emailService.findEmail(Constants.STATUS_UNSEND);
		
		//将现有的未发送邮件改造成发送中状态
		emailService.updateSending();
		
		for (Email email:emails) {
			
			try {
				//判断邮件是否有附件
				if(email.getFilePath()==null){
					//发送简单纯文本邮件
					//创建简单邮件对象
					SimpleMailMessage msg = new SimpleMailMessage();  
					//设置发件人地址，应当与mailSender设置的账户一致
					msg.setFrom(email.getSender()); 
					//设置收件人地址 
					msg.setTo(email.getReceiver());  
					//设置邮件标题
					msg.setSubject(email.getSubject());  
					//设置邮件内容
					msg.setText(email.getText());
					//发送邮件
					javaMailSender.send(msg);
				}
				else{
					//发送带附件邮件
					//创建Mime邮件对象
					MimeMessage msg = javaMailSender.createMimeMessage();
					
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
					
					//添加邮件附件	
					FileSystemResource file = new FileSystemResource(new File(tempPath+"\\"+email.getFilePath()));  
					String fileName=email.getFileName();			
					//解决中文乱码问题
					fileName=MimeUtility.encodeText(fileName);
					helper.addAttachment(fileName,file); 
					
					//发送邮件
					javaMailSender.send(msg);
				}
				//修改邮件发送状态为已发送状态
				emailService.updateSend(email.getId());	
				System.out.println("邮件发送成功！");
			} catch (Exception e) {
				e.printStackTrace();
			} 
		}
	}
}
