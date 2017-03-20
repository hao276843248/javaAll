package cn.hao.camera.dao.camera;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.DistinctRootEntityResultTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.hao.camera.entity.Camera;
import cn.hao.camera.util.PageBean;



public class CameraDAOImpl extends HibernateDaoSupport implements ICameraDAO{
	
	private	Logger logger=Logger.getLogger(CameraDAOImpl.class);
	
	@Autowired
	public void setHibernateTemlate(HibernateTemplate hibernateTemplate){
		super.setHibernateTemplate(hibernateTemplate);		
	}
	
	@Override
	public PageBean find(int pageIndex, int pageSize, Long brandId,Long typeId, Double maxPrice, Integer minPixel,String title,String sort,String order) {
		DetachedCriteria detCri=DetachedCriteria.forClass(Camera.class);
		detCri.createAlias("brand","b");
		detCri.createAlias("types","t");
		if(brandId!=null && brandId!=0){
			detCri.add(Restrictions.eq("b.id",brandId));
		}
		if(typeId!=null && typeId!=0){
			detCri.add(Restrictions.eq("t.id",typeId));
		}
		if(maxPrice!=null && maxPrice!=0){
			detCri.add(Restrictions.le("price",maxPrice));
		}
		if(minPixel!=null && minPixel!=0){
			detCri.add(Restrictions.ge("pixel",minPixel));
		}
		if(StringUtils.isNotEmpty(title)){
			detCri.add(Restrictions.like("title",title,MatchMode.ANYWHERE));
		}		
		
		
		detCri.setProjection(Projections.rowCount());
		int rowCount=((Number)getHibernateTemplate().findByCriteria(detCri).get(0)).intValue();
		int firstResult=(pageIndex-1)*pageSize;
		
		//设置排序字段和规则
		
		if(order.equals("asc")){
			detCri.addOrder(Order.asc(sort));
		}
		else{
			detCri.addOrder(Order.desc(sort));
		}
		
				
		detCri.setProjection(null);
		detCri.setResultTransformer(DistinctRootEntityResultTransformer.INSTANCE);
		
		List<Camera> results=getHibernateTemplate().findByCriteria(detCri,firstResult,pageSize);
		
		PageBean pageBean=new PageBean(rowCount,results);
		return pageBean;
		
	}
	
	@Override
	public Camera get(Long id) {
		return getHibernateTemplate().get(Camera.class,id);
	}
	
}












