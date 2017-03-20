package cn.bdqn.contact.form;

import java.sql.Timestamp;
import java.util.Date;


import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;
import cn.bdqn.contact.entity.Contact;
import cn.bdqn.contact.entity.Group;

public class ContactForm {

	private Integer id;
	
	private Integer gid;
	private String name;
	private String sex;
	private MultipartFile upload;
	private String title;
	private String phone;
	private Date birthday;
	private String email;
	private String qq;
	private String address;
	private String description;
	private String vcode;
	
	
	public ContactForm() {
		// TODO Auto-generated constructor stub
	}
	
	
	public ContactForm(Contact contact) {
		this.id=contact.getId();
		this.gid = contact.getGroup().getId();
		this.name = contact.getName();
		this.sex = contact.getSex();
		this.title = contact.getTitle();
		this.phone = contact.getPhone();
		this.birthday = contact.getBirthday();
		this.email = contact.getEmail();
		this.qq = contact.getQq();
		this.address = contact.getAddress();
		this.description = contact.getDescription();
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}
	@NotNull
	public Integer getGid() {
		return gid;
	}
	public void setGid(Integer gid) {
		this.gid = gid;
	}
	@NotEmpty
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@NotEmpty
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	
	@NotNull
	public MultipartFile getUpload() {
		return upload==null ||upload.isEmpty()?null:upload;
	}
	public void setUpload(MultipartFile upload) {
		this.upload = upload;
	}
	@NotEmpty
	public String getVcode() {
		return vcode;
	}
	public void setVcode(String vcode) {
		this.vcode = vcode;
	}
	@NotEmpty
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	@NotEmpty
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	@NotNull
	@DateTimeFormat(pattern="yyyy-MM-dd")
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	@Email
	@NotEmpty
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@NotEmpty
	public String getQq() {
		return qq;
	}
	public void setQq(String qq) {
		this.qq = qq;
	}
	@NotEmpty
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@NotEmpty
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public Contact getContact(){
		Group group=new Group();
		group.setId(gid);
		Contact c= new Contact(group, null, name, title, sex, null, new Timestamp(birthday.getTime()), phone, email, qq, address, description);
		c.setId(id);
		return c;
	}
}
