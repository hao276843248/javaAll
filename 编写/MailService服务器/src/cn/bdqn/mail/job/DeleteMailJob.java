package cn.bdqn.mail.job;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cn.bdqn.mail.Constants;
import cn.bdqn.mail.entity.Email;
import cn.bdqn.mail.service.EmailServiceImpl;
import cn.bdqn.mail.service.IEmailService;
@Component("deleteMailJob")
public class DeleteMailJob {

	private String tempPath="D:\\temp";
	private IEmailService emailService;
	@Autowired
	public void setEmailService(IEmailService emailService) {
		this.emailService = emailService;
	}
	
	public void doJob(){
		List<Email> emails=emailService.findEmail(Constants.STATUS_SENDED);
		
		for(Email email:emails){
			//ɾ�����ݿ��еļ�¼
			emailService.deleteEmail(email.getId());
			//�ж��ʼ��Ƿ��и���
			if(email.getFilePath()!=null){
				File file=new File(tempPath+"\\"+email.getFilePath());
				file.delete();
			}
		}
		
	}
}
