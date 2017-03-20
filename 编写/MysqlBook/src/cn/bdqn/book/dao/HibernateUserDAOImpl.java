package cn.bdqn.book.dao;

import org.apache.log4j.Logger;
import org.hibernate.Session;

import cn.bdqn.book.entity.User;
import cn.bdqn.book.util.HibernateUtil;

public class HibernateUserDAOImpl implements IUserDAO{

	private Logger logger=Logger.getLogger(HibernateUserDAOImpl.class);
	
	@Override
	public User getUser(String loginName) {
		User user=null;
		Session session=null;
		try {
			session=HibernateUtil.getSession();
			user=(User)session.createQuery("from User where loginName=:loginName")
							  .setString("loginName", loginName)
							  .uniqueResult();
		} catch (Exception e) {
			logger.error("���ݵ�¼����ѯ�û�ʱ��������",e);
		}
		finally{
			session.close();
		}
		
		return user;
	}
	
	

}






