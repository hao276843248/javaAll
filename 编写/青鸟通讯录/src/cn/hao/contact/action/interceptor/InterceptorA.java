package cn.hao.contact.action.interceptor;

import cn.hao.contact.action.BaseAcrtion;
import cn.hao.contact.entity.User;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class InterceptorA  extends BaseAcrtion implements Interceptor {

	

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		System.out.println("Ö´ÐÐ£¡1¡¤¡¤¡¤¡¤¡¤¡¤¡¤¡¤¡¤¡¤¡¤¡¤¡¤¡¤¡¤¡¤¡¤¡¤¡¤¡¤¡¤¡¤¡¤");
		String result=invocation.invoke();
		if(false){
			System.out.println("Ö´ÐÐ£¡2¡¤¡¤¡¤¡¤¡¤¡¤¡¤¡¤¡¤¡¤¡¤¡¤¡¤¡¤¡¤¡¤¡¤¡¤¡¤¡¤¡¤¡¤¡¤");
			return "NO";
		}
		return result;
	}
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}


}
