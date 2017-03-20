package cn.bdqn.contact.dao.group;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;


import cn.bdqn.contact.entity.Group;
import cn.bdqn.contact.util.HibernateUtil;

@Repository
public class GroupDAOImpl implements IGroupDAO{
	
	private HibernateTemplate hibernateTemplate;
	
	@Autowired
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	@Override
	public List<Group> findGroup() {
		return hibernateTemplate.find("from Group order by id");
	}

}
