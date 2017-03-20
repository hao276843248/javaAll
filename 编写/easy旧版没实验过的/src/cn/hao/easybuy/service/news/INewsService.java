package cn.hao.easybuy.service.news;

import cn.hao.easybuy.entity.EasybuyNews;
import cn.hao.easybuy.util.PageBean;

public interface INewsService {

	public void addNews(EasybuyNews news);
	
	public void deleteNews(Integer id);
	
	public void updateNews(EasybuyNews news);
	
	public PageBean findNews(Integer pageIndex,Integer pageSize);
	
	public EasybuyNews getNews(Integer id);
}
