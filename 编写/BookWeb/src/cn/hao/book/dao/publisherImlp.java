package cn.hao.book.dao;

import java.util.List;

import org.hibernate.Session;

import cn.hao.book.entity.Publisher;
import cn.hao.book.util.HibernateUtil;

public class publisherImlp implements Ipublisher{

	@Override
	public List<Publisher> findpublisher() {
		Session s=null;
		List<Publisher> ps=null;
		try {
			//s=HibernateUtil.getSession();
			s=HibernateUtil.getCurrentSession();
			ps=s.createQuery("from Publisher order by id")
					.setCacheable(true)
					.list();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}/*finally{
			s.close();
		}*/
		return ps;
		
	}

}
