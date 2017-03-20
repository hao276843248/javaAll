package cn.bdqn.cms.service.content;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import cn.bdqn.cms.entity.Content;
import cn.bdqn.cms.mapper.content.ContentMapper;
import cn.bdqn.cms.util.MyBatisUtil;
import cn.bdqn.cms.util.PageBean;
import cn.bdqn.mybatis.plugin.PageParam;

public class ContentServiceImpl implements IContentService {
	
	private Logger logger=Logger.getLogger(ContentServiceImpl.class);
	
	@Override
	public void addContent(Content content) {
		SqlSession session=null;
		try {
			session=MyBatisUtil.openSession();
			ContentMapper mapper=session.getMapper(ContentMapper.class);
			mapper.addContent(content);
			session.commit();
		} catch (Exception e) {
			logger.error("�������ʱ��������",e);
			session.rollback();
		}
		finally{
			session.close();
		}
		
		
	}

	@Override
	public PageBean findContent(int pageIndex, int pageSize,
			Integer categoryId, String title,String categoryName) {
		PageBean pageBean=new PageBean();
		SqlSession session=null;
		try {
			session=MyBatisUtil.openSession();
			ContentMapper mapper=session.getMapper(ContentMapper.class);
			PageParam param=new PageParam(pageIndex, pageSize);
			
			List<Content> results=mapper.findContent(param, categoryId, "%"+title+"%", "%"+categoryName+"%");
			
			pageBean.setPageIndex(pageIndex);
			pageBean.setPageSize(pageSize);
			pageBean.setRowCount(param.getRowCount());
			pageBean.setPageCount(param.getPageCount());
			pageBean.setResults(results);
			
		} catch (Exception e) {
			logger.error("��ѯ���ݷ�ҳ�б�ʱ��������",e);
		}
		finally{
			session.close();
		}
		
		return pageBean;
	}
	
	@Override
	public Content getContentById(int id) {
		Content content=null;
		SqlSession session=null;
		try {
			session=MyBatisUtil.openSession();
			ContentMapper mapper=session.getMapper(ContentMapper.class);
			content=mapper.getContentById(id);			
		} catch (Exception e) {
			logger.error("����ID�������ʱ��������",e);
		}
		finally{
			session.close();
		}
		return content;
	}
	
	@Override
	public void updateContent(Content content) {
		SqlSession session=null;
		try {
			session=MyBatisUtil.openSession();
			ContentMapper mapper=session.getMapper(ContentMapper.class);
			mapper.updateContent(content);
			session.commit();
		} catch (Exception e) {
			logger.error("��������ʱ��������",e);
			session.rollback();
		}
		finally{
			session.close();
		}

	}
	
	@Override
	public void deleteContent(int id) {
		SqlSession session=null;
		try {
			session=MyBatisUtil.openSession();
			ContentMapper mapper=session.getMapper(ContentMapper.class);
			mapper.deleteContent(id);
			session.commit();
		} catch (Exception e) {
			logger.error("ɾ������ʱ��������",e);
			session.rollback();
		}
		finally{
			session.close();
		}
	}
	
	@Override
	public Content getPreContent(int id) {
		Content content=null;
		SqlSession session=null;
		try {
			session=MyBatisUtil.openSession();
			ContentMapper mapper=session.getMapper(ContentMapper.class);
			content=mapper.getPreContent(id);			
		} catch (Exception e) {
			logger.error("�����������ʱ��������",e);			
		}
		finally{
			session.close();
		}
		return content;
	}
	
	@Override
	public Content getNextContent(int id) {
		Content content=null;
		SqlSession session=null;
		try {
			session=MyBatisUtil.openSession();
			ContentMapper mapper=session.getMapper(ContentMapper.class);
			content=mapper.getNextContent(id);			
		} catch (Exception e) {
			logger.error("�����������ʱ��������",e);			
		}
		finally{
			session.close();
		}
		return content;
	}
	
}








