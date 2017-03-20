	package hao;

import java.util.Scanner;

public class Test8 {

	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		String[][] ku={{"苹果","apple"},{"香蕉","banana"},{"橘子","orange"},{"学生","student"},{"老师","teacher"},{"时间","time"},{"男孩","boy"},{"女孩","girl"},{"班级","class"},{"好","good"},{"书","book"},{"来","com"},{"去","go"}};
		int shu=5;
		int[] zu =new int[5];
		out:for(int i=0;i<5;i++){
				int random=(int)(Math.random()*13);
				for(int j=0;j<i;j++){
					if(zu[j]==random){
						i--;
						continue out;
					}
				}
				zu[i]=random;
				System.out.println("请输入["+ku[zu[i]][0]+"]的英文单词：");
				String a=input.next();
				if(a.equalsIgnoreCase(ku[zu[i]][1])){
					System.out.println("答对了!");
				}else{
					System.out.println("答错了!");
					shu--;
				}
		}
		System.out.println("------------------------------------");
		System.out.println("测试结束，答对"+shu+"题，共5题");
	}
}
