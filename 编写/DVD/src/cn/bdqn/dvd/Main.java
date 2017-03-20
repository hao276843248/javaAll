package cn.bdqn.dvd;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.bdqn.dvd.Service.DVDService;
import cn.bdqn.dvd.entity.DVD;

public class Main {
	private static DVDService dvdservice;
	private static SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
	public static void main(String[] args) throws ParseException {
		ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
		dvdservice=(DVDService) ctx.getBean("serviceDVD");
		Scanner input=new Scanner(System.in);
		do {
			System.out.println("欢  迎  使  用  迷  你   DVD 管  理  器");
			System.out.println("----------------------");
			System.out.println("1. 新 增 DVD");
			System.out.println("2. 查 看 DVD");
			System.out.println("3. 删 除 DVD");
			System.out.println("4. 借 出 DVD");
			System.out.println("5. 归 还 DVD");
			System.out.println("6. 退 出 DVD");
			System.out.println("----------------------");
			System.out.println("请选择");
			int x=input.nextInt();
			switch (x){ 
				// 增加
				case 1:
					add();
					break;
				// 查看
				case 2:
					showDVD();
					break;
				// 删除
				case 3:
					delete();
					break;
				// 借出
				case 4:
					jie();
					break;
				// 归还
				case 5:
					huan();
					break;
				default:
					break;
			}
			if(x==6){
				break;
			}else{
				do{
					System.out.println("----------------------");
					System.out.println("请输入0返回");
				}while(input.nextInt()!=0);
			}
		} while (true);
	}
 	
	public static void showDVD() throws ParseException{
		DVD[] dvds=dvdservice.find();
		System.out.println("---->查看DVD");
		System.out.println("序号\t名称\t状态\t借出日期\t\t借出次数\t导演/歌手");
		for (int i = 0; i < dvds.length; i++) {
			DVD dvd = dvds[i];
			if(!dvd.isZt()){
				System.out.print(i+1+"\t"+dvd.getName()+"\t"+"可借出"+"\t");
			}else{
				System.out.print(i+1+"\t"+dvd.getName()+"\t"+"以借出"+"\t");
			}
			if(dvd.getDate()==null){
				System.out.print("----------");
			}else{
				System.out.print(sdf.format(dvd.getDate()));
			}
			System.out.print("\t"+dvd.getCs());
			if(dvd instanceof MovieDVD){
				MovieDVD movie=(MovieDVD)dvd;
				System.out.println("\t"+movie.getDirector()+"/--");
			}else if(dvd instanceof MuiscDVD){
				MuiscDVD muisc=(MuiscDVD)dvd;
				System.out.println("\t--/"+muisc.getSinger());
			}
		}
	}
	
	public static void add(){
		DVD dvd=null;
		Scanner input=new Scanner(System.in);
		System.out.println("---->新增DVD");
		System.out.println("请选择1、影片DVD\t2、音乐DVD");
		do{
			int x=input.nextInt();
			if(x==1){
				System.out.println("请输入影片名称:");
				String newname=input.next();
				System.out.println("请输入影片导演:");
				String d=input.next(); 
				dvd=new MovieDVD(newname,false,null,0,d);
				break;
			}else if(x==2){
				System.out.println("请输入音乐名称:");
				String newname=input.next();
				System.out.println("请输入音乐歌手:");
				String d=input.next(); 
				dvd=new MuiscDVD(newname,false,null,0,d);
				break;
			}
			System.out.println("输入错误请重新输入!");
		}while(true);
		dvdservice.add(dvd);
		System.out.println("新增《"+dvd.getName()+"》成功");
	}
	
	public static void delete(){
		Scanner input=new Scanner(System.in);
		System.out.println("---->删除DVD");
		System.out.println("请输入要删除DVD的名称");
		String newName=input.next();
		int x=dvdservice.delete(newName);
		if(x==-1){
			System.out.println("没有找到匹配信息！");
		}else if(x==-2){
			System.out.println("该DVD已借出不可删除!");
		}else{
			System.out.println("删除成功！");
		}
	}
	
	public static void jie(){
		Scanner input=new Scanner(System.in);
		System.out.println("---->借出DVD");
		System.out.println("请输入要借出DVD的名称");
		String newName=input.next();
		int x=dvdservice.delete(newName);
		if(x==-1){
			System.out.println("没有找到匹配信息！");
		}else if(x==-2){
			System.out.println("该DVD已借出不可借!");
		}else{
			System.out.println("借出成功！");
		}
	}

	public static void huan() throws ParseException{
		Scanner input=new Scanner(System.in);
		
		System.out.println("---->归还DVD");
		System.out.println("请输入要归还DVD的名称");
		String newName=input.next();
		int x=dvdservice.huan(newName);
		if(x==-1){
			System.out.println("没有找到匹配信息！");
		}else if(x==-2){
			System.out.println("该DVD没有借出!");
		}else{
			int zujin=dvdservice.huan(newName);
			System.out.println("归还成功！租金应付"+zujin+"元");
		}
	}
}
