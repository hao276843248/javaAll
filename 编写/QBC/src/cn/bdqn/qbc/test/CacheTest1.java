package cn.bdqn.qbc.test;

import org.hibernate.Session;
import org.hibernate.cache.EhCacheProvider;
import org.junit.Test;

import cn.bdqn.qbc.entity.Brand;
import cn.bdqn.qbc.util.HibernateUtil;

public class CacheTest1 {

	@Test
	public void testGetBrand(){
		//������ÿ��Session�����ڶ���һ��������һ������
		Session s1=HibernateUtil.getSession();
		Session s2=HibernateUtil.getSession();
		
		//��session�ϵ�һ�ε���get������������ʱ��
		//���ڻ����ǿյģ�������ִ��SELECT����������
		//Ȼ�󽫼��ص����ݴ���һ������,ͬʱ��һ�����������������
		Brand b1=(Brand)s1.get(Brand.class,1L);
		//����ͬһ��session�ϵڶ��ε���get��������ʱ
		//����һ���������Ѿ����ڶ�Ӧ�Ķ��󣬲����ٴ�ִ��SELECT��ѯ
		//ֱ�ӷ��ر�����Ķ��������
		Brand b2=(Brand)s1.get(Brand.class,1L);
		System.out.println("b1==b2?"+(b1==b2));
		
		//�ڲ�ͬ��session�л���Ķ����ܹ���
		//��s2��ִ��getʱ�����ܹ���s1�л���Ķ���
		//��һ��������û���ҵ�����ʱ����������˶������棬���һ��������������ȥ��
		//����ڶ����������ҵ��˶����򷵻ض��������
		Brand b3=(Brand)s2.get(Brand.class,1L);
		System.out.println("b3==b1?"+(b3==b1));
		
		s1.close();
		s2.close();
		
	
		
		
	}
	
}












