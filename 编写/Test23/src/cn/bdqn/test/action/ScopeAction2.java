package cn.bdqn.test.action;

import java.util.Map;

import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ScopeAction2 extends ActionSupport implements RequestAware,SessionAware,ApplicationAware{
	
	private Map<String,Object> requestMap;
	private Map<String,Object> sessionMap;
	private Map<String,Object> applicationMap;
	
	@Override
	public void setRequest(Map<String, Object> requestMap) {
		this.requestMap=requestMap;
	}
	
	@Override
	public void setSession(Map<String, Object> sessionMap) {
		this.sessionMap=sessionMap;
	}
	
	@Override
	public void setApplication(Map<String, Object> applicationMap) {
		this.applicationMap=applicationMap;
	}
	
	
	@Override
	public String execute() throws Exception {
	
		requestMap.put("msg","�������������������");
		sessionMap.put("msg","����Ự�����������");
		applicationMap.put("msg","����Ӧ�ó��������������");
		
		return SUCCESS;
	}

}





