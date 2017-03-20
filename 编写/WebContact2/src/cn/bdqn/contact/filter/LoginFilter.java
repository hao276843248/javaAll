package cn.bdqn.contact.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.dispatcher.SessionMap;

import cn.bdqn.contact.action.BaseAction;

import com.opensymphony.xwork2.ActionContext;

public class LoginFilter implements Filter {
	
	@Override
	public void init(FilterConfig filterConfig)  throws ServletException {
		// TODO Auto-generated method stub

	}


	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain)  throws IOException, ServletException {
	
		HttpServletRequest httpRequest=(HttpServletRequest)request;
		HttpServletResponse httpResponse=(HttpServletResponse)response;
		//SessionMap<String,Object> sessionMap =(SessionMap<String, Object>) ActionContext.getContext().getSession();
		HttpSession session=httpRequest.getSession();
		//System.out.println(sessionMap.get("user"));
		if(session.getAttribute(BaseAction.USER_SESSION_KEY)==null){
			httpResponse.sendRedirect("../login.jsp");
		}else{
			chain.doFilter(request,response);
		}
	}

	
}
