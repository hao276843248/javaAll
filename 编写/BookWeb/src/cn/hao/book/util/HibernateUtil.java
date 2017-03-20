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
			//��������
			Configuration cfg=new Configuration();
			cfg.configure();
			//����sessionFactory
			sessionFactory=cfg.buildSessionFactory();			
		} catch (Exception e) {
			logger.error("����SessionFactoryʱ��������",e);
		}
	}
		
	public static Session getSession(){
		//ÿ�ζ����������µ�session����
		return sessionFactory.openSession();
	}
	
	public static Session getCurrentSession(){
		//�������������в�����û���Ѿ��򿪵ġ����õ�session�����û�У������µ�session��������������
		//����У���ֱ��ʹ���������е�session�����ٴ��µ�session
		return sessionFactory.getCurrentSession();
	}
	
}








