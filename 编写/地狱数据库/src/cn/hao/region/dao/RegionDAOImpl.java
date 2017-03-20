package cn.hao.region.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import cn.hao.region.entity.Region;
@Repository("regionDAO")
public class RegionDAOImpl implements IRegionDAO{

	private HibernateTemplate hibernateTemplate;
	@Autowired
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	@Override
	public List<Region> findRegions(Integer parentId) {
		return hibernateTemplate.find("from Region where parentId=?",parentId);
	}
	
	

	
}
