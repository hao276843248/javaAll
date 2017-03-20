package hao;
	/*练习4：编写程序，计算体重指数
	需求说明：
	    体重指数(BMI)，又称体质指数，是国际上常用的衡量人体胖瘦程度与健康与否的标准。
	    体重指数最早由19世纪额比利时人凯特勒提出。
	    计算公式如下:
	    体重指数BMI=体重/(身高*身高)    
	    如果是男性并且体重指数在20到25之间，则表示体重适中，否则表示不健康
	    如果是女性并且体重指数在19到24之间，则表示体重适中，否则表示不健康
	    1.编写程序，分别接收用户输如的性别、身高和体重，计算并输出用户的健康状况
	    2.接收输入前应有相应提示
	    1.接收用户输入的字符串，可以调用Scanner对象的next()方法。
	    如:String  sex = scanner.next();
	    2.判断字符串内容是否相等，应该调用String对象的equals()方法。
	    sex.equals("男") */
import java.util.Scanner;
public class Test6 {

	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		double Zhong;
		double gao;
		double BMI;
		String xingBie;
		do{
			System.out.println("请输入你的性别(输入其他结束):");
			xingBie=input.next();
			if(xingBie.equals("男")){
				System.out.println("请输入你的身高");
				gao=input.nextDouble();
				System.out.println("请输入你的体重");
				Zhong=input.nextDouble();
				BMI=Zhong/(gao*gao);
				if(20<=BMI&&BMI<=25){
					System.out.println("体重适中");
				}else {
					System.out.println("不健康");
				}
			}else if(xingBie.equals("女")){
				System.out.println("请输入你的身高");
				gao=input.nextDouble();
				System.out.println("请输入你的体重");
				Zhong=input.nextDouble();
				BMI=Zhong/(gao*gao);
				if(19<=BMI&&BMI<=24){
					System.out.println("体重适中");
				}else {
					System.out.println("不健康");
				}
			}
		}while("男".equals(xingBie)||"女".equals(xingBie));
	}
	
}









