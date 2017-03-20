package hao;
import java.util.Scanner;
public class Test3 {
	
	public static void main(String[] args){
		Scanner input=new Scanner(System.in);
		int max=0;
		int min=999999999;
		int num=1;
		do{
			System.out.println("请输入一个整数(输入0结束)");
			num=input.nextInt();
			if(num==0){
				break;
			}else{
				
				if(min>num){
					min=num;
				}
				if(max<num){
					max=num;
				}
			}
			
		}while(num!=0);	
		
		System.out.println("最大值为"+max+"最小值为"+min);
		
	}
	
}
