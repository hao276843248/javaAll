package cn.hao.easybuy.dao.product;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import cn.hao.easybuy.entity.EasybuyProduct;
import cn.hao.easybuy.util.PageBean;

@Repository("productDAO")
public class ProductDAOImpl implements IProductDAO{

	private HibernateTemplate hibernateTemplate;
	@Autowired
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	@Override
	public EasybuyProduct get(Integer id) {
		return hibernateTemplate.get(EasybuyProduct.class, id);
	}

	@Override
	public PageBean find(int pageIndex, int pageSize, int lei) {
		int rowCount=0;
		//计算总页数
		int pageCount=(rowCount%pageSize==0)?(rowCount/pageSize):(rowCount/pageSize+1);
		//计算当前页第一行行号
		int firstResult=(pageIndex-1)*pageSize;
		DetachedCriteria detcri=DetachedCriteria.forClass(EasybuyProduct.class);
		if(lei==1){
			detcri.add(Restrictions.ne("epStock",0));
			detcri.addOrder(Order.asc("epPrice"));
		}else if(lei==2){
			detcri.addOrder(Order.desc("epStock"));
		}else{
			detcri.add(Restrictions.ne("epcChildId",lei));
			detcri.addOrder(Order.desc("epId"));	
		}
		List<EasybuyProduct> result=hibernateTemplate.findByCriteria(detcri, firstResult, pageSize);
		
		PageBean p=new PageBean();
		p.setPageCount(pageCount);
		p.setPageIndex(pageIndex);
		p.setPageSize(pageSize);
		p.setResults(result);
		p.setRowCount(rowCount);
		
		return p;
		
	}

	@Override
	public void delete(Integer id) {
		hibernateTemplate.bulkUpdate("delete from EasybuyProduct where epId=?",id);
	}

	@Override
	public void add(EasybuyProduct product) {
		hibernateTemplate.save(product);
	}

	@Override
	public void update(EasybuyProduct product) {
		hibernateTemplate.update(product);
	}

}
