package cn.bdqn.book.service;

import java.util.List;

import cn.bdqn.book.entity.Book;

public interface IBookService {
	
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
