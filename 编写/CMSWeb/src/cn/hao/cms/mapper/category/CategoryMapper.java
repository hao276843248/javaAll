package cn.hao.cms.mapper.category;

import java.util.List;

import cn.hao.cms.entity.Category;

public interface CategoryMapper {
	public List<Category> findCategory(String name);
	
	public Category getCategory(int id);
	
	public void delCategory(int id);
	
	public void updateCategory(Category c);
	
	public void addCategory(Category c);
	
	
}
