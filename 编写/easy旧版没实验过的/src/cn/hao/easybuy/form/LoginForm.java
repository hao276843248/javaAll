package cn.hao.easybuy.form;

import org.hibernate.validator.constraints.NotEmpty;

public class LoginForm {

	private String userName;
	private String  password;
	
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
	
	
}
