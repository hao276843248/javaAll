package cn.hao.easybuy.service.productcategory;

import java.util.List;

import cn.hao.easybuy.entity.EasybuyProductCategory;

public interface IProductCategoryService {

	public void delete(Integer id);
	
	public void addCategory(EasybuyProductCategory productCategory);
	
	public List<EasybuyProductCategory> find(Integer level);
	
	public void update(EasybuyProductCategory productCategory);
	
	public EasybuyProductCategory get(Integer id);
}
