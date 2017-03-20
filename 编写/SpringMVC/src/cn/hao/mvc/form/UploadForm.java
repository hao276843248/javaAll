package cn.hao.mvc.form;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

public class UploadForm {

	
	private String title;
	private MultipartFile upload;
	
	
	@NotEmpty
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	//侃尖，，，，，，，，，，，，，，，，，，，，，，，，，，，，，
	@NotNull
	public MultipartFile getUpload() {
		return upload==null ||upload.isEmpty()?null:upload;
	}
	public void setUpload(MultipartFile upload) {
		this.upload = upload;
	}
	
	
	
}
