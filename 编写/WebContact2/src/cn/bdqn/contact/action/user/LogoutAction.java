package cn.bdqn.contact.action.user;

import cn.bdqn.contact.action.BaseAction;

public class LogoutAction extends BaseAction {

	
	@Override
	public String execute() throws Exception {
		sessionMap.clear();
		return SUCCESS;
	}
}
