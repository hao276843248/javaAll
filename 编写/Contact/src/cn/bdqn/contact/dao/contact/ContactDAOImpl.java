package cn.bdqn.contact.dao.contact;


import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.RowCountProjection;
import org.hibernate.transform.DistinctRootEntityResultTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import cn.bdqn.contact.entity.Contact;
import cn.bdqn.contact.util.HibernateUtil;
import cn.bdqn.contact.util.PageBean;

@Repository
public class ContactDAOImpl implements IContactDAO{


	private HibernateTemplate hibernateTemplate;
	
	@Autowired
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	@Override
	public void addContact(Contact contact) {
		hibernateTemplate.save(contact);
	}
	
	@Override
	public PageBean findContact(int pageIndex, int pageSize,Integer userId,Integer groupId,
			String name) {
		PageBean pageBean=new PageBean();
		
		DetachedCriteria detCri=DetachedCriteria.forClass(Contact.class);
		//创建别名
		detCri.createAlias("group","g");		
		detCri.add(Restrictions.eq("user.id",userId));
		
		//如果设置了有效的分组编号
		if(groupId!=null){
			detCri.add(Restrictions.eq("g.id", groupId));			
		}
		//如果设置了有效的联系人姓名
		if(StringUtils.isNotEmpty(name)){
			detCri.add(Restrictions.like("name",name,MatchMode.ANYWHERE));
		}
		
		detCri.setProjection(Projections.rowCount());
		int rowCount=((Number)hibernateTemplate.findByCriteria(detCri).get(0)).intValue();
		
			
		//计算总页数
		detCri.setProjection(Projections.rowCount());
		int pageCount=(rowCount%pageSize==0)?(rowCount/pageSize):(rowCount/pageSize+1);
		
		//计算当前页第一行行号
		int firstResult=(pageIndex-1)*pageSize;
		
		detCri.setProjection(null)				 
			  .addOrder(Order.desc("id"))
			  .setResultTransformer(DistinctRootEntityResultTransformer.INSTANCE);
			
		List<Contact> results=hibernateTemplate.findByCriteria(detCri, firstResult, pageSize);	  
		
		pageBean.setPageIndex(pageIndex);
		pageBean.setPageSize(pageSize);
		pageBean.setRowCount(rowCount);
		pageBean.setPageCount(pageCount);
		pageBean.setResults(results);
			
		return pageBean;
	}

	@Override
	public Contact getContact(Integer id) {
		return hibernateTemplate.get(Contact.class, id);
	}

	@Override
	public void updateContact(Contact contact) {
		hibernateTemplate.update(contact);
	}

	@Override
	public void deleteContact(Integer id) {
		hibernateTemplate.bulkUpdate("delete from Contact where id=?",id);
	}
	
	@Override
	public List<Contact> findContact(Integer userId) {
		return hibernateTemplate.find("from Contact where user.id=?",userId);
	}

	
	
}













