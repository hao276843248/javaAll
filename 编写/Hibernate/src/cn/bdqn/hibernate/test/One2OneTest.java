package cn.bdqn.hibernate.test;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import cn.bdqn.hibernate.entity.Content;
import cn.bdqn.hibernate.entity.Stat;
import cn.bdqn.hibernate.util.HibernateUtil;

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

	//���Լ�������
	@Test
	public void testGetContent(){
		Content content=null;
		Session session=null;
		try {
			session=HibernateUtil.getSession();
			content=(Content)session.get(Content.class,1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			session.close();
		}
		
		System.out.println(content.getTitle());
		System.out.println(content.getContent());
		System.out.println(content.getStat().getVisit());
		
	}

	//���Լ���ͳ��
	@Test
	public void testGetStat(){
		Stat stat=null;
		Session session=null;
		try {
			session=HibernateUtil.getSession();
			stat=(Stat)session.get(Stat.class,1);			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			session.close();
		}
		System.out.println(stat.getVisit());
	}
	
	
	//��ѯ�����б�
	@Test
	public void testListContent(){
		List<Content> contents=null;
		Session session=null;
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
		
		for(Content content:contents){
			System.out.println(content.getTitle()+"\t"+content.getContent()+"\t"+content.getStat().getVisit());
		}
		
		
	}

	//��ѯͳ�Ʊ�
	@Test
	public void testListStat(){
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













