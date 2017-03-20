package cn.bdqn.dvd;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class DVDMain {
	private static DVDLuoJi dvdluoji = new DVDLuoJi();
	private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

	public static void main(String[] args) throws ParseException {
		Scanner input = new Scanner(System.in);
		int x = -1;
		do {
			System.out.println("*******欢迎使用迷你DVD系统*******");
			System.out.println("-----------------------------");
			System.out.println("-->1.增加DVD");
			System.out.println("-->2.查看DVD");
			System.out.println("-->3.删除DVD");
			System.out.println("-->4.借出DVD");
			System.out.println("-->5.归还DVD");
			System.out.println("-->6.退出DVD");
			System.out.println("-----------------------------");
			System.out.print("请选择:");
			x = input.nextInt();
			switch (x) {
			// 增加
			case 1:
				addDVD();
				break;
			// 查看
			case 2:
				showDVD();
				break;
			// 删除
			case 3:
				shanDVD();
				break;
			// 借出
			case 4:
				jieDVD();
				break;
			// 归还
			case 5:
				huanDVD();
				break;

			// 增加
			default:
				break;
			}
			if (x == 6) {
				break;
			} else {
				do {
					System.out.println("----------------------");
					System.out.println("输入0返回:");
				} while (input.nextInt() != 0);
			}

		} while (true);
	}

	public static void showDVD() {
		System.out.println("-->2.查看DVD");
		DVD[] dvds = dvdluoji.find();
		System.out.println("序号\t状态\t名称\t\t借出日期\t\t借出次数");
		for (int i = 0; i < dvds.length; i++) {
			DVD dvd = dvds[i];
			System.out.print(i + 1 + "\t");
			if (dvd.isLended() == true) {
				System.out.print("已借出\t");
			} else {
				System.out.print("可借出\t");
			}
			System.out.print(dvd.getName() + "\t\t");
			if (dvd.getDate() != null) {
				System.out.print(sdf.format(dvd.getDate()) + "\t");
			} else {
				System.out.print("----------\t");
			}
			System.out.println(dvd.getTimes() + "次");
		}
	}

	public static void shanDVD() {
		System.out.println("-->3.删除DVD");
		int index =0;
		System.out.println("请输入要删除DVD名称:");
		Scanner input = new Scanner(System.in);
		String newName = input.next();
		index=dvdluoji.delete(newName);
		if (index == -1) {
			System.out.println("没有找到信息！");
		} else if(index==1){
			System.out.println("删除成功！");
		}else{
			System.out.println("该DVD已借出！");
		}
	}

	public static void addDVD(){
		System.out.println("-->1.增加DVD");
		Scanner input=new Scanner(System.in);
		System.out.println("请输入DVD名称:");
		String newName=input.next();
		//将输入的数据封装到DVD对象中;
		DVD dvd=new DVD();
		dvd.setName(newName);
		dvdluoji.add(dvd);
		System.out.println("新增《"+newName+"》成功!");
	}

	public static void jieDVD() {
		System.out.println("---->借出DVD");
		System.out.println("请输入DVD名称");
		Scanner input=new Scanner(System.in);
		String newName = input.next();
		int n=dvdluoji.jie(newName);
		if(n==-1){
			System.out.println("没有找到匹配信息!");
		} else if (n==-2) {
			System.out.println("该DVD已借出!");
		} else {
			System.out.println("借出《" + newName+ "》成功!");
		}
	}

	public static void huanDVD() throws ParseException{
		Scanner input=new Scanner(System.in);
		System.out.println("---->归还DVD");
		System.out.println("请输入DVD名称");
		String newName = input.next();
		int n=dvdluoji.huan(newName);
		if (n == -1) {
			System.out.println("没有找到匹配信息!");
		} else if (n==-2) {
			System.out.println("该DVD已归还");
		} else {
			System.out.println("请输入归还日期:");
			Date newDate = sdf.parse(input.next());
			int zujin=dvdluoji.huan(newName, newDate);
			System.out.println("归还" + newName + "成功");
			System.out.println("应付租金"+zujin+"元");
		}
	}
}


