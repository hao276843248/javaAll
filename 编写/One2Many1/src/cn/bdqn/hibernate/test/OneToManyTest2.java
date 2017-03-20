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

	//ʹ���������Ӳ�ѯ���س����缰�������ͼ�����
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
	
	//ʹ�������������Ӳ�ѯ�����缰�������ͼ�����(ͨ��Set����ȥ�ظ���)
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
	
	//ʹ�������������Ӳ�ѯ�����缰�������ͼ�����(ͨ�������ת����ȥ�ظ���)
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

	//����id��ȡ������
	@Test
	public void testGetPublisher(){
		Publisher publisher=null;
		Session session=null;
		try {
			session=HibernateUtil.getSession();
			publisher=(Publisher)session.get(Publisher.class,1);		
			//�ж϶���򼯺��Ƿ�����ɳ�ʼ��
			if(Hibernate.isInitialized(publisher.getBooks())){
				//��ʼ��������ͼ�鼯��
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






