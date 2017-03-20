package cn.bdqn.contact.action.user;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.bdqn.contact.action.BaseAction;

@Controller("logoutAction")
@Scope("prototype")
public class LogoutAction extends BaseAction{
	
	@Override
	public String execute() throws Exception {
		sessionMap.clear();
		return SUCCESS;
	}

}
