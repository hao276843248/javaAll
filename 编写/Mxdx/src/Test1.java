import java.util.Scanner;


public class Test1 {
	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		Ren ren1=new Ren();
		System.out.println("���������� :");
		String a =input.next();
		ren1.setName(a);
		System.out.println("�������Ա�:");
		String g=input.next();
		ren1.setGender(g);
		System.out.println("����������:");
		ren1.setAge(input.nextInt());
		ren1.Show();
	}
}
