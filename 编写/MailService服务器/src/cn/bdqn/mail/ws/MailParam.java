package cn.bdqn.mail.ws;

import javax.activation.DataHandler;


//������װ����ϵͳ�ڵ����ʼ�����ʱ���ݵĲ���
public class MailParam {
	
	//������֤�û���ݵ��û���������
	private String userName;
	private String password;
	
	//�ʼ�����
	//������
	private String sender;
	//������
	private String receiver;
	//�ʼ�����
	private String subject;
	//�ʼ�����
	private String text;
	
	//������Ϣ
	//�����ļ�����
	private DataHandler fileData;
	//�����ļ���
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







