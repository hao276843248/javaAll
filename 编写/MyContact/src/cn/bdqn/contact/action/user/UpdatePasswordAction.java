package cn.bdqn.contact.action.user;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.bdqn.contact.action.BaseAction;
import cn.bdqn.contact.entity.User;


@Controller("updatePasswordAction")
@Scope("prototype")
public class UpdatePasswordAction extends BaseAction{
	
	//原密码
	private String oldPwd;
	//新密码
	private String newPwd;
	//确认新密码
	private String rePwd;
	
	@Override
	public String execute() throws Exception {
		User user=(User)sessionMap.get(USER_SESSION_KEY);		
		userService.updatePassword(user.getId(),newPwd);
		
		user.setPassword(newPwd);
		
		return SUCCESS;
	}

	public String getOldPwd() {
		return oldPwd;
	}

	public void setOldPwd(String oldPwd) {
		this.oldPwd = oldPwd;
	}

	public String getNewPwd() {
		return newPwd;
	}

	public void setNewPwd(String newPwd) {
		this.newPwd = newPwd;
	}

	public String getRePwd() {
		return rePwd;
	}

	public void setRePwd(String rePwd) {
		this.rePwd = rePwd;
	}
	
	
	

}
