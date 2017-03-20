package hao;
import java.util.*;
public class Texttt{
	public static void main(String[] args) {
		String[] a=new String[5];
		Scanner input=new Scanner(System.in);
		for (int i = 0; i < 5; i++) {
			System.out.println("ÇëÊäÈëµÚ"+(i+1)+"¸ö×Ö");
			a[i]=input.next();	
		}
		for (int i = 4 ; i>=0; i--) {
			System.out.println(a[i]);
		}
	}
}
