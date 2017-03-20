package cn.hao.test.action;

import java.io.File;

import javax.servlet.Servlet;
import javax.servlet.ServletContext;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class Upload extends ActionSupport{

	private String title;
	//��ʾ������ʱĿ¼���ϴ����ļ�
	private File upload;
	//�ϴ��ļ�����
	private String uploadContentType;
	//�ϴ��ļ���ԭʼ�ļ���
	private String uploadFileName;
	
	@Override
	public String execute() throws Exception {
		System.out.println("����:"+title);
		System.out.println("�ϴ��ļ�Ŀ¼��"+upload);
		System.out.println(uploadContentType);
		System.out.println(uploadFileName);
		//�����µ���չ��
		String extName=FilenameUtils.getExtension(uploadFileName);
		//�������ļ���
		String newFileName=System.currentTimeMillis()+"."+extName;
	
		//���uploadĿ¼�ľ���·��
		ServletContext sc=ServletActionContext.getServletContext();
		String uploadPath=sc.getRealPath("/upload");
		
		//ת���ļ�
		FileUtils.copyFile(upload,new File(uploadPath+"/"+newFileName));
		System.out.println("�ϴ��ɹ�");
		return NONE;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public File getUpload() {
		return upload;
	}
	public void setUpload(File upload) {
		this.upload = upload;
	}
	public String getUploadContentType() {
		return uploadContentType;
	}
	public void setUploadContentType(String uploadContentType) {
		this.uploadContentType = uploadContentType;
	}
	public String getUploadFileName() {
		return uploadFileName;
	}
	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}
	
	
}



