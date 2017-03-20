package cn.bdqn.test.action;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ScopeAction extends ActionSupport{
	
	@Override
	public String execute() throws Exception {
		//获得和当前请求相关的Action上下文对象
		ActionContext ctx=ActionContext.getContext();
		
		//获得和请求作用域对应的Map集合，向Map集合存入数据，就相当于向请求作用域存入数据
		Map<String,Object> requestMap=(Map<String, Object>)ctx.get("request");
		//获得和会话(Session)作用域对应的Map集合，向集合存入数据，就相当于向会话作用域(Session)存入数据
		Map<String,Object> sessionMap=ctx.getSession();
		//获得和应用程序作用域对应的Map集合，向集合存入数据，就相当于向ServletContext存入数据
		Map<String,Object> applicationMap=ctx.getApplication();
		
		requestMap.put("msg","存入请求作用域的数据");
		sessionMap.put("msg","存入会话作用域的数据");
		applicationMap.put("msg","存入应用程序作用域的数据");
		
		return SUCCESS;
	}

}





