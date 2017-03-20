package lvyou.dao.impl;

import java.sql.SQLException;
import java.util.List;

import lvyou.dao.BaomingDao;
import lvyou.model.Baoming;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;






public class BaomingDaoImpl extends HibernateDaoSupport implements  BaomingDao{
	
	
	

	public void deleteBean(Baoming bean) {
		this.getHibernateTemplate().delete(bean);
		
	}

	public void insertBean(Baoming bean) {
		this.getHibernateTemplate().save(bean);
		
	}

	@SuppressWarnings("unchecked")
	public Baoming selectBean(String where) {
		List<Baoming> list = this.getHibernateTemplate().find("from Baoming " +where);
		if(list.size()==0){
			return null;
		}
		return list.get(0);
	}

	public int selectBeanCount(String where) {
		long count = (Long)this.getHibernateTemplate().find("select count(*) from Baoming "+where).get(0);
		return (int)count;
	}

	@SuppressWarnings("unchecked")
	public List<Baoming> selectBeanList(final int start,final int limit,final String where) {
		return (List<Baoming>)this.getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(final Session session)throws HibernateException, SQLException {				
				List<Baoming> list = session.createQuery("from Baoming "+where)
				.setFirstResult(start)
				.setMaxResults(limit)
				.list();
				return list;
			}
		});
	}

	public void updateBean(Baoming bean) {
		this.getHibernateTemplate().update(bean);
		
	}
	
	
}
