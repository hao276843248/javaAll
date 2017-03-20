package cn.hao.contact.dao.contact;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
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
import org.hibernate.transform.DistinctRootEntityResultTransformer;
import org.springframework.stereotype.Repository;

import sun.util.logging.resources.logging;

import cn.hao.contact.entity.Contact;
import cn.hao.contact.util.HibernateUtil;
import cn.hao.contact.util.PageBean;

@Repository("ic")
public class ContactDAOImpl implements IContactDAO{

	private Logger logger=Logger.getLogger(Contact.class);
	
	
	@Override
	public Contact getContact(int id) {
		Contact contact=null;
		Session session=null;
		try {
			session=HibernateUtil.getSession();
			contact=(Contact) session.get(Contact.class,id);
			
			/*String Sql="SELECT * FROM contact c INNER JOIN `group` g ON c.gid=g.id ORDER BY c.id where id=?";
			contact=(Contact) session.createSQLQuery(Sql);*/
						  
						   
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("获取用户信息时发生错误");
			
		}finally{
			session.close();
		}
		return contact;
	}

	@Override
	public PageBean listContact(Integer uid,Integer gid, String name,int pageIndex, int pageSize) {
		PageBean pageBean=new PageBean();
		
		DetachedCriteria detcri=DetachedCriteria.forClass(Contact.class);
		
		detcri.createAlias("group","g");
		detcri.createAlias("user", "u");
		
		if(StringUtils.isNoneEmpty(name)){
			detcri.add(Restrictions.like("name",name, MatchMode.ANYWHERE));
		}
		if(gid!=null){
			detcri.add(Restrictions.eq("g.id",gid));
		}
		detcri.add(Restrictions.eq("u.id",uid));
		
		Session session=null;
		try {
			session=HibernateUtil.getSession();
			Criteria criteria=detcri.getExecutableCriteria(session);
			
			criteria.setProjection(Projections.rowCount());
			int rowCount=((Number)criteria.uniqueResult()).intValue();
			
			int pageCount=(rowCount%pageSize==0)?(rowCount/pageSize):(rowCount/pageSize+1);
			int firstResult=(pageIndex-1)*pageSize;
			
			List<Contact> results=criteria.setProjection(null)
										 .setFirstResult(firstResult)
										 .setMaxResults(pageSize)
										 .addOrder(Order.desc("id"))
										 .setResultTransformer(DistinctRootEntityResultTransformer.INSTANCE)
										 .list();
			pageBean.setPageCount(pageCount);
			pageBean.setPageIndex(pageIndex);
			pageBean.setPageSize(pageSize);
			pageBean.setResults(results);
			pageBean.setRowCount(rowCount);
			
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("查询联系人分页列表时发生错误");
		}finally{
			session.close();
		}
		return pageBean;
	}

	@Override
	public void delete(int id) {
		Contact contact=null;
		Session session=null;
		Transaction tx=null;
		try {
			session=HibernateUtil.getSession();
			tx=session.beginTransaction();
			session.createQuery("delete from Contact where id=?")
				   .setInteger(0, id)
				   .executeUpdate();
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("删除用户信息时发生错误");
			tx.rollback();
			throw new RuntimeException(e);
		}finally{
			session.close();
		}
	}
	@Override
	public void addContact(Contact contact) {
		Session session=null;
		Transaction tx=null;
		try {
			session=HibernateUtil.getSession();
			tx=session.beginTransaction();
			session.save(contact);
			tx.commit();
		} catch (Exception e) {
			logger.error("保存联系人时发生错误");
			e.printStackTrace();
			tx.rollback();
			throw new RuntimeException(e);
		}finally{
			session.close();
		}
		
	}

	@Override
	public void updateContact(Contact contact) {
		Session session=null;
		Transaction tx=null;
		try {
			session=HibernateUtil.getSession();
			tx=session.beginTransaction();
			session.update(contact);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("更改联系人时发生错误");
			tx.rollback();
			throw new RuntimeException(e);
		}finally{
			session.close();
		}
	}

	@Override
	public List<Contact> findContact(Integer userId) {
		Session session=null;
		List<Contact> cs=null;
		try {
			session=HibernateUtil.getSession();
			
			/*session=HibernateUtil.getSession();
			contacts=session.createQuery("from Contact where user.id=:userId")
							.setInteger("userId",userId)
							.list();*/
			
			DetachedCriteria detCriteria=DetachedCriteria.forClass(Contact.class);
			detCriteria.add(Restrictions.eq("user.id", userId));
			Criteria criteria=detCriteria.getExecutableCriteria(session);
			cs=criteria.addOrder(Order.desc("id")).list();
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("导出联系人时发生错误");
			throw new RuntimeException(e);
		}finally{
			session.close();
		}
		return cs;
	}

}
