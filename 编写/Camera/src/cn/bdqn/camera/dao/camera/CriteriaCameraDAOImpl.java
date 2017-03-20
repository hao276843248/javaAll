package cn.bdqn.camera.dao.camera;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.DistinctRootEntityResultTransformer;

import cn.bdqn.camera.entity.Camera;
import cn.bdqn.camera.util.HibernateUtil;
import cn.bdqn.camera.util.PageBean;
import cn.bdqn.camera.util.Range;

public class CriteriaCameraDAOImpl implements ICameraDAO{
	
	private Logger logger=Logger.getLogger(CriteriaCameraDAOImpl.class);
	
	@Override
	public PageBean findCamera(int pageIndex, int pageSize, Long typeId,
			Long brandId, Range pixel, Range zoom, String color, Range lcd,
			Range price, String title) {
		
		PageBean pageBean=new PageBean();
		//创建DetachedCriteria对象，在不打开Session的情况下先将条件组装好
		DetachedCriteria detCri=DetachedCriteria.forClass(Camera.class);
		//创建别名，实现连接查询
		detCri.createAlias("brand","b");
		detCri.createAlias("type","t");
		//组装条件
		if(typeId!=null){
			detCri.add(Restrictions.eq("t.id",typeId));
		}
		if(brandId!=null){
			detCri.add(Restrictions.eq("b.id",brandId));			
		}
		if(pixel!=null){
			detCri.add(Restrictions.ge("pixel",pixel.getMinValue().intValue()));
			if(pixel.getMaxValue()!=null){
				detCri.add(Restrictions.le("pixel",pixel.getMaxValue().intValue()));
			}
		}
		if(zoom!=null){
			if(zoom.getMinValue().doubleValue()<1){
				detCri.add(Restrictions.eq("zoom",zoom.getMinValue().doubleValue()));
			}
			else{
				detCri.add(Restrictions.ge("zoom",zoom.getMinValue().doubleValue()));				
				if(zoom.getMaxValue()!=null){
					detCri.add(Restrictions.le("zoom",zoom.getMaxValue().doubleValue()));
				}
			}			
		}
		if(color!=null && !color.equals("")){
			//detCri.add(Restrictions.like("color","%"+color+"%"));
			//设置color以指定的内容开始，相当于color like '蓝%'
			//detCri.add(Restrictions.like("color",color,MatchMode.START));
			//设置color以指定的内容结束，相当于color like '%蓝'
			//detCri.add(Restrictions.like("color",color,MatchMode.END));
			//设置color必须等于指定的聂荣，相当于color like '蓝'
			//detCri.add(Restrictions.like("color",color,MatchMode.EXACT));
			//设置color中包含指定的内容，相当于color like '%蓝%'
			detCri.add(Restrictions.like("color",color,MatchMode.ANYWHERE));
		}
		if(lcd!=null){
			detCri.add(Restrictions.ge("lcd",lcd.getMinValue().doubleValue()));
			if(lcd.getMaxValue()!=null){
				detCri.add(Restrictions.le("lcd",lcd.getMaxValue().doubleValue()));
			}
		}
		if(price!=null){
			detCri.add(Restrictions.ge("price",price.getMinValue().doubleValue()));
			if(price.getMaxValue()!=null){
				detCri.add(Restrictions.le("price",price.getMaxValue().doubleValue()));
			}
		}
		if(title!=null && !title.equals("")){
			detCri.add(Restrictions.like("title",title,MatchMode.ANYWHERE));
		}
		
		
		Session session=null;
		try {
			session=HibernateUtil.getSession();
			//获得可以执行的Criteria
			Criteria criteria=detCri.getExecutableCriteria(session);
			
			//查询总行数
			criteria.setProjection(Projections.rowCount());
			int rowCount=((Number)criteria.uniqueResult()).intValue();
			
			//计算总页数		
			int pageCount=(rowCount%pageSize==0)?(rowCount/pageSize):(rowCount/pageSize+1);
			//计算当前页第一行行号
			int firstResult=(pageIndex-1)*pageSize;
			
			//取消之前设置的聚合查询
			criteria.setProjection(null);
			
			//执行分页列表查询
			List<Camera> cameras=criteria.setFirstResult(firstResult)
										 .setMaxResults(pageSize)
										 .addOrder(Order.asc("id"))
										 .setResultTransformer(DistinctRootEntityResultTransformer.INSTANCE)
										 .list();

			pageBean.setPageIndex(pageIndex);
			pageBean.setPageSize(pageSize);
			pageBean.setRowCount(rowCount);
			pageBean.setPageCount(pageCount);
			pageBean.setResults(cameras);
						
		} catch (Exception e) {
			logger.error("查询相机分页列表时发生错误",e);
		}
		finally{
			session.close();
		}
		
		
		
		
		return pageBean;
	}

}








