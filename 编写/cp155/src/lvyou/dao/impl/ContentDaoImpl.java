package lvyou.dao.impl;

import java.sql.SQLException;
import java.util.List;

import lvyou.dao.ContentDao;
import lvyou.model.Content;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;






public class ContentDaoImpl extends HibernateDaoSupport implements  ContentDao{
	
	
	

	public void deleteBean(Content bean) {
		this.getHibernateTemplate().delete(bean);
		
	}

	public void insertBean(Content bean) {
		this.getHibernateTemplate().save(bean);
		
	}

	@SuppressWarnings("unchecked")
	public Content selectBean(String where) {
		List<Content> list = this.getHibernateTemplate().find("from Content " +where);
		if(list.size()==0){
			return null;
		}
		return list.get(0);
	}

	public int selectBeanCount(String where) {
		long count = (Long)this.getHibernateTemplate().find("select count(*) from Content "+where).get(0);
		return (int)count;
	}

	@SuppressWarnings("unchecked")
	public List<Content> selectBeanList(final int start,final int limit,final String where) {
		return (List<Content>)this.getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(final Session session)throws HibernateException, SQLException {				
				List<Content> list = session.createQuery("from Content "+where)
				.setFirstResult(start)
				.setMaxResults(limit)
				.list();
				return list;
			}
		});
	}

	public void updateBean(Content bean) {
		this.getHibernateTemplate().update(bean);
		
	}
	
	
}
