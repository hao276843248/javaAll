package cn.hao.chartroom.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import cn.hao.chartroom.entity.Chartroom;

@Repository("chartRoomDAO")
public class ChartRoomDAOImpl implements IChartRoomDAO{

	private HibernateTemplate hibernateTemplate;
	@Autowired
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	@Override
	public List<Chartroom> findContentById(Integer id) {
		return hibernateTemplate.find("from Chartroom where id>? order by id",id);
	}

	@Override
	public void addContent(Chartroom chartroom) {
		hibernateTemplate.save(chartroom);
	}

	@Override
	public List<Chartroom> findContentBySize(Integer size) {
		DetachedCriteria detcir=DetachedCriteria.forClass(Chartroom.class);
		detcir.addOrder(Order.asc("id"));
		return hibernateTemplate.findByCriteria(detcir,0,size);
	}

}
