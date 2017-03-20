package cn.hao.camera.dao.band;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.hao.camera.entity.Brand;
public class BrandDAOImpl extends HibernateDaoSupport implements IBrandDAO{
	
	private Logger logger=Logger.getLogger(BrandDAOImpl.class);
	
	@Override
	public List<Brand> findBrand() {
		return getHibernateTemplate().find("from Brand order by id");
	}

}






