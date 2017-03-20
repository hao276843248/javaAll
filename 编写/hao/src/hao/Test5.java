package hao;
import java.util.Scanner;
	/*练习3：编写程序，计算恩格尔系数
	恩格尔系数是食品占支出总额占家庭消费支出总额的比重。
	换句话说，恩格尔系数指用来购买食品的钱占家庭总花销的百分之多少。
	一个国家越穷，每个国民用来购买食物的支出占总支出的比重就越高，
	一个国家越富，每个国民用来购买食物的支出占总支出的比重就越低。
	计算公式为:
	恩格尔系数=食品支出金额/支出总金额*100
	计算的结果是一个百分比值。
	恩格尔系数在59%以上为贫困，
	          在50%-59%之间为温饱
	      在40%-50%之间为小康
	          在30%-40%之间为富裕
	          在30%以下的为最富裕
	要求:
	1.编写程序，接收用户输入的食品支出金额和总支出金额，计算并输出贫富程度
	  (1)如果恩格尔系数值大于59，则显示输出 贫困
	  (2)如果恩格尔系数值大于50并且小于等于59，则显示输出 温饱
	  (3)如果恩格尔系数值大于40并且小于等于50，显示输出 小康
	  (4)如果恩格尔系数值大于30并且小于等于40，则显示输出 富裕
	  (5)如果恩格尔系数值小于等于30，则显示输出 最富裕
	2.接收用户输入前应有适当提示
	可以使用多个if结构解决*/
public class Test5 {

	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		double shi,zhong;
		double eGe;
		do{
			System.out.println("请输入食品支出金额");
			shi=input.nextDouble();
			System.out.println("请输入支出总金额");
			zhong=input.nextDouble();
			eGe=shi/zhong*100;
			if(eGe>59){
				System.out.println("当前贫困");
				System.out.println(eGe);
			}else if(50<eGe&&eGe<=59){
				System.out.println("当前温饱");
				System.out.println(eGe);
			}else if(40<eGe&&eGe<=50){
				System.out.println("当前小康");
				System.out.println(eGe);
			}else if(30<eGe&&eGe<=40){
				System.out.println("当前富裕");
				System.out.println(eGe);
			}else if(eGe<=30){
				System.out.println("当前最富裕");
				System.out.println(eGe);
			}
		}while(shi!=0);
	}
}



