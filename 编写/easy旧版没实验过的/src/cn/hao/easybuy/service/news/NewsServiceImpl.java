package cn.hao.easybuy.service.news;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.hao.easybuy.dao.news.INewsDAO;
import cn.hao.easybuy.entity.EasybuyNews;
import cn.hao.easybuy.util.PageBean;

@Service("newsServiceImpl")
public class NewsServiceImpl implements INewsService{

	private INewsDAO newsDAOImpl;
	@Autowired
	public void setNewsDAOImpl(INewsDAO newsDAOImpl) {
		this.newsDAOImpl = newsDAOImpl;
	}
	
	@Override
	public void addNews(EasybuyNews news) {
		newsDAOImpl.addNews(news);
	}

	@Override
	public void deleteNews(Integer id) {
		newsDAOImpl.deleteNews(id);
	}

	@Override
	public void updateNews(EasybuyNews news) {
		newsDAOImpl.updateNews(news);
	}

	@Override
	public PageBean findNews(Integer pageIndex, Integer pageSize) {
		return newsDAOImpl.findNews(pageIndex, pageSize);
		 
	}

	@Override
	public EasybuyNews getNews(Integer id) {
		return newsDAOImpl.getNews(id);
	}
	
	
}
