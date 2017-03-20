package cn.bdqn.test.action;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ScopeAction extends ActionSupport{
	
	@Override
	public String execute() throws Exception {
		//��ú͵�ǰ������ص�Action�����Ķ���
		ActionContext ctx=ActionContext.getContext();
		
		//��ú������������Ӧ��Map���ϣ���Map���ϴ������ݣ����൱���������������������
		Map<String,Object> requestMap=(Map<String, Object>)ctx.get("request");
		//��úͻỰ(Session)�������Ӧ��Map���ϣ��򼯺ϴ������ݣ����൱����Ự������(Session)��������
		Map<String,Object> sessionMap=ctx.getSession();
		//��ú�Ӧ�ó����������Ӧ��Map���ϣ��򼯺ϴ������ݣ����൱����ServletContext��������
		Map<String,Object> applicationMap=ctx.getApplication();
		
		requestMap.put("msg","�������������������");
		sessionMap.put("msg","����Ự�����������");
		applicationMap.put("msg","����Ӧ�ó��������������");
		
		return SUCCESS;
	}

}





