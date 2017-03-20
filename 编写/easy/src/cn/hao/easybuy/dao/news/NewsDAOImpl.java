package cn.hao.easybuy.dao.news;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import cn.hao.easybuy.entity.EasybuyNews;
import cn.hao.easybuy.util.PageBean;

@Repository("newsDAOImpl")
public class NewsDAOImpl implements INewsDAO{

	private HibernateTemplate hibernateTemplate;
	
	@Autowired
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	@Override
	public void addNews(EasybuyNews news) {
		hibernateTemplate.save(news);
	}

	@Override
	public void deleteNews(Integer id) {
		hibernateTemplate.bulkUpdate("delete from EasybuyNews where enId=?",id);
	}

	@Override
	public void updateNews(EasybuyNews news) {
		hibernateTemplate.update(news);
	}

	@Override
	public PageBean findNews(Integer pageIndex, Integer pageSize) {
		int rowCount=hibernateTemplate.find("from EasybuyNews order by enCreateTime desc").size();
		
		//计算总页数
		int pageCount=(rowCount%pageSize==0)?(rowCount/pageSize):(rowCount/pageSize+1);
						
		//计算当前页第一行行号
		int firstResult=(pageIndex-1)*pageSize;
		DetachedCriteria detcri=DetachedCriteria.forClass(EasybuyNews.class);
		List<EasybuyNews> result=hibernateTemplate.findByCriteria(detcri, firstResult, pageSize);
		
		PageBean p=new PageBean();
		p.setPageCount(pageCount);
		p.setPageIndex(pageIndex);
		p.setPageSize(pageSize);
		p.setResults(result);
		p.setRowCount(rowCount);
		
		return p;
	}

	@Override
	public EasybuyNews getNews(Integer id) {
		
		return hibernateTemplate.get(EasybuyNews.class, id);
	}

}
