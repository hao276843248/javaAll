import java.util.Scanner;


public class Test {
	
	public static void main(String[] args) {
		Person guest=new Person();
		System.out.println("��Һã���ӭ"+guest.name+"���������");
		Scanner input=new Scanner(System.in);
		System.out.println("��ѡ�������Ա𣺣�1���� 2��Ů��");
		switch(input.nextInt()){
		case 1:
			guest.gender="��";
			break;
		case 2:
			guest.gender="Ů";
			break;
		default:
			System.out.println("��������");
			return;
		}
		System.out.println("�������������:");
		guest.age=input.nextInt();
		guest.work();
		System.out.println("���������빤������");
		String contect=input.next();
		guest.work(contect);
		System.out.println("****************************************");
		
	}
	
}














