package cn.bdqn.contact.form;

import org.hibernate.validator.constraints.NotEmpty;

public class LoginForm {

	private String userName;
	private String password;
	private String vcode;
	
	@NotEmpty
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}

	@NotEmpty
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@NotEmpty
	public String getVcode() {
		return vcode;
	}
	public void setVcode(String vcode) {
		this.vcode = vcode;
	}
	

	
}
