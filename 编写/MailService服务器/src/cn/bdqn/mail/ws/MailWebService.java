package cn.bdqn.mail.ws;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.activation.DataHandler;
import javax.jws.WebMethod;
import javax.jws.WebService;

import org.apache.cxf.helpers.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cn.bdqn.mail.Constants;
import cn.bdqn.mail.entity.Email;
import cn.bdqn.mail.entity.User;
import cn.bdqn.mail.service.IEmailService;


@Component("mailWebService")
public class MailWebService implements IMailWebService {
	
	private String tempPath="D:\\temp";
	
	private IEmailService emailService;
	
	@Autowired
	public void setEmailService(IEmailService emailService) {
		this.emailService = emailService;
	}
	
	
	public int sendMail(MailParam mailParam){
		
		try {
			//验证身份
			User user=emailService.getUser(mailParam.getUserName());
			if(user==null){
				return -1;
			}
			else if(!user.getPassword().equals(mailParam.getPassword())){
				return -2;
			}
			
			//创建实体对象，保存邮件数据
			Email email=new Email();
			email.setSender(mailParam.getSender());
			email.setReceiver(mailParam.getReceiver());
			email.setSubject(mailParam.getSubject());
			email.setText(mailParam.getText());
			if(mailParam.getFileData()!=null){
				//处理附件，转存成临时文件
				DataHandler fileData=mailParam.getFileData();
				String filePath=user.getId()+"_"+System.currentTimeMillis()+".tmp";
				IOUtils.copy(fileData.getInputStream(), new FileOutputStream(tempPath+"\\"+filePath));
				
				email.setFileName(mailParam.getFileName());
				email.setFilePath(filePath);				
			}
			//将邮件状态设置为未发送
			email.setSend(Constants.STATUS_UNSEND);
			
			//保存数据
			emailService.saveEmail(email);
			
			return 1;
			
		} catch (Exception e) {			
			e.printStackTrace();
			return -3;
		}

	}

}
