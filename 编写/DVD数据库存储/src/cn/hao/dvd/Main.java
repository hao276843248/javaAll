package cn.hao.dvd;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import cn.hao.dvd.Service.DVDServiceImpl;
import cn.hao.dvd.entity.DVD;

public class Main {
	private static DVDServiceImpl dvdservice= new DVDServiceImpl();
	private static SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
	public static void main(String[] args) throws ParseException {
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
		List<DVD> dvds=dvdservice.findDVD();
		System.out.println("---->查看DVD");
		System.out.println("ID\t名称\t状态\t借出次数\t导演\t歌手\t借出日期\t");
		for (DVD dvd:dvds) {
			System.out.println(dvd.getId()+"\t"+dvd.getName()+"\t"+dvd.getZt()+"\t"+dvd.getCs()+"\t"+dvd.getDaoyan()+"\t"+dvd.getGeshou()+"\t"+dvd.getJieDate());
		}
	}
	
	public static void add() throws ParseException{
		DVD dvd=null;
		Scanner input=new Scanner(System.in);
		System.out.println("---->新增DVD");
		System.out.println("请选择1、影片DVD\t2、音乐DVD");
		int a=input.nextInt();
		if(a==1){
			dvd=new DVD();
			System.out.println("请输入名字");
			String name=input.next();
			dvd.setName(name);
			System.out.println("请输入状态");
			String zt=input.next();
			dvd.setZt(zt);
			System.out.println("请输入借出时间(yyyy-mm-dd)");
			String ac=input.next();
			Date asd=sdf.parse(ac);
			dvd.setJieDate(asd);
			System.out.println("请输入借出次数");
			int cs=input.nextInt();
			dvd.setCs(cs);
			System.out.println("请输入影片导演");
			String daoyan=input.next();
			dvd.setDaoyan(daoyan);
			dvdservice.addDVD(dvd);
		}else if(a==2){
			dvd=new DVD();
			System.out.println("请输入名字");
			String name=input.next();
			dvd.setName(name);
			System.out.println("请输入状态");
			String zt=input.next();
			dvd.setZt(zt);
			System.out.println("请输入借出时间(yyyy-mm-dd)");
			String ac=input.next();
			Date asd=sdf.parse(ac);
			dvd.setJieDate(asd);
			System.out.println("请输入借出次数");
			int cs=input.nextInt();
			dvd.setCs(cs);
			System.out.println("请输入歌曲歌手");
			String geshou=input.next();
			dvd.setGeshou(geshou);
			dvdservice.addDVD(dvd);
		}
		dvdservice.addDVD(dvd);
		System.out.println("新增《"+dvd.getName()+"》成功");
	}
	
	public static void delete(){
		Scanner input=new Scanner(System.in);
		System.out.println("---->删除DVD");
		System.out.println("请输入要删除DVD的ID");
		int id=input.nextInt();
		DVD dvd=dvdservice.getDVD(id);
		if(dvd==null){
			System.out.println("没有找到匹配信息！");
		}else if(dvd.getZt().equals("借出")){
			System.out.println("该DVD已借出不可删除!");
		}else{
			System.out.println("删除成功！");
			dvdservice.deleteDVD(id);
		}
	}
	
	public static void jie(){
		Scanner input=new Scanner(System.in);
		System.out.println("---->借出DVD");
		System.out.println("请输入要借出DVD的名称");
		int id=input.nextInt();
		DVD dvd=dvdservice.getDVD(id);
		if(dvd==null){
			System.out.println("没有找到匹配信息！");
		}else if(dvd.getZt().equals("借出")){
			System.out.println("该DVD已借出不可借!");
		}else{
			System.out.println("借出成功！");
			dvd.setZt("借出");
			dvd.setJieDate(new Date());
			dvdservice.updateDVD(dvd);
		}
	}
}
