package cn.hao.nt.test;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import cn.hao.nt.entity.Content;
import cn.hao.nt.entity.Stat;
import cn.hao.nt.util.HibernateUtil;

public class One2OneTest {

	//���Ա�������
	@Test
	public void testSaveContent(){
		Content content=new Content();
		content.setTitle("���Ա���1");
		content.setContent("��������1");
		
		Session session=null;
		Transaction tx=null;
		try {
			session=HibernateUtil.getSession();
			tx=session.beginTransaction();
			session.save(content);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
		finally{
			session.close();
		}
	}

	//���Ա���ͳ��
	@Test
	public void testSaveStat(){
		Stat stat=new Stat();
		Content content=new Content();
		content.setId(1);
		stat.setVisit(0);
		stat.setContent(content);
		
		Session session=null;
		Transaction tx=null;
		try {
			session=HibernateUtil.getSession();
			tx=session.beginTransaction();
			session.save(stat);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
		finally{
			session.close();
		}
	}
	
	//���Լ����������ݺ�ͳ��
	@Test
	public void testSaveContentAndStat(){
		Content content=new Content();
		content.setTitle("���Ա���2");
		content.setContent("��������2");
		
		Stat stat=new Stat();
		stat.setVisit(0);
		
		content.setStat(stat);
		stat.setContent(content);

		Session session=null;
		Transaction tx=null;
		try {
			session=HibernateUtil.getSession();
			tx=session.beginTransaction();
			session.save(content);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
		finally{
			session.close();
		}

		
	}
	
	
	@Test
	public void testlistcontent(){
		List<Content> contents=null;
		Session session=null;
		Transaction tx=null;
		try {
			session=HibernateUtil.getSession();

			contents=session.createQuery("from Content c left join fetch c.stat order by c.id")
				    .list();
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		finally{
			session.close();
		}
		for(Content c:contents){
			System.out.println(c.getTitle()+"/t"+c.getContent());
		}

	}
	
	@Test
	public void testgetContent(){
		Content contents=null;
		Session session=null;
		Transaction tx=null;
		try {
			session=HibernateUtil.getSession();

			contents=(Content)session.get(Content.class, 1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			session.close();
		}
		System.out.println(contents.getTitle());
		//for(Content c:contents){
			//System.out.println(c.getTitle()+"/t"+c.getContent());
		//}
	}

	@Test
	public void tegstsContentHQL(){
		Content contents=null;
		Session session=null;
		try {
			session=HibernateUtil.getSession();

			contents=(Content)session.get(Content.class, 1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			session.close();
		}
		System.out.println(contents.getTitle());
	}

	@Test
	public void testStatlist(){
		List<Stat> stats=null;
		Session session=null;
		try {
			session=HibernateUtil.getSession();
			stats=session.createQuery("from Stat s inner join fetch s.content order by s.id")
						 .list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			session.close();
		}
		
		for(Stat stat:stats){
			System.out.println(stat.getVisit()+"\t"+stat.getContent().getTitle()+"\t"+stat.getContent().getContent());
		}
	}
	
}













