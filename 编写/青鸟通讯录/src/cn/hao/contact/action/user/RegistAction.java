package cn.hao.contact.action.user;


import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ModelDriven;

import cn.hao.contact.action.BaseAcrtion;
import cn.hao.contact.entity.User;
@Controller("registAction")
@Scope("prototype")
public class RegistAction extends BaseAcrtion implements ModelDriven<User>{

	private User user=new User();
	//确认密码
	private String rePwd;
	//验证码
	private String vcode;
	
	@Override
	public User getModel() {
		return user;
	}
	
	@Override
	public void validate() {
		if(userService.getUser(user.getUserName())!=null){
			addFieldError("userName",getText("username.exists"));
		}
	}
	
	@Override
	public String execute() throws Exception {
		//保存用户
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

	public String getVcode() {
		return vcode;
	}

	public void setVcode(String vcode) {
		this.vcode = vcode;
	}
	
	
}












