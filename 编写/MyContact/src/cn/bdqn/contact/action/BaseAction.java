package cn.bdqn.contact.action;

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

import cn.bdqn.contact.entity.User;
import cn.bdqn.contact.service.contact.ContactServiceImpl;
import cn.bdqn.contact.service.contact.IContactService;
import cn.bdqn.contact.service.group.GroupServiceImpl;
import cn.bdqn.contact.service.group.IGroupService;
import cn.bdqn.contact.service.user.IUserService;
import cn.bdqn.contact.service.user.UserServiceImpl;

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
		User user=(User)sessionMap.get(USER_SESSION_KEY);
		//�����µ��ļ���
		String newFileName=user.getId()+"_"+System.currentTimeMillis()+"."+extName;
		
		//����ϴ�Ŀ¼�ľ���·��
		ServletContext sc=ServletActionContext.getServletContext();
		String path=sc.getRealPath("/background/photo");
		
		//ת���ļ�
		FileUtils.copyFile(upload,new File(path+"/"+newFileName));
		
		return newFileName;
	}
	
	
	
	//�û�ģ��ҵ���߼���
	protected IUserService userService;
	//����ģ��ҵ���߼���
	protected IGroupService groupService;
	//��ϵ��ģ��ҵ���߼���
	protected IContactService contactService;
	
	
	
	
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

	
	//userService
	@Autowired
	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

	//groupService
	@Autowired
	public void setGroupService(IGroupService groupService) {
		this.groupService = groupService;
	}
	
	//contactService
	@Autowired
	public void setContactService(IContactService contactService) {
		this.contactService = contactService;
	}

	public static String getUserSessionKey() {
		return USER_SESSION_KEY;
	}
	
	
	
	
	

}
