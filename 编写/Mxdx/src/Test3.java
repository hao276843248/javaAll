import java.util.Arrays;
import java.util.Scanner;
public class Test3 {
	public static void main(String[] args) {
		String[] names=new String[2];
		Scanner input=new Scanner(System.in);
		int index=0;
		do{
			System.out.println("请输入姓名，输入exit结束输入:");
			String name=input.next();
			if(name.equals("exit")){
				break;
			}
			if(index==names.length){
				names=(String[])Arrays.copyOf(names,names.length+1);
			}
			names[index]=name;
			index++;
		}while(true);
		System.out.println("-----------");		
		System.out.println(Arrays.toString(names));
	}
}