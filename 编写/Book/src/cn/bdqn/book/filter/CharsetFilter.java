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
		System.out.println("������CharsetFilter�����ַ�������");
		//����������ַ�������
		request.setCharacterEncoding(charset);
		//�����󽻸��������ڼ�������
		chain.doFilter(request, response);
		
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		//ͨ��FilterConfig��ȡ��Թ�������˽�г�ʼ������
		if(filterConfig.getInitParameter("charset")!=null){
			charset=filterConfig.getInitParameter("charset");
		}
	}
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}


}
