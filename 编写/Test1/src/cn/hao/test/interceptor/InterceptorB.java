package cn.hao.test.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class InterceptorB extends AbstractInterceptor{

	
	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		System.out.println("ִ����InterceptorB��ǰ�ô���");
		String result=invocation.invoke();
		System.out.println("ִ����InterceptorB�ĺ��ô���");
		return null;
	}
	

}
