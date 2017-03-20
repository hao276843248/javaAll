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
			// ��������
			Configuration cfg = new Configuration();
			cfg.configure();
			// ����sessionFactory
			sessionFactory = cfg.buildSessionFactory();
		} catch (Exception e) {
			logger.error("����SessionFactoryʱ��������",e);
			e.printStackTrace();
		}
	}
	
	public static Session getSession(){
		return sessionFactory.openSession();
	}
}
