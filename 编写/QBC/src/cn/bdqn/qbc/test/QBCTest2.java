package cn.bdqn.qbc.test;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.DistinctRootEntityResultTransformer;
import org.junit.Test;

import cn.bdqn.qbc.entity.Camera;
import cn.bdqn.qbc.entity.Types;
import cn.bdqn.qbc.util.HibernateUtil;

public class QBCTest2 {
	//��ѯ�������༰����������,������������
	@Test
	public void testListType(){
		List<Types> types=null;
		Session session=null;
		try {
			session=HibernateUtil.getSession();
			//�������Type�����������
			Criteria criteria=session.createCriteria(Types.class);
			//���ü������Ե�ץȡ��ʽΪʹ�����Ӳ�ѯ����
			criteria.setFetchMode("cameras",FetchMode.JOIN);			
			//�����������
			criteria.addOrder(Order.asc("id"));
			//���ý����ת����
			criteria.setResultTransformer(DistinctRootEntityResultTransformer.INSTANCE);
			types=criteria.list();			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			session.close();
		}
		for(Types type:types){
			System.out.println(type.getName());
			System.out.println("--------------------");
			Set<Camera> cameras=type.getCameras();
			for(Camera camera:cameras){
				System.out.println(camera.getTitle());
			}
			System.out.println();
		}
		
		
	}

	//��ѯ������������Ʒ�ƺͷ���
	@Test
	public void testListCamera(){
		List<Camera> cameras=null;
		Session session=null;
		try {
			session=HibernateUtil.getSession();
			//�������Camera�����������
			Criteria criteria=session.createCriteria(Camera.class);
			//Ϊ�������Դ���������ʵ�����Ӳ�ѯ
			criteria.createAlias("types","t");
			criteria.createAlias("brand","b");
			
			//�������
			criteria.add(Restrictions.eq("b.id",3L));
			
			//�����������
			criteria.addOrder(Order.asc("id"));
			
			cameras=criteria.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			session.close();
		}
		
		for(Camera camera:cameras){
			System.out.print(camera.getTypes().getName()+"\t");
			System.out.print(camera.getBrand().getName()+"\t");
			System.out.println(camera.getTitle());
		}
	}
	
	
	
	
	
	
	
	
	
	
	
}







