package cn.hao.book.util;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	
	private static Logger logger=Logger.getLogger(HibernateUtil.class);
	private static SessionFactory sessionFactory;
	
	static{
		try {
			//加载配置
			Configuration cfg=new Configuration();
			cfg.configure();
			//创建sessionFactory
			sessionFactory=cfg.buildSessionFactory();			
		} catch (Exception e) {
			logger.error("创建SessionFactory时发生错误",e);
		}
	}
		
	public static Session getSession(){
		//每次都立即创建新的session对象
		return sessionFactory.openSession();
	}
	
	public static Session getCurrentSession(){
		//首先在上下文中查找有没有已经打开的、可用的session，如果没有，创建新的session并放入上下文中
		//如果有，则直接使用上下文中的session，不再打开新的session
		return sessionFactory.getCurrentSession();
	}
	
}








