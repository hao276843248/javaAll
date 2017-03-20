package cn.bdqn.qbc.test;

import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.transform.AliasToEntityMapResultTransformer;
import org.junit.Test;

import cn.bdqn.qbc.entity.Camera;
import cn.bdqn.qbc.util.HibernateUtil;

public class QBCTest3 {

	//ͶӰ��ѯ����ѯ����ı�š����⡢������(ÿ�����ݷ�װ�ɶ�������)
	@Test
	public void testListCamera1(){
		List<Object[]> rows=null;
		Session session=null;
		try {
			session=HibernateUtil.getSession();
			//�������Camera�����������
			Criteria criteria=session.createCriteria(Camera.class);
			//�����������ͶӰ���ۺϡ������ѯ���õ�����
			/*Projection p1=Projections.property("id");
			Projection p2=Projections.property("title");
			Projection p3=Projections.property("pixel");*/
			ProjectionList plist=Projections.projectionList();
			//�����Ҫ��ͶӰ��ѯ�а���������
			plist.add(Projections.property("id"));
			plist.add(Projections.property("title"));
			plist.add(Projections.property("pixel"));			
			//����ͶӰ��ѯ
			criteria.setProjection(plist);
			
			criteria.addOrder(Order.asc("id"));
			rows=criteria.list();			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			session.close();
		}
		for(Object[] row:rows){
			Long id=(Long)row[0];
			String title=(String)row[1];
			int pixel=(Integer)row[2];
			
			System.out.println(id+"\t"+pixel+"\t"+title);
					
		}
	}
	
	//�ۺϲ�ѯ����ѯ�������
	@Test
	public void testCountCamera(){
		int rowCount=0;
		Session session=null;
		try {
			session=HibernateUtil.getSession();
			//�������Camera�����������
			Criteria criteria=session.createCriteria(Camera.class);
			//���þۺϲ�ѯ
			rowCount=((Number)criteria.setProjection(Projections.rowCount())
							.uniqueResult()).intValue();
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			session.close();
		}
		System.out.println(rowCount);
	}

	//�ۺϲ�ѯ����ѯ�����������߼ۡ���ͼۡ�ƽ����
	@Test
	public void testCameraInfo(){
		List<Object[]> rows=null;
		Session session=null;
		try {
			session=HibernateUtil.getSession();
			//�������Camera�����������
			Criteria criteria=session.createCriteria(Camera.class);
			
			ProjectionList plist=Projections.projectionList();
			plist.add(Projections.rowCount());
			plist.add(Projections.max("price"));
			plist.add(Projections.min("price"));
			plist.add(Projections.avg("price"));
			
			//����ͶӰ��ѯ
			criteria.setProjection(plist);
			
			criteria.addOrder(Order.asc("id"));
			rows=criteria.list();			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			session.close();
		}
		for(Object[] row:rows){
			Long rowCount=(Long)row[0];
			double maxPrice=(Double)row[1];
			double minPrice=(Double)row[2];
			double avgPrice=(Double)row[3];
			
			System.out.println(rowCount+"\t"+maxPrice+"\t"+minPrice+"\t"+avgPrice);
			
					
		}
	}

	//����ۺϲ�ѯ����ѯ����Ʒ�Ƶ������������߼ۡ���ͼۡ�ƽ����
	@Test
	public void testCameraInfo2(){
		List<Object[]> rows=null;
		Session session=null;
		try {
			session=HibernateUtil.getSession();
			//�������Camera�����������
			Criteria criteria=session.createCriteria(Camera.class);
			criteria.createAlias("brand","b");
			
			ProjectionList plist=Projections.projectionList();
			plist.add(Projections.rowCount());
			plist.add(Projections.max("price"));
			plist.add(Projections.min("price"));
			plist.add(Projections.avg("price"));
			plist.add(Projections.groupProperty("b.name"));			
			
			//����ͶӰ��ѯ
			criteria.setProjection(plist);
			
			criteria.addOrder(Order.asc("b.name"));
			rows=criteria.list();			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			session.close();
		}
		for(Object[] row:rows){
			
			Long rowCount=(Long)row[0];
			double maxPrice=(Double)row[1];
			double minPrice=(Double)row[2];
			double avgPrice=(Double)row[3];
			String brandName=(String)row[4];			
			System.out.println(brandName+"\t"+rowCount+"\t"+maxPrice+"\t"+minPrice+"\t"+avgPrice);							
		}
	}

	//��ҳ��ѯ����б�ÿҳ10������ʾ��5ҳ
	@Test
	public void testGetCamerPage(){
		int pageIndex=5;
		int pageSize=10;
		List<Camera> cameras=null;
		Session session=null;
		try {
			session=HibernateUtil.getSession();
			//�������Camera�����������
			Criteria criteria=session.createCriteria(Camera.class);
			criteria.createAlias("brand","b");
			criteria.createAlias("types","t");
			//���㵱ǰҳ��һ���к�
			int firstResult=(pageIndex-1)*pageSize;
			
			cameras=criteria.setFirstResult(firstResult)
							.setMaxResults(pageSize)
							.list();
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			session.close();
		}
		
		for(Camera camera:cameras){
			System.out.println(camera.getBrand().getName()+"\t"+camera.getTypes().getName()+"\t"+camera.getTitle());
		}
	}
	
}














