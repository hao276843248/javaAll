import java.util.InputMismatchException;
import java.util.Scanner;


public class Test1 {
	public static void main(String[] args) {
		try {
			Scanner input=new Scanner(System.in);
				System.out.println("输入除数");
				int num1=input.nextInt();
				System.out.println("输入被除数");
				int num2=input.nextInt();
				int result=num1/num2;
				String str=String.format("%d/%d=%d",num1,num2,result);
				System.out.println(str);
		} catch (InputMismatchException e) {
			System.err.println("被除数和除数必须是整数");
		}catch (ArithmeticException e){
			System.err.println("除数不能为0");
		}catch(Exception e){
			System.err.println("发生未知异常");
		}
	
	}

}
