package cn.hao.cms.service.content;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import cn.bdqn.mybatis.plugin.PageParam;
import cn.hao.cms.entity.Content;
import cn.hao.cms.mapper.content.ContentMapper;
import cn.hao.cms.util.MyBatisUtil;



public class ContentServiceImpl implements IContentService{
	private Logger logger= Logger.getLogger(ContentServiceImpl.class);
	@Override
	public List<Content> findContent(PageParam p,String title,String cname,Integer cid) {
		SqlSession session=null;
		List<Content> cs=null;
		try {
			session=MyBatisUtil.openSession();
			ContentMapper mapper=session.getMapper(ContentMapper.class);
			cs=mapper.findContent(p,title,cname,cid);
		} catch (Exception e) {
			logger.error("获得内容时发生错误",e);
			e.printStackTrace();
		}finally{
			session.close();
		}
		return cs;
	}

	@Override
	public Content getContent(int id) {
		SqlSession session=null;
		Content cs=null;
		try {
			session=MyBatisUtil.openSession();
			ContentMapper mapper=session.getMapper(ContentMapper.class);
			cs=mapper.getContent(id);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("获得一个内容时发生错误",e);
		}finally{
			session.close();
		}
		return cs;
	}

	@Override
	public void delContent(int id) {
		SqlSession session=null;
		try {
			session=MyBatisUtil.openSession();
			ContentMapper mapper=session.getMapper(ContentMapper.class);
			mapper.delContent(id);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("删除内容时发生错误",e);
			session.rollback();
		}finally{
			session.close();
		}
	}

	@Override
	public void updateContent(Content c) {
		SqlSession session=null;
		try {
			session=MyBatisUtil.openSession();
			ContentMapper mapper=session.getMapper(ContentMapper.class);
			mapper.updateContent(c);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("更改内容时发生错误",e);
			session.rollback();
		}finally{
			session.close();
		}
	}

	@Override
	public void addContent(Content c) {
		SqlSession session=null;
		try {
			session=MyBatisUtil.openSession();
			ContentMapper mapper=session.getMapper(ContentMapper.class);
			mapper.addContent(c);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("添加内容时发生错误",e);
			session.rollback();
		}finally{
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
			logger.error("获得上条内容时发生错误",e);		
			e.printStackTrace();
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
			logger.error("获得下条内容时发生错误",e);
			e.printStackTrace();
		}
		finally{
			session.close();
		}
		return content;
	}
	
}
