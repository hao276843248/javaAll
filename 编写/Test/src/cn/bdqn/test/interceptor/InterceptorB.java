package cn.bdqn.test.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class InterceptorB extends AbstractInterceptor{

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		System.out.println("执行了InterceptorB的前置处理");
		String result=invocation.invoke();
		System.out.println("执行了InterceptorB的后置处理");
		return result;
		
		//return "hello";
	}

}








