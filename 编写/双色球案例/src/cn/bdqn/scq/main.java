package cn.bdqn.scq;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class main {
	//红球的集合
	private static List<Integer> redBalls=new ArrayList<Integer>();
	//用户自选红球号码
	private static List<Integer> chBalls=new ArrayList<Integer>();
	//用户自选篮球号码
	private static int cbBalls;
	
	private static List<Integer> redReaults=new ArrayList<Integer>();
	private static int buleReaults;
	
 	
	//初始化
	public static void init(){
		for (int i = 1; i<=33; i++) {
			redBalls.add(i);
		}
	}
	//选红球
	public static void choicerb(){
		for (int i = 1; i <=6; i++) {
			try{
				Scanner input=new Scanner(System.in);
				System.out.println("请输入第"+i+"个红球号码");
				int num=input.nextInt();
				if(num<1||num>33){
					System.out.println("红球号码必须是1-33之间");
					i--;
				}else if(chBalls.contains(num)){
					System.out.println("红球号码不能重复");
					i--;
				}else{
					chBalls.add(num);
				}
			}catch(InputMismatchException e){
				System.out.println("号码输入错误，请重新输入");
				i--;
			}
			
		}
	}
	//选篮球	
	public static void choicebb(){
		do{
			try{
				Scanner input=new Scanner(System.in);
				System.out.println("请输入篮球号码（1-16）");
				cbBalls=input.nextInt();
				if(cbBalls<1||cbBalls>16){
					System.out.println("篮球号码必须在1-16之间");
					continue;
				}
				break;
			}catch(InputMismatchException e){
				System.out.println("蓝球号码输入错误，请重新输入");
			}
			
		}while(true);
	}
	public static void printChoice(){
		System.out.print("你选择的红球号码：");
		Collections.sort(chBalls);
		for (int i = 0; i < chBalls.size(); i++) {
			System.out.print(chBalls.get(i)+"   ");
		}
		System.out.print("篮球号码：");
		System.out.println(cbBalls);
	}
	
	public static void printDraw(){
		System.out.print("抽奖的红球号码：");
		Collections.sort(redReaults);
		for (int i = 0; i < redReaults.size(); i++) {
			System.out.print(redReaults.get(i)+"   ");
		}
		System.out.print("篮球号码：");
		System.out.println(buleReaults);
	}
	
	public static void draw(){
		//
		for (int i = 0; i < 6; i++) {
			int a=(int)(Math.random()*redBalls.size());
			int num=redBalls.get(a);
			redReaults.add(num);
			redBalls.remove(new Integer(a));
		}
		buleReaults=(int) (Math.random()*16+1);
	}
	
	public static void zhongjiang(){
		int i=0;
		for (int j = 0; j < chBalls.size(); j++) {
			if(chBalls.contains(redReaults.get(j))){
				i++;
			}
		}
		
		if(i<=2&&cbBalls==buleReaults){
			System.out.println("中了六等奖");
		}else if(i==3&&cbBalls==buleReaults || i==4){
			System.out.println("中了五等奖");
		}else if(i==4&&cbBalls==buleReaults || i==5){
			System.out.println("中了四等奖");
		}else if(i==5&&cbBalls==buleReaults || i==6){
			System.out.println("中了三等奖");
		}else if(i==6){
			System.out.println("中了二等奖");
		}else if(i==6&&cbBalls==buleReaults){
			System.out.println("中了一等奖");
		}else{
			System.out.println("没有中奖");
		}
		
		System.out.println(i);
		
		
	}
		
	public static void main(String[] args) {
		//c初始化
		init();
		//自选红球
		choicerb();
		//自选篮球
		choicebb();
		//输出自选号码
		printChoice();
		
		draw();
		
		printDraw();
		
		zhongjiang();
		
		
	}
}
