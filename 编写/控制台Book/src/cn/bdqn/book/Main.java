package cn.bdqn.book;

import java.text.SimpleDateFormat;
import java.util.Scanner;

import cn.bdqn.book.service.BookServiceImpl;
import cn.bdqn.book.service.IBookService;

//表现层类
public class Main {

	private static IBookService bookService=new BookServiceImpl();
	private static SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
	
	public static void main(String[] args) {
		
		
		Scanner input=new Scanner(System.in);
		
		do{
			System.out.println("欢迎使用迷图书管理器");
			System.out.println("----------------------------");
			System.out.println("1.新增图书");
			System.out.println("2.查看图书");
			System.out.println("3.修改图书");
			System.out.println("4.删除图书");			
			System.out.println("5.退出系统");
			System.out.println("----------------------------");
			System.out.print("请选择:");
			
			//接收用户选择的选项
			int choice=input.nextInt();
			
			switch(choice){
				case 1:
				{
					System.out.println("--->新增图书");
					addBook();
					break;
				}
				case 2:
				{				
					System.out.println("--->查看图书");																
					showBook();
					break;
				}
				case 3:
				{					
					System.out.println("--->修改图书");
					updateBook();
					break;
				}
				case 4:
				{
					System.out.println("--->删除图书DVD");
					deleteBook();
					break;
				}				
				case 5:
				{
					System.out.println("谢谢使用，再见！");					
					break;
				}
				default:
				{
					System.out.println("输入错误，请重新输入");
					break;
				}
			}
			
			if(choice==5){
				break;
			}else{
				//输入0返回
				do{
					System.out.println("输入0返回");
				}while(input.nextInt()!=0);
			}
			
		}while(true);
	}
	
	//新增图书
	//提示用户输入要保存的图书标题、作者、价格、出版日期和出版社
	//将数据封装成实体类对象，调用业务逻辑层保存数据
	public static void addBook(){
	
	}
	
	//查看图书
	//调用业务逻辑层获得全部图书列表
	//使用for循环遍历输出图书信息
	public static void showBook(){
	
	}
	
	//修改图书
	//提示用户输入要修改的图书编号
	//根据图书编号获取图书信息并显示，如果没能获取到图书信息，提示用户编号无效
	//提示用户输入新的标题、作者、价格、出版时间、出版社信息
	//将修改后的数据封装到实体类中，调用业务逻辑层更新数据
	public static void updateBook(){
	
	}
	
	//删除图书
	//提示用户输入要删除的图书编号
	//根据图书编号获取要删除的图书信息并显示，如果没能获取到图书西你想，提示用户编号无效
	//询问用户是否确定删除该图书信息，如果确定，调用业务逻辑层删除数据
	public static void deleteBook(){
		
	}
	
}




