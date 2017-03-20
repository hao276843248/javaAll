package cn.bdqn.qbc.test;

import org.hibernate.Hibernate;
import org.hibernate.Session;

import cn.bdqn.qbc.entity.Brand;
import cn.bdqn.qbc.util.HibernateUtil;

public class h {
	public void huancun(){
		Session s1=HibernateUtil.getSession();
		Session s2=HibernateUtil.getSession();
		Session s3=HibernateUtil.getSession();
		Brand b1=(Brand) s1.get(Brand.class, 1l);

		
	}
}
