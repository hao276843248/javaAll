package cn.bdqn.cms.service.category;

import java.util.List;

import cn.bdqn.cms.entity.Category;

public interface ICategoryService {
	//��ӷ���
	public void addCategory(Category category);
	
	//���·���
	public void updateCategory(Category category);
	
	//ɾ������
	public void deleteCategory(int id);
	
	//����id��õ�������
	public Category getCategoryById(int id);
	
	//��ѯ�����б�
	public List<Category> findCategory(String title);
}
