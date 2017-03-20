package cn.bdqn.qbc.test;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;

import cn.bdqn.qbc.entity.Brand;
import cn.bdqn.qbc.entity.Camera;
import cn.bdqn.qbc.util.HibernateUtil;

public class QBCTest1 {

	//��ѯȫ��Ʒ���б�,����Ʒ�Ʊ����������
	@Test
	public void testListBrand(){
		List<Brand> brands=null;
		Session session=null;
		try {
			session=HibernateUtil.getSession();
			//from Brand order by id
			//�������Brand�����������
			//Criteria criteria=session.createCriteria(Brand.class);
			//����������򣬸���id������������
			//Order order=Order.asc("id");
			//�����������ӵ�����������
			//criteria.addOrder(order);			
			//ִ�в�ѯ����ý���б�
			//brands=criteria.list();
			
			brands=session.createCriteria(Brand.class)
						  .addOrder(Order.asc("id"))
						  .list();
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			session.close();
		}
		for(Brand brand:brands){
			System.out.println(brand.getName());
		}
	}
	
	//��ѯ�۸���2000Ԫ���£�������������1200�����ϵ���������ռ۸���������
	@Test
	public void testListCamera(){
		List<Camera> cameras=null;
		Session session=null;
		try {
			session=HibernateUtil.getSession();
			//from Camera where price<2000 and pixel>1200 order by price
			
			//�������Camera�����������
			//Criteria criteria=session.createCriteria(Camera.class);
			//������ʾ���۸���2000Ԫ���¡�����������
			//Criterion c1=Restrictions.lt("price",2000d);
			//������ʾ��������1200�����ϡ�����������
			//Criterion c2=Restrictions.gt("pixel",1200);
			//��װ��ѯ����,ʹ��add������ӵ�����Ĭ����"and"������һ��
			//criteria.add(c1);
			//criteria.add(c2);
			//����������
			//criteria.addOrder(Order.asc("price"));
			//ִ�в�ѯ����ý���б�
			//cameras=criteria.list();	
			
			cameras=session.createCriteria(Camera.class)
						   .add(Restrictions.lt("price",2000d))
						   .add(Restrictions.gt("pixel",1200))
						   .addOrder(Order.asc("price"))
						   .list();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			session.close();
		}
		for(Camera camera:cameras){
			System.out.println(camera.getTitle()+"\t"+camera.getPixel()+"\t"+camera.getPrice());
		}
	}
	
	//��ѯ�۸���2000Ԫ���£�������������1200�����ϵ������������������������
	@Test
	public void testListCamera2(){
		List<Camera> cameras=null;
		Session session=null;
		try {
			session=HibernateUtil.getSession();
			//from Camera where price<2000 or pixel>1200 order by price
			
			//�������Camera�����������
			//Criteria criteria=session.createCriteria(Camera.class);
			//������ʾ���۸���2000Ԫ���¡�����������
			//Criterion c1=Restrictions.lt("price",2000d);
			//������ʾ��������1200�����ϡ�����������
			//Criterion c2=Restrictions.gt("pixel",1200);
			//��"or"�����������
			//Criterion or=Restrictions.or(c1,c2);
			//�������
			//criteria.add(or);
			//�����������
			//criteria.addOrder(Order.desc("pixel"));
			//ִ�в�ѯ����ý���б�
			//cameras=criteria.list();
			
			cameras=session.createCriteria(Camera.class)
						   .add(
								Restrictions.or(
								   Restrictions.lt("price",2000d), 
								   Restrictions.gt("pixel",1200)
								)
							)
						   .addOrder(Order.desc("pixel"))
						   .list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			session.close();
		}
		for(Camera camera:cameras){
			System.out.println(camera.getTitle()+"\t"+camera.getPixel()+"\t"+camera.getPrice());
		}
	}
	
	//��ѯ�۸���2000Ԫ���£�������������1200�����ϵ���������߹�ѧ�佹������10�����ϣ�������������������
	@Test
	public void testListCamera3(){
		List<Camera> cameras=null;
		Session session=null;
		try {
			session=HibernateUtil.getSession();
			//from Camera where price<2000 or pixel>1200 order by price
			
			//�������Camera�����������
			Criteria criteria=session.createCriteria(Camera.class);
			//������ʾ���۸���2000Ԫ���¡�����������
			Criterion c1=Restrictions.lt("price",2000d);
			//������ʾ��������1200�����ϡ�����������
			Criterion c2=Restrictions.gt("pixel",1200);
			//������ʾ����ѧ�佹������10�����ϡ�����������
			Criterion c3=Restrictions.gt("zoom",10d);
			
			//����Ĭ��ʹ�á�or�����ӵ���������
			Disjunction disj=Restrictions.disjunction();
			disj.add(c1);
			disj.add(c2);
			disj.add(c3);
			
					
			//�������
			criteria.add(disj);
			//�����������
			criteria.addOrder(Order.desc("pixel"));
			//ִ�в�ѯ����ý���б�
			cameras=criteria.list();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			session.close();
		}
		for(Camera camera:cameras){
			System.out.println(camera.getTitle()+"\t"+camera.getPixel()+"\t"+camera.getPrice());
		}
	}
		
	//�۸���2000Ԫ��������������1200�����ϣ����߹�ѧ�佹������10��������Ʒ�Ʊ��Ϊ3������б�
	@Test
	public void testListCamera4(){
		List<Camera> cameras=null;
		Session session=null;
		try {
			session=HibernateUtil.getSession();
			//from Camera where (price<2000 or pixel>1200) or (zoom>10 and brand.id=3) order by price
			
			//�������Camera�����������
			Criteria criteria=session.createCriteria(Camera.class);
			//������ʾ���۸���2000Ԫ���¡�����������
			Criterion c1=Restrictions.lt("price",2000d);
			//������ʾ��������1200�����ϡ�����������
			Criterion c2=Restrictions.gt("pixel",1200);
			//������ʾ����ѧ�佹������10�����ϡ�����������
			Criterion c3=Restrictions.gt("zoom",10d);
			//������ʾ��Ʒ�Ʊ��Ϊ3������������
			Criterion c4=Restrictions.eq("brand.id",3L);
			//��and��װc1��c2
			Criterion and1=Restrictions.and(c1,c2);
			//��and��װc3��c4
			Criterion and2=Restrictions.and(c3,c4);
			//ʹ��or����and1��and2
			Criterion or=Restrictions.or(and1,and2);
		
			criteria.add(or);
			
			//�����������
			criteria.addOrder(Order.desc("pixel"));
			//ִ�в�ѯ����ý���б�
			cameras=criteria.list();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			session.close();
		}
		for(Camera camera:cameras){
			System.out.println(camera.getTitle()+"\t"+camera.getPixel()+"\t"+camera.getPrice());
		}
	}
	
}









