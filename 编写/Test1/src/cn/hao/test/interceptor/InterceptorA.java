package cn.hao.test.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class InterceptorA implements Interceptor{

	
	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		System.out.println("ִ����InterceptorA��ǰ�ô���");
		String result=invocation.invoke();
		System.out.println("ִ����InterceptorA�ĺ��ô���");
		return null;
	}
	@Override
	public void destroy() {
		System.out.println("���ٷ���");
	}

	@Override
	public void init() {
		System.out.println("��ʼ������");
		
	}

}
