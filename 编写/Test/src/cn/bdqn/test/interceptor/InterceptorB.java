package cn.bdqn.test.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class InterceptorB extends AbstractInterceptor{

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		System.out.println("ִ����InterceptorB��ǰ�ô���");
		String result=invocation.invoke();
		System.out.println("ִ����InterceptorB�ĺ��ô���");
		return result;
		
		//return "hello";
	}

}








