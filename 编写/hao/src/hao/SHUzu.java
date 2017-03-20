package hao;

import java.util.Scanner;
	/*练习一:
	创建一个数组，存入四个同学的姓名
	在原数组内容的基础上，追加一个新同学的姓名
	步骤:
	1.创建原数组，存入四个同学姓名
	2.创建新数组，长度为原数组长度+1
	3.使用循环将原数组内容复制到新数组中
	4.将新同学姓名添加到新数组最后一个元素中*/
public class SHUzu {

	public static void main(String[] args){
		Scanner input=new Scanner(System.in);
		String[] a=new String[]{"赵","李","王","张"};
		String[] b=new String[5];
		for(int i=0;i<a.length;i++){
			System.out.print(a[i]);
			b[i]=a[i];
		}System.out.println();
		System.out.println("请输入新同学的名字");
		b[4] =input.next();
		for(int i=0;i<5;i++){
			System.out.print(b[i]+",");
		}
		System.out.println();
	}
	
}
