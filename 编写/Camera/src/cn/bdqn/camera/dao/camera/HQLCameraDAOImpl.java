package cn.bdqn.camera.dao.camera;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.hibernate.Session;

import cn.bdqn.camera.entity.Camera;
import cn.bdqn.camera.util.HibernateUtil;
import cn.bdqn.camera.util.PageBean;
import cn.bdqn.camera.util.Range;

public class HQLCameraDAOImpl implements ICameraDAO{
	
	private	Logger logger=Logger.getLogger(HQLCameraDAOImpl.class);
	
	@Override
	public PageBean findCamera(int pageIndex, int pageSize, Long typeId,
			Long brandId, Range pixel, Range zoom, String color, Range lcd,
			Range price, String title) {
		PageBean pageBean=new PageBean();
		
		//用来保存要绑定到HQL语句中的参数的集合
		Map<String,Object> params=new HashMap<String, Object>();
		//HQL语句的where部分
		StringBuffer where=new StringBuffer(200);
		where.append(" where 1=1");
		
		if(typeId!=null){
			where.append(" and c.type.id=:typeId");
			params.put("typeId",typeId);
		}
		if(brandId!=null){
			where.append(" and c.brand.id=:brandId");
			params.put("brandId",brandId);
		}
		if(pixel!=null){
			where.append(" and c.pixel>=:minPixel");
			params.put("minPixel",pixel.getMinValue().intValue());
			if(pixel.getMaxValue()!=null){
				where.append(" and c.pixel<=:maxPixel");
				params.put("maxPixel",pixel.getMaxValue().intValue());
			}
		}
		if(zoom!=null){
			if(zoom.getMinValue().doubleValue()<1){
				where.append(" and c.zoom=:zoom");
				params.put("zoom",zoom.getMaxValue().doubleValue());
			}
			else{
				where.append(" and c.zoom>=:minZoom");
				params.put("minZoom",zoom.getMinValue().doubleValue());
				if(zoom.getMaxValue()!=null){
					where.append(" and c.zoom<=:maxZoom");
					params.put("maxZoom",zoom.getMaxValue().doubleValue());
				}
			}			
		}
		if(color!=null && !color.equals("")){
			where.append(" and c.color like :color");
			params.put("color","%"+color+"%");
		}
		if(lcd!=null){
			where.append(" and c.lcd>=:minLcd");
			params.put("minLcd",lcd.getMinValue().doubleValue());
			if(lcd.getMaxValue()!=null){
				where.append(" and c.lcd<=:maxLcd");
				params.put("maxLcd",lcd.getMaxValue().doubleValue());
			}
		}
		if(price!=null){
			where.append(" and c.price>=:minPrice");
			params.put("minPrice",price.getMinValue().doubleValue());
			if(price.getMaxValue()!=null){
				where.append(" and c.price<=:maxPrice");
				params.put("maxPrice",price.getMaxValue().doubleValue());
			}
		}
		if(title!=null && !title.equals("")){
			where.append(" and c.title like :title");
			params.put("title","%"+title+"%");
		}
		
		Session session=null;
		try {
			session=HibernateUtil.getSession();
			//查询总行数
			String countHql="select count(*) from Camera c "+where.toString();
			int rowCount=((Number)session.createQuery(countHql)
										 .setProperties(params)
										 .uniqueResult()).intValue();
			//计算总页数
			int pageCount=(rowCount%pageSize==0)?(rowCount/pageSize):(rowCount/pageSize+1);
			//计算当前页第一行行号
			int firstResult=(pageIndex-1)*pageSize;
			//查询分页列表
			String listHql="from Camera c inner join fetch c.type inner join fetch c.brand "+where.toString()+" order by c.id";
			List<Camera> cameras=session.createQuery(listHql)
										.setProperties(params)
										.setFirstResult(firstResult)
										.setMaxResults(pageSize)
										.list();
			
			pageBean.setPageIndex(pageIndex);
			pageBean.setPageSize(pageSize);
			pageBean.setRowCount(rowCount);
			pageBean.setPageCount(pageCount);
			pageBean.setResults(cameras);
			
			
		} catch (Exception e) {
			logger.error("分页查询相机列表时发生错误",e);
		}
		finally{
			session.close();
		}
		
		
		
		
		
		
		
		
		
		return pageBean;
	}

}












