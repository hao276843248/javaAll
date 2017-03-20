package cn.bdqn.book.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import cn.bdqn.book.entity.Book;
import cn.bdqn.book.entity.User;
import cn.bdqn.book.util.Context;
import cn.bdqn.book.util.HibernateUtil;
import cn.bdqn.book.util.PageBean;

public class BookDAOImpl implements IBookDAO {

	private Logger logger=Logger.getLogger(BookDAOImpl.class);
	
	@Override
	public void addBook(Book book) {
		Session session=null;
		//Transaction tx=null;
		try {
			//session=HibernateUtil.getSession();
			session=HibernateUtil.getCurrentSession();
			//tx=session.beginTransaction();
			session.save(book);
			//tx.commit();
		} catch (Exception e) {
			logger.error("保存图书时发生错误",e);
			throw new RuntimeException(e);
			//tx.rollback();
		}
		/*finally{
			session.close();
		}		*/
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
	public void deleteBook(int id) {
		Book book=new Book();
		book.setId(id);
		Session session=null;
		//Transaction tx=null;
		try {
			//session=HibernateUtil.getSession();
			session=HibernateUtil.getCurrentSession();
			//tx=session.beginTransaction();
			session.delete(book);
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
	public Book getBook(int id) {
		Book book=null;
		Session session=null;
		try {
			//session=HibernateUtil.getSession();
			session=HibernateUtil.getCurrentSession();
			book=(Book)session.get(Book.class,id);
		} catch (Exception e) {
			logger.error("根据id查询图书数据时发生错误",e);
			throw new RuntimeException(e);
		}
		/*finally{
			session.close();
		}*/
		return book;
	}

	@Override
	public List<Book> findBook(String title) {
		List<Book> books=null;
		Session session=null;
		try {
			//session=HibernateUtil.getSession();
			session=HibernateUtil.getCurrentSession();
			books=session.createQuery("from Book where title like :title")
						 .setString("title","%"+title+"%")
						 .setCacheable(true)
						 .list();
		} catch (Exception e) {
			logger.error("查询图书列表时发生错误",e);
			throw new RuntimeException(e);
		}
		/*finally{
			session.close();
		}*/
		return books;
	}

	@Override
	public PageBean findBook(int pageIndex, int pageSize, String title) {
		System.out.println("BookDAOImpl 线程名称:"+Thread.currentThread().getName());
		System.out.println(Context.get());
		PageBean pageBean=new PageBean();
		
		Session session=null;
		try {
			//session=HibernateUtil.getSession();
			session=HibernateUtil.getCurrentSession();
			//查询总行数
			int rowCount=((Number)session.getNamedQuery("getBookCount")
										 .setString("title","%"+title+"%")
										 .setCacheable(true)
										 .uniqueResult()).intValue();
			//计算总页数			
			int pageCount=(rowCount%pageSize==0)?(rowCount/pageSize):(rowCount/pageSize+1);
			//计算第一行行号
			int firstResult=(pageIndex-1)*pageSize;
			
			//查询分页列表
			List<Book> results=session.getNamedQuery("findBook")
									  .setString("title","%"+title+"%")
									  .setFirstResult(firstResult)
									  .setMaxResults(pageSize)
									  .setCacheable(true)
									  .list();
			
			//将分页参数和结果列表封装到pageBean中
			pageBean.setPageIndex(pageIndex);
			pageBean.setPageSize(pageSize);
			pageBean.setRowCount(rowCount);
			pageBean.setPageCount(pageCount);
			pageBean.setResults(results);		
						
		} catch (Exception e) {
			logger.error("查询图书分页列表时发生错误",e);
			throw new RuntimeException(e);
		}
		/*finally{
			session.close();
		}*/
		
		return pageBean;
	}
	
	

}







