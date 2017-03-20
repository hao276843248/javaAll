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
		// 判断生日是否输入
		if (contact.getBirthday() != null
				&& contact.getBirthday().getTime() > System.currentTimeMillis()) {
			addFieldError("birthday", getText("birthday.invalid"));
		}
	}
	
	@Override
	public String execute() throws Exception {
		System.out.println("文件:" + upload);
		System.out.println("类型:" + uploadContentType);
		System.out.println("文件名:" + uploadFileName);
		//获得文件的拓展名
		String extName=FilenameUtils.getExtension(uploadFileName);
		//创建新文件名
		String newFileName=System.currentTimeMillis()+"."+extName;
		//获得upload目录的绝对路径
		ServletContext sc = ServletActionContext.getServletContext();
		String uploadPath=sc.getRealPath("/upload");
		//转存文件
		FileUtils.copyFile(upload,new File(uploadPath+"/"+newFileName));
		System.out.println("上传成功！");
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
