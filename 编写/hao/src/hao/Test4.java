package hao;

import java.util.Scanner;

/*练习2:编写程序，模拟商场打折
	    商场在购物结算时可以根据顾客购买的金额给予适当的优惠。
	    打折的规则是:
	    如果用户购买的商品超过500元，则打九折
	要求: 1.接收用户输入的购买金额，并输出打折后金额
	       提示:判断如果用户的购买金额大于500元，则:
	       打折后金额=购买金额*0.9
	    2.接收输入前应有适当提示
	提示:
	    可以使用if结构解决*/
public class Test4 {

	public static void main(String[] args){
		Scanner input=new Scanner(System.in);
		int a;
		double b;
		do{
			System.out.println("请输入你的购买金额（输入0结束）");
			a=input.nextInt();
			if(a>500){
				b=a*0.9;
				System.out.println("获得打折优惠！打折后金额为"+b);
			}else if(a!=0){
				System.out.println("没有打折优惠！");
			}
		}while(a!=0);
	}
	
}













