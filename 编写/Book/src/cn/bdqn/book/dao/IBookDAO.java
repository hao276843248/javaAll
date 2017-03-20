package cn.bdqn.book.dao;

import java.util.List;

import cn.bdqn.book.entity.Book;
import cn.bdqn.book.util.PageBean;

public interface IBookDAO {

	//���ͼ��
	public void addBook(Book book);
	
	//�޸�ͼ��
	public void updateBook(Book book);
	
	//ɾ��ͼ��
	public void deleteBook(int id);
	
	//����id��ȡ����ͼ��
	public Book getBook(int id);
	
	//��ѯͼ���б�
	public List<Book> findBook(String title);
	
	//��ҳ��ѯͼ���б�
	public PageBean findBook(int pageIndex,int pageSize,String title);
}














