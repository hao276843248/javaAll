import java.util.Scanner;


public class EngerText2 {
	public static void main(String[] args) {
		Scanner input=new Scanner (System.in);
		Enger ngr1=new Enger();
		System.out.println("������ʳƷ֧�����");
		ngr1.shiJ=input.nextInt();
		System.out.println("��������֧�����");
		ngr1.zongJ=input.nextInt();
		ngr1.ngr();
	}
}
