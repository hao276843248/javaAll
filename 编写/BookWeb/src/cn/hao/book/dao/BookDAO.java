package cn.hao.book.dao;


import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;


import cn.hao.book.entity.Book;
import cn.hao.book.entity.Users;
import cn.hao.book.util.HibernateUtil;
import cn.hao.book.util.PageBean;

public class BookDAO implements IBookDAO{

	private Logger logger= Logger.getLogger(BookDAO.class);
	
	public Users login(String loginName) {
		Session session=null;
		Users u=null;
		try {
			//session=HibernateUtil.getSession();
			session=HibernateUtil.getCurrentSession();
			u=(Users)session.createQuery("from Users where loginName=:loginName")
					 .setString("loginName",loginName)
					 .setCacheable(true)
					 .uniqueResult();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		/*	
		finally{
		session.close();
		}
		*/
		return u;
	}
	

	@Override
	public void addBook(Book book) {
		Session session=null;
		//Transaction tx=null;
		
		try {
			//session=HibernateUtil.getSession();
			//tx=session.beginTransaction();
			session=HibernateUtil.getCurrentSession();
			session.save(book);
			//tx.commit();
		} catch (Exception e) {
			logger.error("保存图书时发生错误",e);
			throw new RuntimeException(e);
			//tx.rollback();
		}
		/*finally{
			session.close();
		}*/
	}

	@Override
	public Book getBookID(int id) {
		Book book=null;
		Session session=null;
		try {
			//session=HibernateUtil.getSession();
			session=HibernateUtil.getCurrentSession();
			
			book=(Book)session.createQuery("from Book where id=:id")
				.setInteger("id", id)
				.uniqueResult();
		} catch (Exception e) {
			logger.error("根据id获取图书时发生错误",e);
			throw new RuntimeException(e);
		}
		/*finally{
			session.close();
		}*/
		return book;
	}

	@Override
	public void deleteBook(int id) {
		Session session=null;
		//Transaction tx=null;
		Book b=new Book();
		b.setId(id);
		try {
			//session=HibernateUtil.getSession();
			session=HibernateUtil.getCurrentSession();
			//tx=session.beginTransaction();
			session.delete(b);
			//tx.commit();
		} catch (Exception e) {
			logger.error("删除图书时发生错误",e);
			throw new RuntimeException(e);
			//tx.rollback();
		}
		/*finally{
			session.close();
		}*/
		
	}

	@Override
	public void updateBook(Book book) {
		Session session=null;
		//Transaction tx=null;
		try {
			//session=HibernateUtil.getSession();
			session=HibernateUtil.getCurrentSession();
			//tx=session.beginTransaction();
			session.update(book);
			//tx.commit();
		} catch (Exception e) {
			logger.error("更新图书时发生错误",e);
			throw new RuntimeException(e);
			//tx.rollback();
		}
		/*finally{
			session.close();
		}*/
		
	}

	@Override
	public PageBean findBook(int pageIndex, int pageSize, String title) {
		PageBean pageBean=new PageBean();
		Session session=null;
		List<Book> books=null;
		try {
			//session=HibernateUtil.getSession();
			session=HibernateUtil.getCurrentSession();
			
			int rowCount=((Number)session.createQuery("Select count(*) from Book where title like :title")
					.setString("title","%"+title+"%")
					.setCacheable(true)
					.uniqueResult()).intValue();
			
			int pageCount=(rowCount%pageSize==0)?(rowCount/pageSize):(rowCount/pageSize+1);
			//计算第一行行号
			int firstResult=(pageIndex-1)*pageSize;
			
			books=session.createQuery("from Book b inner join fetch b.publisher where b.title like :title order by b.id desc")
				   .setString("title", "%"+title+"%")
				   .setFirstResult(firstResult)
				   .setMaxResults(pageSize)
				   .setCacheable(true)
				   .list();
			pageBean.setPageIndex(pageIndex);
			pageBean.setPageSize(pageSize);
			pageBean.setRowCount(rowCount);
			pageBean.setPageCount(pageCount);
			pageBean.setResult(books);	
		} catch (Exception e) {
			logger.error("分页查询出错", e);
			throw new RuntimeException(e);
		}
		/*finally{
			session.close();
		}*/
		return pageBean;
	}
}
