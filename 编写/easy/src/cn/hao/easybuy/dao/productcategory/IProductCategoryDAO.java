package cn.hao.easybuy.dao.productcategory;

import java.util.List;

import cn.hao.easybuy.entity.EasybuyProductCategory;

public interface IProductCategoryDAO {

	public void delete(Integer id);
		
	public void addCategory(EasybuyProductCategory productCategory);
	
	public List<EasybuyProductCategory> find(Integer level);
	
	public void update(EasybuyProductCategory productCategory);
	
	public EasybuyProductCategory get(Integer id);
}
