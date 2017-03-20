package cn.hao.book;

import java.util.Date;
import java.util.List;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import cn.hao.book.entity.Book;
import cn.hao.book.service.BookServiceImpl;
import cn.hao.book.service.IBookService;

//���ֲ���
public class Main {

	private static IBookService bookService=new BookServiceImpl();
	private static SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
	
	public static void main(String[] args) throws ParseException {
		
		
		Scanner input=new Scanner(System.in);
		
		do{
			System.out.println("��ӭʹ����ͼ�������");
			System.out.println("----------------------------");
			System.out.println("1.����ͼ��");
			System.out.println("2.�鿴ͼ��");
			System.out.println("3.�޸�ͼ��");
			System.out.println("4.ɾ��ͼ��");			
			System.out.println("5.�˳�ϵͳ");
			System.out.println("----------------------------");
			System.out.print("��ѡ��:");
			
			//�����û�ѡ���ѡ��
			int choice=input.nextInt();
			
			switch(choice){
				case 1:
				{
					System.out.println("--->����ͼ��");
					addBook();
					break;
				}
				case 2:
				{				
					System.out.println("--->�鿴ͼ��");																
					showBook();
					break;
				}
				case 3:
				{					
					System.out.println("--->�޸�ͼ��");
					updateBook();
					break;
				}
				case 4:
				{
					System.out.println("--->ɾ��ͼ��DVD");
					deleteBook();
					break;
				}				
				case 5:
				{
					System.out.println("ллʹ�ã��ټ���");					
					break;
				}
				default:
				{
					System.out.println("�����������������");
					break;
				}
			}
			
			if(choice==5){
				break;
			}else{
				//����0����
				do{
					System.out.println("����0����");
				}while(input.nextInt()!=0);
			}
			
		}while(true);
	}
	
	//����ͼ��
	//��ʾ�û�����Ҫ�����ͼ����⡢���ߡ��۸񡢳������ںͳ�����
	//�����ݷ�װ��ʵ������󣬵���ҵ���߼��㱣������
	public static void addBook() throws ParseException{
		Book book=new Book();
		Scanner input=new Scanner(System.in);
		System.out.println("���������");
		String title=input.next();
		book.setTitle(title);
		System.out.println("����������");
		String author=input.next();
		book.setAuthor(author);
		System.out.println("�������Ǯ");
		double price=input.nextDouble();
		book.setPrice(price);
		System.out.println("���������ʱ��(yyyy-mm-dd)");
		String a=input.next();
		Date pubDate=sdf.parse(a);
		book.setPubDate(pubDate);
		System.out.println("�����������");
		String publisher=input.next();
		book.setPublisher(publisher);
		bookService.addBook(book);
	}
	
	//�鿴ͼ��
	//����ҵ���߼�����ȫ��ͼ���б�
	//ʹ��forѭ���������ͼ����Ϣ
	public static void showBook(){
		List<Book> books=bookService.findBook();
		System.out.println("���"+"\t"+"����"+"\t\t"+"����"+"\t"+"������"+"\t\t"+"����ʱ��"+"\t\t"+"��Ǯ");
		for (Book book:books){
			System.out.print(book.getId()+"\t");
			System.out.print(book.getTitle()+"\t\t");
			System.out.print(book.getAuthor()+"\t");
			System.out.print(book.getPublisher()+"\t\t");
			System.out.print(book.getPubDate()+"\t\t");
			System.out.print(book.getPrice()+"\t");
			System.out.println();
		}
	}
	
	//�޸�ͼ��
	//��ʾ�û�����Ҫ�޸ĵ�ͼ����
	//����ͼ���Ż�ȡͼ����Ϣ����ʾ�����û�ܻ�ȡ��ͼ����Ϣ����ʾ�û������Ч
	//��ʾ�û������µı��⡢���ߡ��۸񡢳���ʱ�䡢��������Ϣ
	//���޸ĺ�����ݷ�װ��ʵ�����У�����ҵ���߼����������
	public static void updateBook() throws ParseException{
		Book book=new Book();
		System.out.println("������Ҫ�޸ĵı��");
		Scanner input=new Scanner(System.in);
		int id=input.nextInt();
		book=bookService.getBook(id);
		if(book==null){
			System.out.println("û���ҵ�ͼ�飬ͼ������Ч!");
		}else{
			book.setId(id);
			System.out.println("���������");
			String title=input.next();
			book.setTitle(title);
			System.out.println("����������");
			String author=input.next();
			book.setAuthor(author);
			System.out.println("�������Ǯ");
			double price=input.nextDouble();
			book.setPrice(price);
			System.out.println("���������ʱ��(yyyy-mm-dd)");
			String a=input.next();
			Date pubDate=sdf.parse(a);
			book.setPubDate(pubDate);
			System.out.println("�����������");
			String publisher=input.next();
			book.setPublisher(publisher);
			bookService.updateBook(book);
		}
	}
	
	//ɾ��ͼ��
	//��ʾ�û�����Ҫɾ����ͼ����
	//����ͼ���Ż�ȡҪɾ����ͼ����Ϣ����ʾ�����û�ܻ�ȡ��ͼ�������룬��ʾ�û������Ч
	//ѯ���û��Ƿ�ȷ��ɾ����ͼ����Ϣ�����ȷ��������ҵ���߼���ɾ������
	public static void deleteBook(){
		System.out.println("������Ҫɾ����ͼ����");
		Scanner input=new Scanner(System.in);
		int id=input.nextInt();
		Book book=bookService.getBook(id);
		if(book==null){
			System.out.println("û���ҵ�ͼ�飬ͼ������Ч��");
		}else{
			bookService.deleteBook(id);
		}
	}
}




