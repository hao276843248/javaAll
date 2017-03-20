package cn.hao.Hbook.test;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import cn.hao.Hbook.entity.Publisher;
import cn.hao.Hbook.util.HibernateUtil;

public class TestBook {
	@Test 
	public void addPublisher(){
		Session s=null;
		Publisher p=new Publisher("������ѧ������");
		Transaction tx=null;
		try {
			s=HibernateUtil.getSession();
			tx=s.beginTransaction();
			s.save(p);
			tx.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
			// TODO: handle exception
		}finally{
			s.close();
		}
	}
}
