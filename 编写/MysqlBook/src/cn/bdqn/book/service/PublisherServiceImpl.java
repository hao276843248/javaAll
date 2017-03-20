package cn.bdqn.book.service;

import java.util.List;

import cn.bdqn.book.dao.IPublisherDAO;
import cn.bdqn.book.dao.PublisherDAOImpl;
import cn.bdqn.book.entity.Publisher;

public class PublisherServiceImpl implements IPublisherService {
	
	private IPublisherDAO publisherDAO=new PublisherDAOImpl();
	
	@Override
	public List<Publisher> findPublihser() {
		return publisherDAO.findPublihser();
	}

}
