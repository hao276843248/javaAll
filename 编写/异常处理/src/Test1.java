import java.util.InputMismatchException;
import java.util.Scanner;


public class Test1 {
	public static void main(String[] args) {
		try {
			Scanner input=new Scanner(System.in);
				System.out.println("�������");
				int num1=input.nextInt();
				System.out.println("���뱻����");
				int num2=input.nextInt();
				int result=num1/num2;
				String str=String.format("%d/%d=%d",num1,num2,result);
				System.out.println(str);
		} catch (InputMismatchException e) {
			System.err.println("�������ͳ�������������");
		}catch (ArithmeticException e){
			System.err.println("��������Ϊ0");
		}catch(Exception e){
			System.err.println("����δ֪�쳣");
		}
	
	}

}
