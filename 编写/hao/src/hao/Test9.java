package hao;

import java.util.Calendar;
import java.util.Scanner;

public class Test9 {
	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		Calendar cal=Calendar.getInstance();
		System.out.println("���������");
		int year=input.nextInt();
		System.out.println("�������·�");
		int month=input.nextInt();
		int sum=0,day,n;
		
		System.out.println("��\tһ\t��\t��\t��\t��\t��");
		
		if(month==2){
			if((year%4==0 && year%100!=0) || year%400==0){
				day=29;
			}else{
				day=28;
			}
		}else if(month==1||month==3||month==5||month==7||month==8||month==10||month==12){
			day=31;
		}else{
			day=30;
		}
		System.out.println(day);
		month=month-1;
		
		cal.set(Calendar.YEAR,year);
		cal.set(Calendar.MONTH,month);
		cal.set(Calendar.DAY_OF_MONTH,1);
		n=cal.get(Calendar.DAY_OF_WEEK);
		System.out.println(n);
		for (int i = 0; i < n-1; i++) {
			System.out.print("\t");
			
		}
		for (int i=1; i <= day; i++) {
			cal.set(Calendar.DAY_OF_MONTH,i);
			System.out.print(i+"\t");
			
			if(cal.get(Calendar.DAY_OF_WEEK)==7){
				System.out.println();
			}
			
		}
	}
}
