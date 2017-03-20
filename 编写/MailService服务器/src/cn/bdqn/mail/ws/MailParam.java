package cn.bdqn.mail.ws;

import javax.activation.DataHandler;


//用来封装其他系统在调用邮件服务时传递的参数
public class MailParam {
	
	//用来认证用户身份的用户名和密码
	private String userName;
	private String password;
	
	//邮件内容
	//发送者
	private String sender;
	//接受者
	private String receiver;
	//邮件主题
	private String subject;
	//邮件内容
	private String text;
	
	//附件信息
	//附件文件数据
	private DataHandler fileData;
	//附件文件名
	private String fileName;
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSender() {
		return sender;
	}
	public void setSender(String sender) {
		this.sender = sender;
	}
	public String getReceiver() {
		return receiver;
	}
	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public DataHandler getFileData() {
		return fileData;
	}
	public void setFileData(DataHandler fileData) {
		this.fileData = fileData;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	

}







