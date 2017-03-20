package cn.hao.hql.test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.transform.AliasToBeanConstructorResultTransformer;
import org.hibernate.transform.AliasToEntityMapResultTransformer;
import org.hibernate.type.DoubleType;
import org.hibernate.type.IntegerType;
import org.hibernate.type.Type;
import org.junit.Test;

import cn.hao.hql.entity.Camera;
import cn.hao.hql.util.HibernateUtil;

public class HplTest {
	
	@Test
	public void findCamera(){
		Session s=null;
		List<Camera> cs=null;
		try {
			s=HibernateUtil.getSession();
			cs=s.createQuery("from Camera order by id").list();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			s.close();
		}
		for(Camera c:cs){
			System.out.println(c.getTitle());
		}
	}
	
	@Test
	//带条件查询
	public void TJCamera(){
		Session session=null;
		List<Camera> cs=null;
		try {
			session=HibernateUtil.getSession();
			//问号绑定
			//String hql="from Camera where price<? and pixel>? order by price";
			//Query query=session.createQuery(hql);
			//query.setDouble(0, 2000D);
			//query.setInteger(1,1200);
			//批量绑定参数
			//query.setParameters(new Object[]{2000D,1200},
			//		new Type[]{DoubleType.INSTANCE,IntegerType.INSTANCE} );
			
			//名字绑定
			String hql="from Camera where price<:price and pixel>:pixel order by price";
			Query query=session.createQuery(hql);
			//query.setDouble("price", 2000D);
			//query.setInteger("pixel",1200);
			
			//批量绑定参数1
			Map<String ,Object> m=new HashMap<String, Object>();
			m.put("price", 2000D);
			m.put("pixel",1200);
			query.setProperties(m);
			//批量绑定参数2
			//Camera m=new Camera();
			//m.setPixel(1200);
			//m.setPrice(2000D);
			//query.setProperties(m);
			cs=query.list();
		
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
		}
		for(Camera c:cs){
			
			System.out.print(c.getTitle());
			System.out.print("    "+c.getPixel());
			System.out.println("    "+c.getPrice());
			System.out.println("---------");
		}
	}

	@Test
	public void TouYingCamera(){
		Session session=null;
		List<Object[]> rows=null;
		try {
			session=HibernateUtil.getSession();
			rows=session.createQuery("Select title,price,pixel from Camera order by id").list();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			session.close();
		}
		for(Object[] row:rows){
			String title=(String)row[0];
			Double price=(Double)row[1];
			int pixel=(Integer)row[2];
			System.out.print(title);
			System.out.print("   "+price);
			System.out.println("   "+pixel);	
			System.out.println("---------------");
		}
	}
	
	@Test
	public void TouYingCamera2(){
		Session session=null;
		List<Camera> rows=null;
		try {
			session=HibernateUtil.getSession();
			Query q=session.createQuery("Select new Camera(title,pixel,price) from Camera where price<:price and pixel<:pixel order by id");
			Camera c=new Camera(null, 1200, 100D);
			q.setProperties(c);
			rows=q.list();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
		}
		for(Camera row:rows){
			System.out.print(row.getTitle());
			System.out.print("   "+row.getPrice());
			System.out.println("   "+row.getPixel());	
			System.out.println("---------------");
		}
	}

	@Test
	public void juhehanshuCamera(){
		Map<String, Object> m=null;
		Session s=null;
		try {
			s=HibernateUtil.getSession();
			m=(Map<String, Object>)s.createQuery("Select count(*) as rowCount,min(price) as min,max(price) as max,avg(price) as avg from Camera ")
					.setResultTransformer(AliasToEntityMapResultTransformer.INSTANCE)
					.uniqueResult();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			s.close();
		}
		System.out.println(m);
	}
	
	@Test
	public void juhehanshuCamera2(){
		long rowCount=0;
		Session s=null;
		try {
			s=HibernateUtil.getSession();
			rowCount=(Long)s.createQuery("Select count(*) from Camera ").uniqueResult();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			s.close();
		}
		System.out.println(rowCount);
	}
}














