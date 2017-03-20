package cn.hao.student.action;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletContext;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;

import cn.hao.student.service.student.IStudentService;

import com.opensymphony.xwork2.ActionSupport;
//Action����
public class BaseAction extends ActionSupport implements RequestAware,SessionAware{
	
	public static final String USER_SESSION_KEY="user";
	
	
	//�������������Ӧ��Map����
	protected Map<String,Object> requestMap;
	//��Ự�������Ӧ��Map����
	protected Map<String,Object> sessionMap;
	
	private String vcode;
	
	public String getVcode() {
		return vcode;
	}

	public void setVcode(String vcode) {
		this.vcode = vcode;
	}
	
	//��Ƭ��ʱ�ļ�
	private File upload;
	//��Ƭԭʼ�ļ���
	private String uploadFileName;
	
	public String upload()throws IOException{
		//�����չ��
		String extName=FilenameUtils.getExtension(uploadFileName);
		//��õ�ǰ��¼���û�
		//User user=(User)sessionMap.get(USER_SESSION_KEY);
		//�����µ��ļ���
		String newFileName=System.currentTimeMillis()+"."+extName;
		//����ϴ�Ŀ¼�ľ���·��
		ServletContext sc=ServletActionContext.getServletContext();
		String path=sc.getRealPath("/upload");
		
		//ת���ļ�
		FileUtils.copyFile(upload,new File(path+"/"+newFileName));
		
		return newFileName;
	}
	
	
	protected IStudentService studentService;

	@Autowired
	public void setStudentService(IStudentService studentService) {
		this.studentService = studentService;
	}

	@Override
	public void setSession(Map<String, Object> sessionMap) {
		this.sessionMap=sessionMap;
	}
	
	@Override
	public void setRequest(Map<String, Object> requestMap) {
		this.requestMap=requestMap;
	}

	public Map<String, Object> getRequestMap() {
		return requestMap;
	}

	public void setRequestMap(Map<String, Object> requestMap) {
		this.requestMap = requestMap;
	}

	public Map<String, Object> getSessionMap() {
		return sessionMap;
	}

	public void setSessionMap(Map<String, Object> sessionMap) {
		this.sessionMap = sessionMap;
	}

	

	public File getUpload() {
		return upload;
	}

	public void setUpload(File upload) {
		this.upload = upload;
	}

	public String getUploadFileName() {
		return uploadFileName;
	}

	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	public static String getUserSessionKey() {
		return USER_SESSION_KEY;
	}
	
	
	
	
	

}
