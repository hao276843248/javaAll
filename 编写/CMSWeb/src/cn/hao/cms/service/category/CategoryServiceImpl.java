package cn.hao.cms.service.category;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;


import cn.hao.cms.entity.Category;
import cn.hao.cms.mapper.category.CategoryMapper;
import cn.hao.cms.util.MyBatisUtil;

public class CategoryServiceImpl implements ICategoryService{
	private Logger logger=Logger.getLogger(CategoryServiceImpl.class);
	@Override
	public List<Category> findCategory(String name) {
		SqlSession session=null;
		List<Category> cs=null;
		try {
			session=MyBatisUtil.openSession();
			CategoryMapper mapper=session.getMapper(CategoryMapper.class);
			cs=mapper.findCategory(name);
		} catch (Exception e) {
			logger.error("获得分类时发生错误",e);
			session.rollback();
			e.printStackTrace();
		}finally{
			session.close();
		}
		return cs;
	}

	@Override
	public Category getCategory(int id) {
		SqlSession session=null;
		Category c=null;
		try {
			session=MyBatisUtil.openSession();
			CategoryMapper mapper=session.getMapper(CategoryMapper.class);
			c=mapper.getCategory(id);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("获得分类时发生错误",e);
			session.rollback();
		}finally{
			session.close();
		}
		return c;
	}

	@Override
	public void delCategory(int id) {
		SqlSession session=null;
		try {
			session=MyBatisUtil.openSession();
			CategoryMapper mapper=session.getMapper(CategoryMapper.class);
			mapper.delCategory(id);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("删除分类时发生错误",e);
			session.rollback();
		}finally{
			session.close();
		}
	}

	@Override
	public void updateCategory(Category c) {
		SqlSession session=null;
		try {
			session=MyBatisUtil.openSession();
			CategoryMapper mapper=session.getMapper(CategoryMapper.class);
			mapper.updateCategory(c);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("修改分类时发生错误",e);
			session.rollback();
		}finally{
			session.close();
		}
	}

	@Override
	public void addCategory(Category c) {
		SqlSession session=null;
		try {
			session=MyBatisUtil.openSession();
			CategoryMapper mapper=session.getMapper(CategoryMapper.class);
			mapper.addCategory(c);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("添加分类时发生错误",e);
			session.rollback();
		}finally{
			session.close();
		}
	}

}
