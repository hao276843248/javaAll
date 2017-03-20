package cn.bdqn.test.action;

import java.io.InputStream;
import java.net.URLEncoder;

import javax.servlet.ServletContext;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class DownloadAction extends ActionSupport {
	
	private InputStream inputStream;
	private String fileName;
	
	@Override
	public String execute() throws Exception {
		
		ServletContext sc=ServletActionContext.getServletContext();

		inputStream=sc.getResourceAsStream("/upload/MyEclipse 8.5×¢²á»ú.exe");
		fileName=URLEncoder.encode("MyEclipse 8.5×¢²á»ú.exe","utf-8");
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









