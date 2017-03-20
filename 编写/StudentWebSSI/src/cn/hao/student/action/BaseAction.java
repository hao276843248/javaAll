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
//Action父类
public class BaseAction extends ActionSupport implements RequestAware,SessionAware{
	
	public static final String USER_SESSION_KEY="user";
	
	
	//与请求作用域对应的Map集合
	protected Map<String,Object> requestMap;
	//与会话作用域对应的Map集合
	protected Map<String,Object> sessionMap;
	
	private String vcode;
	
	public String getVcode() {
		return vcode;
	}

	public void setVcode(String vcode) {
		this.vcode = vcode;
	}
	
	//照片临时文件
	private File upload;
	//照片原始文件名
	private String uploadFileName;
	
	public String upload()throws IOException{
		//获得扩展名
		String extName=FilenameUtils.getExtension(uploadFileName);
		//获得当前登录的用户
		//User user=(User)sessionMap.get(USER_SESSION_KEY);
		//生成新的文件名
		String newFileName=System.currentTimeMillis()+"."+extName;
		//获得上传目录的绝对路径
		ServletContext sc=ServletActionContext.getServletContext();
		String path=sc.getRealPath("/upload");
		
		//转存文件
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
