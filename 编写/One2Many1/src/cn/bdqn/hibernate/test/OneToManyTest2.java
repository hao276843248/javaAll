package cn.bdqn.hibernate.test;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.transform.DistinctRootEntityResultTransformer;
import org.junit.Test;

import cn.bdqn.hibernate.entity.Book;
import cn.bdqn.hibernate.entity.Publisher;
import cn.bdqn.hibernate.util.HibernateUtil;

public class OneToManyTest2 {

	//使用左外连接查询加载出版社及其关联的图书对象
	@Test
	public void testLeftJoin(){
		List<Object[]> rows=null;
		Session session=null;
		try {
			session=HibernateUtil.getSession();
			String hql="from Publisher p left join p.books order by p.id";
			rows=session.createQuery(hql).list();			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			session.close();
		}
		
		for (Object[] row:rows) {
			Publisher publisher=(Publisher)row[0];
			Book book=(Book)row[1];
			
			System.out.println(publisher.getName()+"\t"+book.getTitle());
			
		}
	}
	
	//使用迫切左外联接查询出版社及其关联的图书对象(通过Set集合去重复项)
	@Test
	public void testLeftJoinFetch(){
		List<Publisher> publishers=null;
		Session session=null;
		try {
			session=HibernateUtil.getSession();
			String hql="from Publisher p left join fetch p.books order by p.id";
			publishers=session.createQuery(hql).list();			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			session.close();
		}
		Set<Publisher> set=new LinkedHashSet<Publisher>(publishers);
		
		for(Publisher publisher:set){
			System.out.println(publisher.getName());
			for(Book book:publisher.getBooks()){
				System.out.println(book.getTitle());
			}
			System.out.println("-----------------");
		}		
	}
	
	//使用迫切左外联接查询出版社及其关联的图书对象(通过结果集转换器去重复项)
	@Test
	public void testLeftJoinFetch2(){
		List<Publisher> publishers=null;
		Session session=null;
		try {
			session=HibernateUtil.getSession();
			String hql="from Publisher p left join fetch p.books order by p.id";
			publishers=session.createQuery(hql)
							  .setResultTransformer(DistinctRootEntityResultTransformer.INSTANCE)
							  .list();			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			session.close();
		}
		
		for(Publisher publisher:publishers){
			System.out.println(publisher.getName());
			for(Book book:publisher.getBooks()){
				System.out.println(book.getTitle());
			}
			System.out.println("-----------------");
		}		
	}

	//根据id获取出版社
	@Test
	public void testGetPublisher(){
		Publisher publisher=null;
		Session session=null;
		try {
			session=HibernateUtil.getSession();
			publisher=(Publisher)session.get(Publisher.class,1);		
			//判断对象或集合是否已完成初始化
			if(Hibernate.isInitialized(publisher.getBooks())){
				//初始化关联的图书集合
				Hibernate.initialize(publisher.getBooks());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			session.close();
		}
		System.out.println(publisher.getId());
		System.out.println(publisher.getName());
		
		for(Book book:publisher.getBooks()){
			System.out.println(book.getTitle());
		}

	}
}






