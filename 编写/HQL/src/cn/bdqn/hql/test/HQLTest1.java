package cn.bdqn.hql.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.transform.AliasToEntityMapResultTransformer;
import org.hibernate.transform.ResultTransformer;
import org.hibernate.type.DoubleType;
import org.hibernate.type.IntegerType;
import org.hibernate.type.Type;
import org.junit.Test;

import cn.bdqn.hql.entity.Camera;
import cn.bdqn.hql.entity.CameraInfo;
import cn.bdqn.hql.util.HibernateUtil;

public class HQLTest1 {

	//��ѯȫ������б�
	@Test
	public void testListCamera(){
		List<Camera> cameras=null;
		Session session=null;
		try {
			session=HibernateUtil.getSession();
			//��ѯ������ʵ���б�ֱ�Ӵ�from��ʼ
			//HQL�����û�б�����������ֻ��������������
			//HQL����йؼ��ֲ����ִ�Сд�����������������ִ�Сд
			//Query query=session.createQuery("from Camera order by id");
			//ʹ��list()����ִ�в�ѯ������ʵ���б���
			//cameras=query.list();
			cameras=session.createQuery("from Camera order by id")
						   .list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			session.close();
		}		
		for(Camera camera:cameras){
			System.out.println(camera.getTitle());
		}		
	}

	//��ѯ�۸���2000Ԫ���£���������1200�����ϵ������Ϣ��������ݼ۸�������
	@Test
	public void testListCamera2(){
		List<Camera> cameras=null;
		Session session=null;
		try {
			session=HibernateUtil.getSession();
			
			//ʹ��?���ò���ռλ�����󶨲���ʱ�±��0��ʼ
			//String hql="from Camera where price<? and pixel>? order by price desc";
			//Query query=session.createQuery(hql);
			//�󶨲�ѯ����
			//query.setDouble(0,2000D);
			//query.setInteger(1,1200);
			//query.setParameters(
			//	new Object[]{2000D,1200},
			//	new Type[]{DoubleType.INSTANCE,IntegerType.INSTANCE}
			//);
			
			
			//ʹ��:������ ����ռλ�����󶨲���ʱʹ�ò�������
			String hql="from Camera where price<:price and pixel>:pixel order by price desc";
			Query query=session.createQuery(hql);
			//query.setDouble("price",2000D);
			//query.setInteger("pixel",1200);
			/*Map<String,Object> params=new HashMap<String, Object>();
			params.put("price", 2000D);
			params.put("pixel", 1200);
			query.setProperties(params);*/
			Camera paramObj=new Camera();
			paramObj.setPrice(2000);
			paramObj.setPixel(1200);
			query.setProperties(paramObj);
			
			
			
			//ִ�в�ѯ
			cameras=query.list();
			
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

	//ͶӰ��ѯ����ı��⡢�۸������������ݼ۸���������(ʹ�ö��������װ���)
	@Test
	public void testListCamera3(){
		List<Object[]> rows=null;
		Session session=null;
		try {
			session=HibernateUtil.getSession();
			rows=session.createQuery("select title,price,pixel from Camera order by price")
						.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			session.close();
		}	
		
		for(Object[] row:rows){
			String title=(String)row[0];
			double price=(Double)row[1];
			int pixel=(Integer)row[2];
			
			System.out.println(title+"\t"+price+"\t"+pixel);
		}
	}

	//ͶӰ��ѯ����ı��⡢�۸������������ݼ۸���������(ʹ��Java�����װ���)
	@Test
	public void testListCamera4(){
		List<Camera> rows=null;
		Session session=null;
		try {
			session=HibernateUtil.getSession();
			rows=session.createQuery("select new Camera(title,price,pixel) from Camera order by price")
						.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			session.close();
		}	
		for(Camera camera:rows){
			System.out.println(camera.getTitle()+"\t"+camera.getPrice()+"\t"+camera.getPixel());
		}		
	}
	
	//��ѯ�����������߼ۡ���ͼۡ�ƽ����(�����װΪ��������)
	@Test
	public void testQueryCameraInfo(){
		Object[] row=null;
		Session session=null;
		try {
			session=HibernateUtil.getSession();
			row=(Object[])session.createQuery("select count(*),max(price),min(price),avg(price) from Camera")
								 .uniqueResult();					
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			session.close();
		}
		
		int rowCount=((Number)row[0]).intValue();
		double minPrice=(Double)row[1];
		double maxPrice=(Double)row[2];
		double avgPrice=(Double)row[3];
		
		System.out.println(rowCount);
		System.out.println(minPrice);
		System.out.println(maxPrice);
		System.out.println(avgPrice);

	}

	//��ѯ�����������߼ۡ���ͼۡ�ƽ����(�����װΪJava����)
	@Test
	public void testQueryCameraInfo2(){
		cameraInfo cameraInfo=null;
		Session session=null;
		try {
			session=HibernateUtil.getSession();
			cameraInfo=(CameraInfo)session.createQuery("select new cn.bdqn.hql.entity.CameraInfo(count(*),max(price),min(price),avg(price)) from Camera")
								 		  .uniqueResult();					
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			session.close();
		}
		
		System.out.println(cameraInfo.getRowCount());
		System.out.println(cameraInfo.getMinPrice());
		System.out.println(cameraInfo.getMaxPrice());
		System.out.println(cameraInfo.getAvgPrice());

	}

	//��ѯ�����������߼ۡ���ͼۡ�ƽ����(�����װΪMap����)
	@Test
	public void testQueryCameraInfo3(){
		Map<String,Object> result=null;
		Session session=null;
		try {
			session=HibernateUtil.getSession();
			result=(Map<String,Object>)session.createQuery("select count(*) as rowCount,max(price) as maxPrice,min(price) as minPrice,avg(price) as avgPrice from Camera")
											  //���ý����ת����������ѯ�����ÿһ�����ݷ�װΪMap����
											  .setResultTransformer(AliasToEntityMapResultTransformer.INSTANCE)
											  .uniqueResult();					
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			session.close();
		}
		
		System.out.println(result.get("rowCount"));
		System.out.println(result.get("minPrice"));
		System.out.println(result.get("maxPrice"));
		System.out.println(result.get("avgPrice"));		
		
	}

	//��ѯ�������
	@Test
	public void testCountCamera(){
		long rowCount=0;
		Session session=null;
		try {
			session=HibernateUtil.getSession();
			rowCount=(Long)session.createQuery("select count(*) from Camera")
				   		 		  .uniqueResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			session.close();
		}
		System.out.println(rowCount);
	}

}











