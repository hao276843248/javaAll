package cn.bdqn.qbc.test;

import java.util.List;
import java.util.Set;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.transform.DistinctRootEntityResultTransformer;
import org.hibernate.type.LongType;
import org.hibernate.type.StringType;
import org.junit.Test;

import cn.bdqn.qbc.entity.Brand;
import cn.bdqn.qbc.entity.Camera;
import cn.bdqn.qbc.util.HibernateUtil;

public class SQLQueryTest1 {

	//查询Brand表中的所有数据(每行数据封装成对象数组)
	@Test
	public void testListBrand(){
		List<Object[]> rows=null;
		Session session=null;
		try {
			session=HibernateUtil.getSession();
			//String sql="SELECT id,name FROM Brand ORDER BY id";
			//SQLQuery query=session.createSQLQuery(sql);
			SQLQuery query=(SQLQuery)session.getNamedQuery("findBrand_1");
			//指定在结果集中包含哪些字段及其对应的类型
			//query.addScalar("id",LongType.INSTANCE);
			//query.addScalar("name",StringType.INSTANCE);
			rows=query.list();			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			session.close();
		}
		
		for(Object[] row:rows){
			Long id=(Long)row[0];
			String name=(String)row[1];
			System.out.println(id+"\t"+name);
			System.out.println("--------------");
		}
	}
	
	//查询Brand表中的所有数据(每行数据封装成Brand对象)
	@Test
	public void testListBrand2(){
		List<Brand> brands=null;
		Session session=null;
		try {
			session=HibernateUtil.getSession();
			String sql="SELECT {b.*} FROM Brand b ORDER BY b.id";
			SQLQuery query=session.createSQLQuery(sql);
			query.addEntity("b",Brand.class);
			brands=query.list();		
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			session.close();
		}
		for(Brand brand:brands){
			System.out.println(brand.getId()+"\t"+brand.getName());
		}
	}
	
	//查询Brand表及其关联的Camera表的数据
	@Test
	public void testListBrandAndCamera(){
		List<Object[]> rows=null;
		Session session=null;
		try {
			session=HibernateUtil.getSession();
			/*String sql="SELECT {b.*},{c.*} FROM Brand b LEFT JOIN Camera c ON b.id=c.brandId ORDER BY b.id";
			rows=session.createSQLQuery(sql)
					 	.addEntity("b",Brand.class)
					 	.addEntity("c",Camera.class)
					 	.list();*/
			
			rows=session.getNamedQuery("findBrand_2")
						.list();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			session.close();
		}
		
		for(Object[] row:rows){
			Brand brand=(Brand)row[0];
			Camera camera=(Camera)row[1];
			System.out.print(brand.getName()+"\t");
			if(camera!=null){
				System.out.println(camera.getTitle());
			}
		}
	}
	

	@Test
	public void testListBrandAndCamera2(){
		List<Brand> rows=null;
		Session session=null;
		try {
			session=HibernateUtil.getSession();
			String sql="SELECT {b.*},{c.*} FROM Brand b LEFT JOIN Camera c ON b.id=c.brandId ORDER BY b.id";
			SQLQuery query=(SQLQuery)session.createSQLQuery(sql);
			
			query.addEntity("b",Brand.class);
			query.addJoin("c","b.cameras");			
			query.addRoot("b",Brand.class);
			
			query.setResultTransformer(DistinctRootEntityResultTransformer.INSTANCE);
			rows=query.list();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			session.close();
		}
		for(Brand brand:rows){
			System.out.println(brand.getName());
			Set<Camera> cameras=brand.getCameras();
			for(Camera camera:cameras){
				System.out.println(camera.getTitle());
			}
			System.out.println("--------------");
		}
		
	
	}
	
}






