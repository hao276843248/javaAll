package cn.bdqn.book.dao;

import org.apache.log4j.Logger;
import org.hibernate.Session;

import cn.bdqn.book.entity.User;
import cn.bdqn.book.util.HibernateUtil;

public class UserDAOImpl implements IUserDAO{

	private Logger logger=Logger.getLogger(UserDAOImpl.class);
	
	@Override
	public User getUser(String loginName) {
		User user=null;
		Session session=null;
		try {
			//session=HibernateUtil.getSession();
			session=HibernateUtil.getCurrentSession();
			user=(User)session.getNamedQuery("findUserByLoginName")
							  .setString("loginName", loginName)
							  .setCacheable(true)
							  .uniqueResult();
		} catch (Exception e) {
			logger.error("根据登录名查询用户时发生错误",e);
			throw new RuntimeException(e);
		}
		/*finally{
			session.close();
		}*/
		
		return user;
	}
	
	

}






