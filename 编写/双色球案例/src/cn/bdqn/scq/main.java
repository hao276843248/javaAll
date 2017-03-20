package cn.bdqn.scq;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class main {
	//����ļ���
	private static List<Integer> redBalls=new ArrayList<Integer>();
	//�û���ѡ�������
	private static List<Integer> chBalls=new ArrayList<Integer>();
	//�û���ѡ�������
	private static int cbBalls;
	
	private static List<Integer> redReaults=new ArrayList<Integer>();
	private static int buleReaults;
	
 	
	//��ʼ��
	public static void init(){
		for (int i = 1; i<=33; i++) {
			redBalls.add(i);
		}
	}
	//ѡ����
	public static void choicerb(){
		for (int i = 1; i <=6; i++) {
			try{
				Scanner input=new Scanner(System.in);
				System.out.println("�������"+i+"���������");
				int num=input.nextInt();
				if(num<1||num>33){
					System.out.println("������������1-33֮��");
					i--;
				}else if(chBalls.contains(num)){
					System.out.println("������벻���ظ�");
					i--;
				}else{
					chBalls.add(num);
				}
			}catch(InputMismatchException e){
				System.out.println("���������������������");
				i--;
			}
			
		}
	}
	//ѡ����	
	public static void choicebb(){
		do{
			try{
				Scanner input=new Scanner(System.in);
				System.out.println("������������루1-16��");
				cbBalls=input.nextInt();
				if(cbBalls<1||cbBalls>16){
					System.out.println("������������1-16֮��");
					continue;
				}
				break;
			}catch(InputMismatchException e){
				System.out.println("������������������������");
			}
			
		}while(true);
	}
	public static void printChoice(){
		System.out.print("��ѡ��ĺ�����룺");
		Collections.sort(chBalls);
		for (int i = 0; i < chBalls.size(); i++) {
			System.out.print(chBalls.get(i)+"   ");
		}
		System.out.print("������룺");
		System.out.println(cbBalls);
	}
	
	public static void printDraw(){
		System.out.print("�齱�ĺ�����룺");
		Collections.sort(redReaults);
		for (int i = 0; i < redReaults.size(); i++) {
			System.out.print(redReaults.get(i)+"   ");
		}
		System.out.print("������룺");
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
			System.out.println("�������Ƚ�");
		}else if(i==3&&cbBalls==buleReaults || i==4){
			System.out.println("������Ƚ�");
		}else if(i==4&&cbBalls==buleReaults || i==5){
			System.out.println("�����ĵȽ�");
		}else if(i==5&&cbBalls==buleReaults || i==6){
			System.out.println("�������Ƚ�");
		}else if(i==6){
			System.out.println("���˶��Ƚ�");
		}else if(i==6&&cbBalls==buleReaults){
			System.out.println("����һ�Ƚ�");
		}else{
			System.out.println("û���н�");
		}
		
		System.out.println(i);
		
		
	}
		
	public static void main(String[] args) {
		//c��ʼ��
		init();
		//��ѡ����
		choicerb();
		//��ѡ����
		choicebb();
		//�����ѡ����
		printChoice();
		
		draw();
		
		printDraw();
		
		zhongjiang();
		
		
	}
}
