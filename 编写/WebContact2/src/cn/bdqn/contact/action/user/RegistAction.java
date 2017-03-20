package cn.bdqn.contact.action.user;

import cn.bdqn.contact.action.BaseAction;
import cn.bdqn.contact.entity.User;

import com.opensymphony.xwork2.ModelDriven;

public class RegistAction extends BaseAction implements ModelDriven<User> {
	
	
	private User user = new User();
	private String rePwd;

	@Override
	public User getModel() {
		return user;
	}
	
	@Override
	public void validate() {
		if(userService.getUser(user.getUserName())!=null){
			addFieldError("username",getText("username.exists"));
		}
	}
	
	@Override
	public String execute() throws Exception {
		userService.addUser(user);
		return SUCCESS;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getRePwd() {
		return rePwd;
	}

	public void setRePwd(String rePwd) {
		this.rePwd = rePwd;
	}

	
}
