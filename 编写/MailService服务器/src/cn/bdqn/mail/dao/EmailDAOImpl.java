package cn.bdqn.mail.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import cn.bdqn.mail.entity.Email;
import cn.bdqn.mail.entity.User;

@Repository("emailDAO")
public class EmailDAOImpl implements IEmailDAO {
	
	private HibernateTemplate hibernateTemplate;
	
	@Autowired
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
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
	public void saveEmail(Email email) {
		hibernateTemplate.save(email);
	}

	@Override
	public List<Email> findEmail(Integer send) {
		return hibernateTemplate.find("from Email where send=?",send);
	}

	@Override
	public void updateSend(Integer id) {
		hibernateTemplate.bulkUpdate("update Email set send=1 where id=?",id);
	}

	@Override
	public void deleteEmail(Integer id) {
		hibernateTemplate.bulkUpdate("delete Email where id=?",id);
	}

	@Override
	public void updateSending() {
		hibernateTemplate.bulkUpdate("update Email set send=2 where send=0");
	}
	
	

}
