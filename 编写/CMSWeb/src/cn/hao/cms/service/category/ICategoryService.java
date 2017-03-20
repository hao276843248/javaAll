package cn.hao.cms.service.category;

import java.util.List;

import cn.hao.cms.entity.Category;

public interface ICategoryService {
public List<Category> findCategory(String name);
	
	public Category getCategory(int id);
	
	public void delCategory(int id);
	
	public void updateCategory(Category c);
	
	public void addCategory(Category c);
}
