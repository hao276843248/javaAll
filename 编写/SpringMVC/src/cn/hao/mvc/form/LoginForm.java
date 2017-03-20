package cn.hao.mvc.form;

import org.hibernate.validator.constraints.NotEmpty;

public class LoginForm {

	private String loginName="请输入用户名";
	private String password;
	
	
	@NotEmpty
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	
	@NotEmpty
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
