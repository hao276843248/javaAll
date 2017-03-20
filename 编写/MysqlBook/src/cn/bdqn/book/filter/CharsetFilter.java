package cn.bdqn.book.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class CharsetFilter implements Filter{
	
	private String charset="utf-8";
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		System.out.println("调用了CharsetFilter设置字符集编码");
		//设置请求的字符集编码
		request.setCharacterEncoding(charset);
		//将请求交给后续环节继续处理
		chain.doFilter(request, response);
		
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		//通过FilterConfig读取针对过滤器的私有初始化参数
		if(filterConfig.getInitParameter("charset")!=null){
			charset=filterConfig.getInitParameter("charset");
		}
	}
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}


}
