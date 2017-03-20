package cn.hao.book.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;


import org.apache.log4j.Logger;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import cn.hao.book.util.HibernateUtil;


public class OpenSessionInViewFilter implements Filter{
	
	private Logger logger=Logger.getLogger(OpenSessionInViewFilter.class);
	

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		
		Transaction tx=null;
		try {
			logger.debug("OpenSessionInViewFilter获取Session");
			//调用getCurrentSession方法打开Session并存入上下文
			Session session=HibernateUtil.getCurrentSession();
			//开启事务
			tx=session.beginTransaction();
			
			chain.doFilter(request,response);
			
			//提交事务(关闭Session)
			logger.debug("OpenSessionInViewFilter提交事务");
			tx.commit();
		} catch (Exception e) {
			if(tx!=null && tx.isActive()){
				logger.debug("OpenSessionInViewFilter回滚事务");
				tx.rollback();
			}
		}
		
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
