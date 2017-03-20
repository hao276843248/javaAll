package cn.bdqn.contact.action.user;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ModelDriven;

import cn.bdqn.contact.action.BaseAction;
import cn.bdqn.contact.entity.User;

//用户注册Action
@Controller("registAction")
@Scope("prototype")
public class RegistAction extends BaseAction implements ModelDriven<User>{
	
	//用来封装表单数据的数据模型
	private User user=new User();
	
	//确认密码
	private String rePwd;
	
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


	
}












