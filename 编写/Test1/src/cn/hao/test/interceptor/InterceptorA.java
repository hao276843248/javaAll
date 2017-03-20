package cn.hao.test.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class InterceptorA implements Interceptor{

	
	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		System.out.println("执行了InterceptorA的前置处理");
		String result=invocation.invoke();
		System.out.println("执行了InterceptorA的后置处理");
		return null;
	}
	@Override
	public void destroy() {
		System.out.println("销毁方法");
	}

	@Override
	public void init() {
		System.out.println("初始化方法");
		
	}

}
