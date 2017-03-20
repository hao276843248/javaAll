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
		//����DetachedCriteria�����ڲ���Session��������Ƚ�������װ��
		DetachedCriteria detCri=DetachedCriteria.forClass(Camera.class);
		//����������ʵ�����Ӳ�ѯ
		detCri.createAlias("brand","b");
		detCri.createAlias("type","t");
		//��װ����
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
			//����color��ָ�������ݿ�ʼ���൱��color like '��%'
			//detCri.add(Restrictions.like("color",color,MatchMode.START));
			//����color��ָ�������ݽ������൱��color like '%��'
			//detCri.add(Restrictions.like("color",color,MatchMode.END));
			//����color�������ָ�������٣��൱��color like '��'
			//detCri.add(Restrictions.like("color",color,MatchMode.EXACT));
			//����color�а���ָ�������ݣ��൱��color like '%��%'
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
			//��ÿ���ִ�е�Criteria
			Criteria criteria=detCri.getExecutableCriteria(session);
			
			//��ѯ������
			criteria.setProjection(Projections.rowCount());
			int rowCount=((Number)criteria.uniqueResult()).intValue();
			
			//������ҳ��		
			int pageCount=(rowCount%pageSize==0)?(rowCount/pageSize):(rowCount/pageSize+1);
			//���㵱ǰҳ��һ���к�
			int firstResult=(pageIndex-1)*pageSize;
			
			//ȡ��֮ǰ���õľۺϲ�ѯ
			criteria.setProjection(null);
			
			//ִ�з�ҳ�б��ѯ
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
			logger.error("��ѯ�����ҳ�б�ʱ��������",e);
		}
		finally{
			session.close();
		}
		
		
		
		
		return pageBean;
	}

}








