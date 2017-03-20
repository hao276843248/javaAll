package cn.bdqn.test.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class InterceptorA implements Interceptor{
	
	@Override
	public void init() {
		System.out.println("初始化InterceptorA");
	}	

	@Override
	public void destroy() {
		System.out.println("销毁InterceptorA");
	}

	
	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		System.out.println("执行了InterceptorA的前置处理");
		String result=invocation.invoke();
		System.out.println("执行了InterceptorA的后置处理");
		return result;
	}

}








