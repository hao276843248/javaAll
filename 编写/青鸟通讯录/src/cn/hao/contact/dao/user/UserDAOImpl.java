package cn.hao.contact.dao.user;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import cn.hao.contact.entity.User;
import cn.hao.contact.util.HibernateUtil;
@Repository("userDao")
public class UserDAOImpl implements IUserDAO{

	private Logger logger=Logger.getLogger(UserDAOImpl.class);
	@Override
	public void addUser(User user) {
		Session session=null;
		Transaction tx=null;
		try {
			session=HibernateUtil.getSession();
			tx=session.beginTransaction();
			session.save(user);
			tx.commit();
		} catch (Exception e) {
			logger.error("����û�ʱ��������");
			tx.rollback();
			throw new RuntimeException(e);
		}finally{
			session.close();
		}
		
	}

	@Override
	public User getUser(String userName) {
		User user=null;
		Session session=null;
		try {
			session=HibernateUtil.getSession();
			user=(User) session.createQuery("from User where userName=:userName")
					    .setString("userName", userName)
					    .uniqueResult();
					
		} catch (Exception e) {
			logger.error("�����û�����ȡ�û���Ϣʱ��������");
			throw new RuntimeException(e);
		}finally{
			session.close();
		}
		return user;
	}

	
	@Override
	public void updatePassword(User user) {
		Session session =null;
		Transaction tx =null;
		
		try {
			session=HibernateUtil.getSession();
			tx =session.beginTransaction();
			session.update(user);
			tx.commit();
		} catch (Exception e) {
			logger.error("�޸�����ʱ��������");
			tx.rollback();
			throw new RuntimeException(e);
		}finally{
			session.close();
		}
		
	}

}
