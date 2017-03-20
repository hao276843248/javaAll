package cn.bdqn.book.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import cn.bdqn.book.entity.Book;
import cn.bdqn.book.entity.User;
import cn.bdqn.book.util.HibernateUtil;
import cn.bdqn.book.util.PageBean;

public class HibernateBookDAOImpl implements IBookDAO {

	private Logger logger=Logger.getLogger(HibernateBookDAOImpl.class);
	
	@Override
	public void addBook(Book book) {
		Session session=null;
		Transaction tx=null;
		try {
			session=HibernateUtil.getSession();
			tx=session.beginTransaction();
			session.save(book);
			tx.commit();
		} catch (Exception e) {
			logger.error("保存图书时发生错误",e);
			tx.rollback();
		}
		finally{
			session.close();
		}		
	}

	@Override
	public void updateBook(Book book) {
		Session session=null;
		Transaction tx=null;
		try {
			session=HibernateUtil.getSession();
			tx=session.beginTransaction();
			session.update(book);
			tx.commit();
		} catch (Exception e) {
			logger.error("更新图书时发生错误",e);
			tx.rollback();
		}
		finally{
			session.close();
		}
	}

	@Override
	public void deleteBook(int id) {
		Book book=new Book();
		book.setId(id);
		Session session=null;
		Transaction tx=null;
		try {
			session=HibernateUtil.getSession();
			tx=session.beginTransaction();
			session.delete(book);
			tx.commit();
		} catch (Exception e) {
			logger.error("删除图书时发生错误",e);
			tx.rollback();
		}
		finally{
			session.close();
		}
	}

	@Override
	public Book getBook(int id) {
		Book book=null;
		Session session=null;
		try {
			session=HibernateUtil.getSession();
			book=(Book)session.get(Book.class,id);
		} catch (Exception e) {
			logger.error("根据id查询图书数据时发生错误",e);
		}
		finally{
			session.close();
		}
		return book;
	}

	@Override
	public List<Book> findBook(String title) {
		List<Book> books=null;
		Session session=null;
		try {
			session=HibernateUtil.getSession();
			books=session.createQuery("from Book where title like :title")
						 .setString("title","%"+title+"%")
						 .list();
		} catch (Exception e) {
			logger.error("查询图书列表时发生错误",e);
		}
		finally{
			session.close();
		}
		return books;
	}

	@Override
	public PageBean findBook(int pageIndex, int pageSize, String title) {
		PageBean pageBean=new PageBean();
		
		Session session=null;
		try {
			session=HibernateUtil.getSession();
			//查询总行数
			int rowCount=((Number)session.createQuery("select count(*) from Book where title like :title")
										 .setString("title","%"+title+"%")
										 .uniqueResult()).intValue();
			//计算总页数			
			int pageCount=(rowCount%pageSize==0)?(rowCount/pageSize):(rowCount/pageSize+1);
			//计算第一行行号
			int firstResult=(pageIndex-1)*pageSize;
			
			//查询分页列表
			List<Book> results=session.createQuery("from Book b inner join fetch b.publisher where b.title like :title order by b.id desc")
									  .setString("title","%"+title+"%")
									  .setFirstResult(firstResult)
									  .setMaxResults(pageSize)
									  .list();
			
			//将分页参数和结果列表封装到pageBean中
			pageBean.setPageIndex(pageIndex);
			pageBean.setPageSize(pageSize);
			pageBean.setRowCount(rowCount);
			pageBean.setPageCount(pageCount);
			pageBean.setResults(results);		
						
		} catch (Exception e) {
			logger.error("查询图书分页列表时发生错误",e);
		}
		finally{
			session.close();
		}
		
		return pageBean;
	}
	
	

}







