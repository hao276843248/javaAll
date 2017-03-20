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
		//��ִ��iterate()����ʱ�������ȡ�������ݣ�����ֻ������еĶ�����
		Iterator<Brand> it=session.createQuery("from Brand order by id").iterate();
		
		while(it.hasNext()){
			Brand brand=it.next();
			//����Ҫ��������ʱ�������ڻ����в�����û�ж�Ӧ�Ķ������û�У���ִ��һ�θ���id���ص�������Ĳ�ѯ
			//��������ǿյģ�ʹ��itrerate()��ѯ�ͱ������ݽ�����1+N�β�ѯ
			System.out.println(brand.getName());
		}
		
		
		Iterator<Brand> it2=session.createQuery("from Brand order by id").iterate();
		
		
		while(it2.hasNext()){			
			Brand brand=it2.next();
			//����������ж�Ӧ�Ķ�����ֱ�ӷ��ػ����е����ݣ�����ִ�в�ѯ
			System.out.println(brand.getName());
		}
		
		
		session.close();
		
	}
	
	@Test
	public void testListBrand2(){
		Session session1=HibernateUtil.getSession();
		Session session2=HibernateUtil.getSession();
		//ʹ��list()����������ִ�в�ѯ�������ݣ������ؽ��������ݻᱻ���뻺��
		//��������˲�ѯ���棬����Ӧ�Ĳ�ѯ���Ҳ�ᱻ�����ѯ����
		List<Brand> brands1=session1.createQuery("from Brand order by id").setCacheable(true).list();
		
		for(Brand brand:brands1){
			System.out.println(brand.getName());
		}
		
		//��û�����ò�ѯ���������£�list()�������ܻ�������û�����ݣ���������ִ�в�ѯ��������
		//��������˲�ѯ���棬�ڶ���ʹ����ͬ�����ִ�в�ѯʱ�������ѯ�������ж�Ӧ�ļ�¼���Ͳ���ִ�в�ѯ��ֱ�ӷ��ز�ѯ�����еĽ��
		List<Brand> brands2=session2.createQuery("from Brand order by id").setCacheable(true).list();
		
		for(Brand brand:brands2){
			System.out.println(brand.getName());
		}
		
		//��ִ��iterate()����ʱ�������ȡ�������ݣ�����ֻ������еĶ�����
		Iterator<Brand> it=session2.createQuery("from Brand order by id").iterate();
		
		while(it.hasNext()){
			Brand brand=it.next();
			//����Ҫ��������ʱ�������ڻ����в�����û�ж�Ӧ�Ķ������û�У���ִ��һ�θ���id���ص�������Ĳ�ѯ
			//��������ǿյģ�ʹ��itrerate()��ѯ�ͱ������ݽ�����1+N�β�ѯ
			System.out.println(brand.getName());
		}
		
		session1.close();
		session2.close();
	}
	
	
	
}






