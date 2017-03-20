package cn.hao.easybuy.dao.comment;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import cn.hao.easybuy.entity.EasybuyComment;
import cn.hao.easybuy.util.PageBean;
@Repository("commentDAOImpl")
public class CommentDAOImpl implements ICommentDAO{

	private HibernateTemplate hibernateTemplate;
	@Autowired
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	@Override
	public void addComment(EasybuyComment comment) {
		hibernateTemplate.save(comment);
	}

	@Override
	public PageBean findComment(Integer pageIndex,Integer pageSize) {
		//计算总行数
		int rowCount=hibernateTemplate.find("from EasybuyComment order by ecId").size();
		//计算总页数
		int pageCount=(rowCount%pageSize==0)?(rowCount/pageSize):(rowCount/pageSize+1);
						
		//计算当前页第一行行号
		int firstResult=(pageIndex-1)*pageSize;
		
		DetachedCriteria detCri=DetachedCriteria.forClass(EasybuyComment.class);
		detCri.addOrder(Order.desc("ecId"));
		List<EasybuyComment> results=hibernateTemplate.findByCriteria(detCri, firstResult, pageSize);
		
		PageBean p=new PageBean();
		p.setPageCount(pageCount);
		p.setPageIndex(pageIndex);
		p.setPageSize(pageSize);
		p.setResults(results);
		p.setRowCount(rowCount);
		
		return p;
	}

	@Override
	public void updateComment(EasybuyComment comment) {
		hibernateTemplate.update(comment);
	}

	@Override
	public void delete(Integer id) {
		hibernateTemplate.bulkUpdate("delete from EasybuyComment where ecId=?",id);
	}
	@Override
	public EasybuyComment get(Integer id) {

		return hibernateTemplate.get(EasybuyComment.class,id);
	}

}
