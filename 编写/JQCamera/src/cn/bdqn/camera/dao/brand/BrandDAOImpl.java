package cn.bdqn.camera.dao.brand;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import cn.bdqn.camera.entity.Brand;

@Repository("brandDAO")
public class BrandDAOImpl extends HibernateDaoSupport implements IBrandDAO{
	
	@Autowired
	public void setHibernateTemlate(HibernateTemplate hibernateTemplate){		
		super.setHibernateTemplate(hibernateTemplate);	
		
	}
	
	
	@Override
	public List<Brand> find() {
		return getHibernateTemplate().find("from Brand b order by b.id");
	}

}
