package cn.hao.reserve.action;

import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class BaseAction extends ActionSupport implements RequestAware,SessionAware{

	
	private Map<String,Object> requestMap;
	private Map<String,Object> sessionMap;
	
	
	@Override
	public void setSession(Map<String, Object> requestMap) {
		this.requestMap=requestMap;
	}

	@Override
	public void setRequest(Map<String, Object> sessionMap) {
		this.sessionMap=sessionMap;
	}

}
