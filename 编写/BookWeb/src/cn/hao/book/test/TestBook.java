package cn.hao.book.test;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import cn.hao.book.dao.BookDAO;
import cn.hao.book.dao.JDBCBookDAO;
import cn.hao.book.dao.JDBCIBookDAO;
import cn.hao.book.dao.publisherImlp;
import cn.hao.book.entity.Book;
import cn.hao.book.entity.Publisher;
import cn.hao.book.servlet.publisher;
import cn.hao.book.util.HibernateUtil;
import cn.hao.book.util.PageBean;

public class TestBook {

	
	@Test
	public void findbook(){
		List<Publisher> books=new ArrayList<Publisher>();
		BookDAO a=new BookDAO();
		publisherImlp p=new publisherImlp();
		books=p.findpublisher();
		for (Publisher b:books) {
			System.out.println(b.getName());
		}
	}
	
}
