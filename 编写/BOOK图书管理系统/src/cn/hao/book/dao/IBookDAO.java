package cn.hao.book.dao;

import java.util.List;

import cn.hao.book.entity.Book;

public interface IBookDAO {
	//���ͼ��
	public void addBook(Book book);
	
	//����ͼ��
	public void updateBook(Book book);
	
	//ɾ��ͼ��
	public void deleteBook(int id);
	
	//����ID���ҵ���ͼ����Ϣ
	public Book getBook(int id);
	
	//����ȫ������
	public List<Book> findBook();
	

}
