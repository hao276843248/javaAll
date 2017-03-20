package hao;

import java.util.Scanner;

public class Test7 {
	public static void main(String[] args) {
		Scanner input=new Scanner (System.in);
		int a;
		int e=-1;
		String d;
		String[][] b={{"9787111213826","Java编程思想"},{"9787302209768","Java Web整合开发王者归来"},{"9787121213137","Java程序员面试宝典"},{"9787512361881","Java网络编程"},{"9787302388982","Java 学习笔记"},{"9787121093739","精通Hibernate"},{"9787115321954","Java程序员修炼之道"},{"9787115356307","Java学习指南"},{"9787115351869","Java设计模式深入研究"},{"9787121202506","Java网络编程"}};
		double[] c={71.50,74.60,36.50,57.50,57.10,63.80,75.70,107.20,40.20,66.60};
		do{
			System.out.println("*******************欢迎使用图书信息查询系统*******************");
			System.out.println("1.按ISBN查询");
			System.out.println("2.按价格查询");
			System.out.println("3.退出系统");
			System.out.println("------------------------------------------------------");
			System.out.println("请选择:");
			a=input.nextInt();
			if(a==1){
				System.out.println("请输入ISBN号:");
				d=input.next();
				for(int i=0;i<10;i++){
					if(d.equals(b[i][0])){
						e=i;
					}
				}
				System.out.println("查询结果如下:");
				System.out.println("------------------------------------------------------");
				System.out.println("ISBN               标题                                             价钱");
				if(e!=-1){
					System.out.println(b[e][0]+"     "+b[e][1]+"     "+c[e]);
				}else{
					System.out.println("对不起，没有找到相关记录！");
				}
				System.out.println("");
				
			}else if(a==2){
				System.out.println("请输入最低价");
				double i=input.nextDouble();
				System.out.println("请输入最高价");
				double j=input.nextDouble();
				System.out.println("查询结果如下:");
				System.out.println("------------------------------------------------------");
				System.out.println("ISBN               标题                                             价钱");
				for(int k=0;k<10;k++){
					if(i<c[k]&&c[k]<j){
						System.out.println(b[k][0]+"     "+b[k][1]+"       "+c[k]);
						e=k;
					}
				}
				if(e==-1){
					System.out.println("对不起，没有找到相关记录！");
				}
				System.out.println("");
			}
		}while(a!=3);
		
	}
	
}
