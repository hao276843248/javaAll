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

	//查询全部品牌列表,按照品牌编号升序排序
	@Test
	public void testListBrand(){
		List<Brand> brands=null;
		Session session=null;
		try {
			session=HibernateUtil.getSession();
			//from Brand order by id
			//创建针对Brand类的条件容器
			//Criteria criteria=session.createCriteria(Brand.class);
			//创建排序规则，根据id属性升序排序
			//Order order=Order.asc("id");
			//将排序规则添加到条件容器中
			//criteria.addOrder(order);			
			//执行查询，获得结果列表
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
	
	//查询价格在2000元以下，并且像素数在1200万以上的相机，按照价格升序排序
	@Test
	public void testListCamera(){
		List<Camera> cameras=null;
		Session session=null;
		try {
			session=HibernateUtil.getSession();
			//from Camera where price<2000 and pixel>1200 order by price
			
			//创建针对Camera类的条件容器
			//Criteria criteria=session.createCriteria(Camera.class);
			//创建表示“价格在2000元以下”的条件对象
			//Criterion c1=Restrictions.lt("price",2000d);
			//创建表示“素数在1200万以上”的条件对象
			//Criterion c2=Restrictions.gt("pixel",1200);
			//组装查询条件,使用add方法添加的条件默认用"and"连接在一起
			//criteria.add(c1);
			//criteria.add(c2);
			//添加排序规则
			//criteria.addOrder(Order.asc("price"));
			//执行查询，获得结果列表
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
	
	//查询价格在2000元以下，或者像素数在1200万以上的相机，按照像素数降序排序
	@Test
	public void testListCamera2(){
		List<Camera> cameras=null;
		Session session=null;
		try {
			session=HibernateUtil.getSession();
			//from Camera where price<2000 or pixel>1200 order by price
			
			//创建针对Camera类的条件容器
			//Criteria criteria=session.createCriteria(Camera.class);
			//创建表示“价格在2000元以下”的条件对象
			//Criterion c1=Restrictions.lt("price",2000d);
			//创建表示“素数在1200万以上”的条件对象
			//Criterion c2=Restrictions.gt("pixel",1200);
			//用"or"组合两个条件
			//Criterion or=Restrictions.or(c1,c2);
			//添加条件
			//criteria.add(or);
			//设置排序规则
			//criteria.addOrder(Order.desc("pixel"));
			//执行查询，获得结果列表
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
	
	//查询价格在2000元以下，或者像素数在1200万以上的相机，或者光学变焦倍数在10倍以上，按照像素数降序排序
	@Test
	public void testListCamera3(){
		List<Camera> cameras=null;
		Session session=null;
		try {
			session=HibernateUtil.getSession();
			//from Camera where price<2000 or pixel>1200 order by price
			
			//创建针对Camera类的条件容器
			Criteria criteria=session.createCriteria(Camera.class);
			//创建表示“价格在2000元以下”的条件对象
			Criterion c1=Restrictions.lt("price",2000d);
			//创建表示“素数在1200万以上”的条件对象
			Criterion c2=Restrictions.gt("pixel",1200);
			//创建表示“光学变焦倍数在10倍以上”的条件对象
			Criterion c3=Restrictions.gt("zoom",10d);
			
			//创建默认使用“or”连接的条件容器
			Disjunction disj=Restrictions.disjunction();
			disj.add(c1);
			disj.add(c2);
			disj.add(c3);
			
					
			//添加条件
			criteria.add(disj);
			//设置排序规则
			criteria.addOrder(Order.desc("pixel"));
			//执行查询，获得结果列表
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
		
	//价格在2000元以下且像素数在1200万以上，或者光学变焦倍数在10倍以上且品牌编号为3的相机列表
	@Test
	public void testListCamera4(){
		List<Camera> cameras=null;
		Session session=null;
		try {
			session=HibernateUtil.getSession();
			//from Camera where (price<2000 or pixel>1200) or (zoom>10 and brand.id=3) order by price
			
			//创建针对Camera类的条件容器
			Criteria criteria=session.createCriteria(Camera.class);
			//创建表示“价格在2000元以下”的条件对象
			Criterion c1=Restrictions.lt("price",2000d);
			//创建表示“素数在1200万以上”的条件对象
			Criterion c2=Restrictions.gt("pixel",1200);
			//创建表示“光学变焦倍数在10倍以上”的条件对象
			Criterion c3=Restrictions.gt("zoom",10d);
			//创建表示“品牌编号为3”的条件对象
			Criterion c4=Restrictions.eq("brand.id",3L);
			//用and组装c1和c2
			Criterion and1=Restrictions.and(c1,c2);
			//用and组装c3和c4
			Criterion and2=Restrictions.and(c3,c4);
			//使用or连接and1和and2
			Criterion or=Restrictions.or(and1,and2);
		
			criteria.add(or);
			
			//设置排序规则
			criteria.addOrder(Order.desc("pixel"));
			//执行查询，获得结果列表
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









