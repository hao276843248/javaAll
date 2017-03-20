package cn.hao.test.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class InterceptorB extends AbstractInterceptor{

	
	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		System.out.println("执行了InterceptorB的前置处理");
		String result=invocation.invoke();
		System.out.println("执行了InterceptorB的后置处理");
		return null;
	}
	

}
