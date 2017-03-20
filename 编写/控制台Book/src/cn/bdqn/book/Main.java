package cn.bdqn.book;

import java.text.SimpleDateFormat;
import java.util.Scanner;

import cn.bdqn.book.service.BookServiceImpl;
import cn.bdqn.book.service.IBookService;

//���ֲ���
public class Main {

	private static IBookService bookService=new BookServiceImpl();
	private static SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
	
	public static void main(String[] args) {
		
		
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
	public static void addBook(){
	
	}
	
	//�鿴ͼ��
	//����ҵ���߼�����ȫ��ͼ���б�
	//ʹ��forѭ���������ͼ����Ϣ
	public static void showBook(){
	
	}
	
	//�޸�ͼ��
	//��ʾ�û�����Ҫ�޸ĵ�ͼ����
	//����ͼ���Ż�ȡͼ����Ϣ����ʾ�����û�ܻ�ȡ��ͼ����Ϣ����ʾ�û������Ч
	//��ʾ�û������µı��⡢���ߡ��۸񡢳���ʱ�䡢��������Ϣ
	//���޸ĺ�����ݷ�װ��ʵ�����У�����ҵ���߼����������
	public static void updateBook(){
	
	}
	
	//ɾ��ͼ��
	//��ʾ�û�����Ҫɾ����ͼ����
	//����ͼ���Ż�ȡҪɾ����ͼ����Ϣ����ʾ�����û�ܻ�ȡ��ͼ�������룬��ʾ�û������Ч
	//ѯ���û��Ƿ�ȷ��ɾ����ͼ����Ϣ�����ȷ��������ҵ���߼���ɾ������
	public static void deleteBook(){
		
	}
	
}




