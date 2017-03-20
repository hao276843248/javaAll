package cn.bdqn.cms.service.category;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import cn.bdqn.cms.entity.Category;
import cn.bdqn.cms.mapper.category.CategoryMapper;
import cn.bdqn.cms.util.MyBatisUtil;

public class CategoryServiceImpl implements ICategoryService{
	
	private Logger logger=Logger.getLogger(CategoryServiceImpl.class);

	@Override
	public void addCategory(Category category) {
		SqlSession session=null;
		try {
			session=MyBatisUtil.openSession();
			CategoryMapper mapper=session.getMapper(CategoryMapper.class);
			mapper.addCategory(category);
			session.commit();
		} catch (Exception e) {
			logger.error("添加分类时发生错误",e);
			session.rollback();
		}
		finally{
			session.close();
		}		
	}

	@Override
	public void updateCategory(Category category) {
		SqlSession session=null;
		try {
			session=MyBatisUtil.openSession();
			CategoryMapper mapper=session.getMapper(CategoryMapper.class);
			mapper.updateCategory(category);
			session.commit();
		} catch (Exception e) {
			logger.error("更新分类时发生错误",e);
			session.rollback();
		}
		finally{
			session.close();
		}
	}

	@Override
	public void deleteCategory(int id) {
		SqlSession session=null;
		try {
			session=MyBatisUtil.openSession();
			CategoryMapper mapper=session.getMapper(CategoryMapper.class);
			mapper.deleteCategory(id);
			session.commit();
		} catch (Exception e) {
			logger.error("删除分类时发生错误",e);
			session.rollback();
		}
		finally{
			session.close();
		}
	}

	@Override
	public Category getCategoryById(int id) {
		Category category=null;
		SqlSession session=null;
		try {
			session=MyBatisUtil.openSession();
			CategoryMapper mapper=session.getMapper(CategoryMapper.class);
			category=mapper.getCategoryById(id);	
		} catch (Exception e) {
			logger.error("添加分类时发生错误",e);			
		}
		finally{
			session.close();
		}
		return category;
	}

	@Override
	public List<Category> findCategory(String title) {
		List<Category> categories=null;
		SqlSession session=null;
		try {
			session=MyBatisUtil.openSession();
			CategoryMapper mapper=session.getMapper(CategoryMapper.class);
			categories=mapper.findCategory("%"+title+"%");
		} catch (Exception e) {
			logger.error("添加分类时发生错误",e);			
		}
		finally{
			session.close();
		}
 		return categories;
	}
	
	

}






