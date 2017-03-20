package cn.bdqn.contact.action.contact;

import java.io.File;

import javax.servlet.ServletContext;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ModelDriven;

import cn.bdqn.contact.action.BaseAction;
import cn.bdqn.contact.entity.Contact;
import cn.bdqn.contact.entity.Group;
import cn.bdqn.contact.entity.User;

public class UpdateContactAction extends BaseAction implements ModelDriven<Contact> {

	private Contact contact = new Contact();
	private File upload;
	private String uploadContentType;
	private String uploadFileName;

	@Override
	public Contact getModel() {
		return contact;
	}

	@Override
	public void validate() {
		// �ж������Ƿ�����
		if (contact.getBirthday() != null
				&& contact.getBirthday().getTime() > System.currentTimeMillis()) {
			addFieldError("birthday", getText("birthday.invalid"));
		}
	}
	
	@Override
	public String execute() throws Exception {
		System.out.println("�ļ�:" + upload);
		System.out.println("����:" + uploadContentType);
		System.out.println("�ļ���:" + uploadFileName);
		//����ļ�����չ��
		String extName=FilenameUtils.getExtension(uploadFileName);
		//�������ļ���
		String newFileName=System.currentTimeMillis()+"."+extName;
		//���uploadĿ¼�ľ���·��
		ServletContext sc = ServletActionContext.getServletContext();
		String uploadPath=sc.getRealPath("/upload");
		//ת���ļ�
		FileUtils.copyFile(upload,new File(uploadPath+"/"+newFileName));
		System.out.println("�ϴ��ɹ���");
		User user =(User)sessionMap.get(USER_SESSION_KEY);
		contact.setPhoto(newFileName);
		contact.setUser(user);
		contactService.updateContact(contact);
		return SUCCESS;
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
