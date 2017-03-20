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
			logger.debug("OpenSessionInViewFilter��ȡSession");
			//����getCurrentSession������Session������������
			Session session=HibernateUtil.getCurrentSession();
			//��������
			tx=session.beginTransaction();
			
			chain.doFilter(request,response);
			
			//�ύ����(�ر�Session)
			logger.debug("OpenSessionInViewFilter�ύ����");
			tx.commit();
		} catch (Exception e) {
			if(tx!=null && tx.isActive()){
				logger.debug("OpenSessionInViewFilter�ع�����");
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
