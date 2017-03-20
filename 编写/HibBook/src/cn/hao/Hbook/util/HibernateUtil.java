package cn.hao.Hbook.util;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private static Logger logger=Logger.getLogger(HibernateUtil.class);
	private static SessionFactory sessionFactory;
	
	static{
		try{
			// 加载配置
			Configuration cfg = new Configuration();
			cfg.configure();
			// 创建sessionFactory
			sessionFactory = cfg.buildSessionFactory();
		} catch (Exception e) {
			logger.error("创建SessionFactory时发生错误",e);
			e.printStackTrace();
		}
	}
	
	public static Session getSession(){
		return sessionFactory.openSession();
	}
}
