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

	//查询全部相机列表
	@Test
	public void testListCamera(){
		List<Camera> cameras=null;
		Session session=null;
		try {
			session=HibernateUtil.getSession();
			//查询完整的实体列表直接从from开始
			//HQL语句中没有表名、列名，只有类名和属性名
			//HQL语句中关键字不区分大小写，类名和属性名区分大小写
			//Query query=session.createQuery("from Camera order by id");
			//使用list()方法执行查询，返回实体列表集合
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

	//查询价格在2000元以下，像素数在1200万以上的相机信息，结果根据价格降序排列
	@Test
	public void testListCamera2(){
		List<Camera> cameras=null;
		Session session=null;
		try {
			session=HibernateUtil.getSession();
			
			//使用?设置参数占位符，绑定参数时下标从0开始
			//String hql="from Camera where price<? and pixel>? order by price desc";
			//Query query=session.createQuery(hql);
			//绑定查询参数
			//query.setDouble(0,2000D);
			//query.setInteger(1,1200);
			//query.setParameters(
			//	new Object[]{2000D,1200},
			//	new Type[]{DoubleType.INSTANCE,IntegerType.INSTANCE}
			//);
			
			
			//使用:参数名 设置占位符，绑定参数时使用参数名绑定
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
			
			
			
			//执行查询
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

	//投影查询相机的标题、价格、像素数，根据价格升序排列(使用对象数组封装结果)
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

	//投影查询相机的标题、价格、像素数，根据价格升序排列(使用Java对象封装结果)
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
	
	//查询相机数量、最高价、最低价、平均价(结果封装为对象数组)
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

	//查询相机数量、最高价、最低价、平均价(结果封装为Java对象)
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

	//查询相机数量、最高价、最低价、平均价(结果封装为Map集合)
	@Test
	public void testQueryCameraInfo3(){
		Map<String,Object> result=null;
		Session session=null;
		try {
			session=HibernateUtil.getSession();
			result=(Map<String,Object>)session.createQuery("select count(*) as rowCount,max(price) as maxPrice,min(price) as minPrice,avg(price) as avgPrice from Camera")
											  //设置结果集转换器，将查询结果的每一行数据封装为Map集合
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

	//查询相机数量
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











