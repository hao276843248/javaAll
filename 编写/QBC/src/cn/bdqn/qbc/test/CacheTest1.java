package cn.bdqn.qbc.test;

import org.hibernate.Session;
import org.hibernate.cache.EhCacheProvider;
import org.junit.Test;

import cn.bdqn.qbc.entity.Brand;
import cn.bdqn.qbc.util.HibernateUtil;

public class CacheTest1 {

	@Test
	public void testGetBrand(){
		//创建的每个Session对象内都有一个独立的一级缓存
		Session s1=HibernateUtil.getSession();
		Session s2=HibernateUtil.getSession();
		
		//在session上第一次调用get方法加载数据时，
		//由于缓存是空的，会立即执行SELECT语句加载数据
		//然后将加载的数据存入一级缓存,同时将一个副本存入二级缓存
		Brand b1=(Brand)s1.get(Brand.class,1L);
		//当在同一个session上第二次调用get加载数据时
		//由于一级缓存中已经存在对应的对象，不会再次执行SELECT查询
		//直接返回被缓存的对象的引用
		Brand b2=(Brand)s1.get(Brand.class,1L);
		System.out.println("b1==b2?"+(b1==b2));
		
		//在不同的session中缓存的对象不能共享
		//在s2上执行get时，不能共享s1中缓存的对象
		//在一级缓存中没有找到对象时，如果启用了二级缓存，会进一步到二级缓存中去找
		//如果在二级缓存中找到了对象，则返回对象的引用
		Brand b3=(Brand)s2.get(Brand.class,1L);
		System.out.println("b3==b1?"+(b3==b1));
		
		s1.close();
		s2.close();
		
	
		
		
	}
	
}












