package cn.bdqn.contact.action.user;

import cn.bdqn.contact.action.BaseAction;
import cn.bdqn.contact.entity.User;

public class UpdatePasswordAction extends BaseAction {
	
	private String oldPwd;
	private String newPwd;
	private String rePwd;
	
	/*@Override
	public void validate() {
		User user =(User)sessionMap.get(USER_SESSION_KEY);
		if(!user.getPassword().equals(oldPwd)){
			addFieldError("oldPwd", getText("oldPwd.invalid"));
		}else if(oldPwd.equals(newPwd)){
			addFieldError("newPwd", getText("newPwd.invalid"));	
		}else{
			user.setPassword(newPwd);
			userService.updateUser(user);
		}
	}*/
	
	
	@Override
	public String execute() throws Exception {
		User user =(User)sessionMap.get(USER_SESSION_KEY);
		System.out.println(user.getUserName()+"--"+user.getPassword());
		if(oldPwd.equals(newPwd)){
			addFieldError("newPwd", getText("newPwd.invalid"));
			return INPUT;
		}else{
			user.setPassword(newPwd);
			userService.updateUser(user);
			return SUCCESS;
		}
		
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
