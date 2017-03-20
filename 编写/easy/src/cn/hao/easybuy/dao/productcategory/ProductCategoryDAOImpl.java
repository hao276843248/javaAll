package cn.hao.easybuy.dao.productcategory;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.classic.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import cn.hao.easybuy.entity.EasybuyProductCategory;

@Repository("productCategoryDAO")
public class ProductCategoryDAOImpl implements IProductCategoryDAO{

	private HibernateTemplate hibernateTemplate;
	@Autowired
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	@Override
	public void delete(Integer id) {
		hibernateTemplate.bulkUpdate("delete from EasybuyProductCategory where epcId=?",id);
	}

	@Override
	public void addCategory(EasybuyProductCategory productCategory) {
		hibernateTemplate.save(productCategory);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<EasybuyProductCategory> find(Integer level) {
		if (level!=null) {
			return hibernateTemplate.find("from EasybuyProductCategory where level=? order by epcParentId asc",level);
		}else {
			return hibernateTemplate.find("from EasybuyProductCategory order by level asc");
		}
	}
		

	@Override
	public void update(EasybuyProductCategory productCategory) {
		hibernateTemplate.update(productCategory);
	}

	@Override
	public EasybuyProductCategory get(Integer id) {
		return hibernateTemplate.get(EasybuyProductCategory.class,id);
	}

	
	

}
