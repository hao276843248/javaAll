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
		//�������δ�����ʼ��б�
		List<Email> emails=emailService.findEmail(Constants.STATUS_UNSEND);
		
		//�����е�δ�����ʼ�����ɷ�����״̬
		emailService.updateSending();
		
		for (Email email:emails) {
			
			try {
				//�ж��ʼ��Ƿ��и���
				if(email.getFilePath()==null){
					//���ͼ򵥴��ı��ʼ�
					//�������ʼ�����
					SimpleMailMessage msg = new SimpleMailMessage();  
					//���÷����˵�ַ��Ӧ����mailSender���õ��˻�һ��
					msg.setFrom(email.getSender()); 
					//�����ռ��˵�ַ 
					msg.setTo(email.getReceiver());  
					//�����ʼ�����
					msg.setSubject(email.getSubject());  
					//�����ʼ�����
					msg.setText(email.getText());
					//�����ʼ�
					javaMailSender.send(msg);
				}
				else{
					//���ʹ������ʼ�
					//����Mime�ʼ�����
					MimeMessage msg = javaMailSender.createMimeMessage();
					
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
					
					//����ʼ�����	
					FileSystemResource file = new FileSystemResource(new File(tempPath+"\\"+email.getFilePath()));  
					String fileName=email.getFileName();			
					//���������������
					fileName=MimeUtility.encodeText(fileName);
					helper.addAttachment(fileName,file); 
					
					//�����ʼ�
					javaMailSender.send(msg);
				}
				//�޸��ʼ�����״̬Ϊ�ѷ���״̬
				emailService.updateSend(email.getId());	
				System.out.println("�ʼ����ͳɹ���");
			} catch (Exception e) {
				e.printStackTrace();
			} 
		}
	}
}
