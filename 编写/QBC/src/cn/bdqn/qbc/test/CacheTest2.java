package cn.bdqn.qbc.test;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.junit.Test;

import cn.bdqn.qbc.entity.Brand;
import cn.bdqn.qbc.util.HibernateUtil;

public class CacheTest2 {

	@Test
	public void testListBrand(){
		Session session=HibernateUtil.getSession();
		//当执行iterate()方法时，不会获取所有数据，而是只获得所有的对象编号
		Iterator<Brand> it=session.createQuery("from Brand order by id").iterate();
		
		while(it.hasNext()){
			Brand brand=it.next();
			//当需要加载数据时，首先在缓存中查找有没有对应的对象，如果没有，则执行一次根据id加载单个对象的查询
			//如果缓存是空的，使用itrerate()查询和遍历数据将导致1+N次查询
			System.out.println(brand.getName());
		}
		
		
		Iterator<Brand> it2=session.createQuery("from Brand order by id").iterate();
		
		
		while(it2.hasNext()){			
			Brand brand=it2.next();
			//如果缓存中有对应的对象，则直接返回缓存中的数据，不再执行查询
			System.out.println(brand.getName());
		}
		
		
		session.close();
		
	}
	
	@Test
	public void testListBrand2(){
		Session session1=HibernateUtil.getSession();
		Session session2=HibernateUtil.getSession();
		//使用list()方法会立即执行查询加载数据，被加载进来的数据会被放入缓存
		//如果启用了查询缓存，语句对应的查询结果也会被存入查询缓存
		List<Brand> brands1=session1.createQuery("from Brand order by id").setCacheable(true).list();
		
		for(Brand brand:brands1){
			System.out.println(brand.getName());
		}
		
		//在没有启用查询缓存的情况下，list()方法不管缓存中有没有数据，总是立即执行查询加载数据
		//如果启用了查询缓存，第二次使用相同的语句执行查询时，如果查询缓存中有对应的记录，就不再执行查询，直接返回查询缓存中的结果
		List<Brand> brands2=session2.createQuery("from Brand order by id").setCacheable(true).list();
		
		for(Brand brand:brands2){
			System.out.println(brand.getName());
		}
		
		//当执行iterate()方法时，不会获取所有数据，而是只获得所有的对象编号
		Iterator<Brand> it=session2.createQuery("from Brand order by id").iterate();
		
		while(it.hasNext()){
			Brand brand=it.next();
			//当需要加载数据时，首先在缓存中查找有没有对应的对象，如果没有，则执行一次根据id加载单个对象的查询
			//如果缓存是空的，使用itrerate()查询和遍历数据将导致1+N次查询
			System.out.println(brand.getName());
		}
		
		session1.close();
		session2.close();
	}
	
	
	
}






