package cn.bdqn.camera.dao.types;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import cn.bdqn.camera.entity.Types;

@Repository("typesDAO")
public class TypesDAOImpl extends HibernateDaoSupport implements ITypesDAO {

	@Autowired
	public void setHibernateTemlate(HibernateTemplate hibernateTemplate){
		super.setHibernateTemplate(hibernateTemplate);		
	}
	
	@Override
	public List<Types> find() {
		return getHibernateTemplate().find("from Types t order by t.id");
	}
	
}
