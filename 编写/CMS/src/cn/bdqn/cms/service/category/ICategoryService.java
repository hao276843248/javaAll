package cn.bdqn.cms.service.category;

import java.util.List;

import cn.bdqn.cms.entity.Category;

public interface ICategoryService {
	//添加分类
	public void addCategory(Category category);
	
	//更新分类
	public void updateCategory(Category category);
	
	//删除分类
	public void deleteCategory(int id);
	
	//根据id获得单个分类
	public Category getCategoryById(int id);
	
	//查询分类列表
	public List<Category> findCategory(String title);
}
