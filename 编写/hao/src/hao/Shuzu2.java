package hao;
import java.util.Scanner;
public class Shuzu2 {
	public static void main(String[] args){
		Scanner input=new Scanner(System.in);
		System.out.println("������10 ������");
		String[] a=new String[10];
		String[] b=new String[10];
		for(int i=0;i<10;i++){
			System.out.println("�������"+(i+1)+"������");
			a[i]=input.next();
		}
		for(int i=0;i<10;i++){
			b[i]=a[i];
		}
		for(int i=0;i<10;i++){
			for(int j=0;j<i;j++){
				if(a[i].equals(b[j])){
					System.out.print("����"+a[i]+" ");
				}
			}
		}
		System.out.println();
		for(int i=0;i<10;i++){
			System.out.print(a[i]+",");
		}
		System.out.println();
	}
}
