package cn.hao.contact.filter;

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

import cn.hao.contact.action.BaseAcrtion;


public class LoginFilter implements Filter{

	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
	
		
		System.out.println("¼ì²éÊÇ·ñµÇÂ¼");
		HttpServletRequest httpRequest=(HttpServletRequest) request;
		HttpServletResponse httpResponse=(HttpServletResponse) response;
		
		HttpSession httpSession=httpRequest.getSession(true);
		if(httpSession.getAttribute(BaseAcrtion.USER_SESSION_KEY)==null){
			httpResponse.sendRedirect("../login.jsp?r="+Math.random());
		}else{
			chain.doFilter(request,response);
		}
	}
	

}
