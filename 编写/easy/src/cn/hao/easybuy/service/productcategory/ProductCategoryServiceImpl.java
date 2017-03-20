package cn.hao.easybuy.service.productcategory;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.hao.easybuy.dao.productcategory.IProductCategoryDAO;
import cn.hao.easybuy.entity.EasybuyProductCategory;

@Service("productCategoryService")
public class ProductCategoryServiceImpl implements IProductCategoryService{


	private IProductCategoryDAO productCategoryDAO;
	@Autowired
	public void setProductCategoryDAO(IProductCategoryDAO productCategoryDAO) {
		this.productCategoryDAO = productCategoryDAO;
	}
	
	@Override
	public void delete(Integer id) {
		productCategoryDAO.delete(id);
	}

	@Override
	public void addCategory(EasybuyProductCategory productCategory) {
		productCategoryDAO.addCategory(productCategory);
	}

	@Override
	public List<EasybuyProductCategory> find(Integer level) {
		// TODO Auto-generated method stub
		return productCategoryDAO.find(level);
	}

	@Override
	public void update(EasybuyProductCategory productCategory) {
		// TODO Auto-generated method stub
		productCategoryDAO.update(productCategory);
	}

	@Override
	public EasybuyProductCategory get(Integer id) {
		// TODO Auto-generated method stub
		return productCategoryDAO.get(id);
	}
	
}
