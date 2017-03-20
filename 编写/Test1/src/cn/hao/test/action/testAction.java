package cn.hao.test.action;

import com.opensymphony.xwork2.ActionSupport;

public class testAction extends ActionSupport{
	
	@Override
	public String execute() throws Exception {
		System.out.println("调用了TestAction的execute()方法");
		return SUCCESS;
	}
}
