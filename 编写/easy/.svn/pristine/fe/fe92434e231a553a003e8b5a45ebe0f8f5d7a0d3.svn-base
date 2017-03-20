package cn.hao.easybuy.dao.productcategory;

import java.util.List;

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

	@Override
	public List<EasybuyProductCategory> find() {
		return hibernateTemplate.find("from EasybuyProductCategory order by epcParentId asc");
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
