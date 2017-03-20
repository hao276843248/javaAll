package cn.hao.contact.action.user;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.hao.contact.action.BaseAcrtion;

@Controller("logoutAction")
@Scope("prototype")
public class LogoutAction extends BaseAcrtion{
	@Override
	public String execute() throws Exception {
		sessionMap.clear();
		return SUCCESS;
	}
}
