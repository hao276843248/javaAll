package cn.hao.contact.action.contact;

import java.io.File;

import javax.servlet.ServletContext;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ModelDriven;

import cn.hao.contact.action.BaseAcrtion;
import cn.hao.contact.entity.Contact;
import cn.hao.contact.entity.User;

@Controller("addAction")
@Scope("prototype")
public class addContactAction extends BaseAcrtion implements
		ModelDriven<Contact> {

	private Contact contact = new Contact();

	// ��ʾ������ʱĿ¼�µ��ϴ����ļ�
	private File upload;

	// �ϴ��ļ�������
	private String uploadContentType;

	// �ϴ��ļ���ԭʼ�ļ���
	private String uploadFileName;

	@Override
	public Contact getModel() {
		return contact;
	}

	@Override
	public void validate() {
		if(contact.getGroup().getId()==null){
			addFieldError("group", getText("group.required"));
		}
		if(upload==null){
			addFieldError("upload", getText("photo.required"));
		}
		if(contact.getBirthday()==null){
			addFieldError("birthday", getText("birthday.required"));
		}
		if (contact.getBirthday() != null && contact.getBirthday().getTime() > System.currentTimeMillis()) {
			addFieldError("birthday", getText("birthday.invalid"));
		}
		
	}

	@Override
	public String execute() throws Exception {
		// �����չ��
		String extName = FilenameUtils.getExtension(uploadFileName);
		// �������ļ���
		String newFileName = System.currentTimeMillis() + "." + extName;

		// ���uploadĿ¼�ľ���·��
		ServletContext sc = ServletActionContext.getServletContext();
		String uploadPath = sc.getRealPath("/upload");

		// ת���ļ�
		FileUtils.copyFile(upload, new File(uploadPath + "/" + newFileName));
		
		
		contact.setPhoto(newFileName);
		User u=(User) sessionMap.get(USER_SESSION_KEY);
		contact.setUser(u);
		contactService.addContact(contact);
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

	public Contact getContact() {
		return contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}

}
