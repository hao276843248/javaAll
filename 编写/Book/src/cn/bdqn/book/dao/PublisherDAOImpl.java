package cn.bdqn.book.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;

import cn.bdqn.book.entity.Publisher;
import cn.bdqn.book.util.HibernateUtil;

public class PublisherDAOImpl implements IPublisherDAO{
	
	private Logger logger=Logger.getLogger(PublisherDAOImpl.class);
	
	@Override
	public List<Publisher> findPublihser() {
		List<Publisher> publishers=null;
		Session session=null;
		try {
			//session=HibernateUtil.getSession();
			session=HibernateUtil.getCurrentSession();
			publishers=session.getNamedQuery("findPublisher")
							  .setCacheable(true)
							  .list();
		} catch (Exception e) {
			logger.error("��ȡ�������б�ʱ��������",e);
			throw new RuntimeException(e);
		}
/*		finally{
			session.close();
		}*/
		return publishers;
	}

}







