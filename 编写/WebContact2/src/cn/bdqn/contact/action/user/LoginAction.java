package cn.bdqn.contact.action.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import cn.bdqn.contact.action.BaseAction;
import cn.bdqn.contact.entity.User;

public class LoginAction extends BaseAction {
	//接收表单提交的数据
	private String userName;
	private String password;
	
	@Override
	public void validate() {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		System.out.println(session.getAttribute("KAPTCHA_SESSION_KEY"));
	}
	
	
	@Override
	public String execute() throws Exception {
		User user = userService.getUser(userName);
		if(user==null){
			addFieldError("userName",getText("username.invalid") );
			return INPUT;
		}else if(!user.getPassword().equals(password)){
			addFieldError("password", getText("password.invalid"));
			return INPUT;
		}else{
			sessionMap.put(USER_SESSION_KEY,user);
			return SUCCESS;
		}
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
	
	

}
