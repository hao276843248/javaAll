package cn.hao.test.action;

import java.io.InputStream;
import java.net.URLEncoder;

import javax.servlet.ServletContext;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class Download extends ActionSupport{

	private InputStream inputStream;
	private String fileName;
	
	@Override
	public String execute() throws Exception {
		ServletContext sc=ServletActionContext.getServletContext();
		
		inputStream=sc.getResourceAsStream("/upload/2.����ͼ����Ŀ���ö�������Ͳ�ѯ����.exe");
		fileName=URLEncoder.encode("2.����ͼ����Ŀ���ö�������Ͳ�ѯ����.exe","utf-8");
		return SUCCESS;
	}

	public InputStream getInputStream() {
		return inputStream;
	}

	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
}
