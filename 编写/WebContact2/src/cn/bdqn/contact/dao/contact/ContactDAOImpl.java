package cn.bdqn.contact.dao.contact;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.DistinctRootEntityResultTransformer;

import cn.bdqn.contact.entity.Contact;
import cn.bdqn.contact.util.HibernateUtil;
import cn.bdqn.contact.util.PageBean;

public class ContactDAOImpl implements IContactDAO {
	private Logger logger = Logger.getLogger(ContactDAOImpl.class);

	@Override
	public void addContact(Contact contact) {
		Session session =null;
		Transaction tx =null;
		try {
			session=HibernateUtil.getSession();
			tx=session.beginTransaction();
			session.save(contact);
			tx.commit();
		} catch (Exception e) {
			logger.error("�����ϵ��ʱ��������", e);
			tx.rollback();
			throw new RuntimeException(e);
		}finally{
			session.close();
		}

	}

	@Override
	public PageBean listContact(int pageIndex, int pageSize, String name,
			Integer uid, Integer gid) {
		PageBean pageBean = new PageBean();
		DetachedCriteria detCri= DetachedCriteria.forClass(Contact.class);
		detCri.createAlias("user","u");
		detCri.createAlias("group","g");
		if (name != null && !name.equals("")) {
			detCri.add(Restrictions.like("name", name, MatchMode.ANYWHERE));
		}
		if (uid != null ) {
			detCri.add(Restrictions.eq("u.id", uid));
		}
		if (gid != null ) {
			detCri.add(Restrictions.eq("g.id", gid));
		}
		Session session = null;
		try {
			session = HibernateUtil.getSession();
			Criteria criteria = detCri.getExecutableCriteria(session);
			// ��ѯ������
			criteria.setProjection(Projections.rowCount());
			int rowCount = ((Number) criteria.uniqueResult()).intValue();
			// ������ҳ��
			int pageCount = (rowCount % pageSize == 0) ? (rowCount / pageSize)
					: (rowCount / pageSize + 1);
			// ���㵱ǰҳ��һ���к�
			int firstResult = (pageIndex - 1) * pageSize;
			// ȡ��֮ǰ���õľۺϲ�ѯ
			criteria.setProjection(null);
			// ִ�з�ҳ�б��ѯ
			List<Contact> contacts =criteria
					.setFirstResult(firstResult)
					.setMaxResults(pageSize)
					.addOrder(Order.desc("id"))
					.setResultTransformer(DistinctRootEntityResultTransformer.INSTANCE)
					.list();
			
			pageBean.setPageIndex(pageIndex);
			pageBean.setPageSize(pageSize);
			pageBean.setRowCount(rowCount);
			pageBean.setPageCount(pageCount);
			pageBean.setResults(contacts);
			
		} catch (Exception e) {
			logger.error("��ѯ��ҳ��ϵ��ʱ��������",e);
			throw new RuntimeException(e);
		}finally{
			session.close();
		}
		
		return pageBean;
	}

	@Override
	public void updateContact(Contact contact) {
		Session session =null;
		Transaction tx =null;
		try {
			session=HibernateUtil.getSession();
			tx=session.beginTransaction();
			session.update(contact);
			tx.commit();
		} catch (Exception e) {
			logger.error("�޸���ϵ��ʱ��������",e);
			tx.rollback();
			throw new RuntimeException(e);
		}finally{
			session.close();
		}
		
	}

	@Override
	public Contact getContact(Integer id) {
		Contact contact =null;
		Session session =null;
		try {
			session=HibernateUtil.getSession();
			contact=(Contact)session.get(Contact.class,id);
			
		} catch (Exception e) {
			logger.error("����id��õ�����ϵ��ʱ��������",e);
			throw new RuntimeException(e);
		}finally{
			session.close();
		}
		return contact;
	}

	@Override
	public void deleteContact(Integer id) {
		Session session =null;
		Transaction tx =null;
		try {
			session=HibernateUtil.getSession();
			tx=session.beginTransaction();
			session.createQuery("delete from Contact where id=?")
					.setInteger(0, id)
					.executeUpdate();
			tx.commit();
			
		} catch (Exception e) {
			logger.error("ɾ����ϵ��ʱ��������", e);
			tx.rollback();
			throw new RuntimeException(e);
		}finally{
			session.close();
		}
		
	}

	@Override
	public List<Contact> findContact(Integer userId) {
		List<Contact> contacts =null;
		Session session =null;
		try {
			session=HibernateUtil.getSession();
			contacts=session.createQuery("from Contact where user.id=:userId")
					.setInteger("userId", userId)
					.list();
			
		} catch (Exception e) {
			logger.error("��ȡ��ϵ���б�ʱ��������", e);
			throw new RuntimeException(e);
		}finally{
			session.close();
		}
		return contacts;
	}

}
