import java.util.Scanner;


public class Test {
	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		try{
			System.out.println("输入除数");
			int num1=input.nextInt();
			System.out.println("输入被除数");
			int num2=input.nextInt();
			int result=num1/num2;
			String str=String.format("%d/%d=%d",num1,num2,result);
			System.out.println(str);
		}catch(Exception e){
			System.out.println("执行计算操作是发生异常");
		}
	
	}
}
