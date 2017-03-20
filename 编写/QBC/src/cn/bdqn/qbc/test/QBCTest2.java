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
	//查询各个分类及其关联的相机,按分类编号排序
	@Test
	public void testListType(){
		List<Types> types=null;
		Session session=null;
		try {
			session=HibernateUtil.getSession();
			//创建针对Type类的条件容器
			Criteria criteria=session.createCriteria(Types.class);
			//设置集合属性的抓取方式为使用连接查询加载
			criteria.setFetchMode("cameras",FetchMode.JOIN);			
			//设置排序规则
			criteria.addOrder(Order.asc("id"));
			//设置结果集转换器
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

	//查询相机及其关联的品牌和分类
	@Test
	public void testListCamera(){
		List<Camera> cameras=null;
		Session session=null;
		try {
			session=HibernateUtil.getSession();
			//创建针对Camera类的条件容器
			Criteria criteria=session.createCriteria(Camera.class);
			//为关联属性创建别名，实现连接查询
			criteria.createAlias("types","t");
			criteria.createAlias("brand","b");
			
			//添加条件
			criteria.add(Restrictions.eq("b.id",3L));
			
			//设置排序规则
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







