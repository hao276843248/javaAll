package cn.hao.contact.action.user;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.hao.contact.action.BaseAcrtion;
import cn.hao.contact.entity.User;
import cn.hao.contact.service.user.IUserService;
import cn.hao.contact.service.user.UserService;
@Controller("updatePasswordAction")
@Scope("prototype")
public class UpdatePasswordAction extends BaseAcrtion{

	private String oldPwd;
	private String newPwd;
	private String rePwd;
	
	
	@Override
	public String execute() throws Exception {
		User user=(User)sessionMap.get(USER_SESSION_KEY);
		System.out.println(user.getUserName()+"---"+user.getPassword());
		
			user.setPassword(newPwd);
			userService.updatePassword(user);
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
