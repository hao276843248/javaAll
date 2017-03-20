package CH0345C;

import java.util.Scanner;

public class trst {
	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		System.out.println("ÇëÊäÈëÒ»´®Êı×Ö:");
		String nums=input.next();
		StringBuffer str=new StringBuffer(nums);
		for (int i = str.length()-3; i >0; i=i-3) {
			str.insert(i, ',');
		}
		System.out.println(str);
	}
}
