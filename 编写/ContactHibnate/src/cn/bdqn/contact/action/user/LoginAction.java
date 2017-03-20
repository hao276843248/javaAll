package cn.bdqn.contact.action.user;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.bdqn.contact.action.BaseAction;
import cn.bdqn.contact.entity.User;

@Controller("loginAction")
@Scope("prototype")
public class LoginAction extends BaseAction{
	
	//接收表单提交的数据
	private String userName;
	private String password;

	
	@Override
	public String execute() throws Exception {
		
		User user=userService.getUser(userName);
		
		if(user==null){
			addFieldError("userName",getText("username.invalid"));
			return INPUT;
		}
		else if(!user.getPassword().equals(password)){
			addFieldError("password",getText("password.invalid"));
			return INPUT;			
		}
		else{
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
