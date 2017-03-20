package cn.bdqn.contact.dao.user;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import cn.bdqn.contact.entity.User;
import cn.bdqn.contact.util.HibernateUtil;

@Repository("userDAO")
public class UserDAOImpl implements IUserDAO{
	
	private HibernateTemplate hibernateTemplate;
	
	@Autowired
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	
	@Override
	public void addUser(User user) {
		hibernateTemplate.save(user);
	}

	@Override
	public User getUser(String userName) {
		
		List<User> users=hibernateTemplate.find("from User where userName=?",userName);
		if(users.size()>0){
			return users.get(0);
		}
		
		return null;
		
	}
	
	@Override
	public void updatePassword(Integer userId, String newPwd) {
		hibernateTemplate.bulkUpdate("update User set password=? where id=?",newPwd,userId);		
	}
	

}
