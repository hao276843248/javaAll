import java.util.Scanner;


public class Test {
	
	public static void main(String[] args) {
		Person guest=new Person();
		System.out.println("大家好，欢迎"+guest.name+"来到地球村");
		Scanner input=new Scanner(System.in);
		System.out.println("请选择您的性别：（1、男 2、女）");
		switch(input.nextInt()){
		case 1:
			guest.gender="男";
			break;
		case 2:
			guest.gender="女";
			break;
		default:
			System.out.println("操作错误");
			return;
		}
		System.out.println("请输入你的年龄:");
		guest.age=input.nextInt();
		guest.work();
		System.out.println("请重新输入工作理念");
		String contect=input.next();
		guest.work(contect);
		System.out.println("****************************************");
		
	}
	
}














