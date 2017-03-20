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
	//表示纯在临时目录下上传的文件
	private File upload;
	//上传文件类型
	private String uploadContentType;
	//上传文件的原始文件名
	private String uploadFileName;
	
	@Override
	public String execute() throws Exception {
		System.out.println("标题:"+title);
		System.out.println("上传文件目录："+upload);
		System.out.println(uploadContentType);
		System.out.println(uploadFileName);
		//创建新的扩展名
		String extName=FilenameUtils.getExtension(uploadFileName);
		//创建新文件名
		String newFileName=System.currentTimeMillis()+"."+extName;
	
		//获得upload目录的绝对路径
		ServletContext sc=ServletActionContext.getServletContext();
		String uploadPath=sc.getRealPath("/upload");
		
		//转存文件
		FileUtils.copyFile(upload,new File(uploadPath+"/"+newFileName));
		System.out.println("上传成功");
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



