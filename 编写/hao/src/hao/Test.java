package hao;

import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		System.out.println("请输入父亲的血型");
		String fu=input.next();
		System.out.println("请输入母亲的血型");
		String mu=input.next();
		if("a".equalsIgnoreCase(fu)&&"a".equalsIgnoreCase(mu)){
			System.out.println("子女可能有的血型:A,O");
			System.out.println("子女不可能有的血型:B,AB");
		}else if("a".equalsIgnoreCase(fu)&&"b".equalsIgnoreCase(mu)){
			System.out.println("子女可能有的血型:A,B,AB,O");
			System.out.println("子女不可能有的血型:无");
		}else if("a".equalsIgnoreCase(fu)&&"ab".equalsIgnoreCase(mu)){
			System.out.println("子女可能有的血型:A,B,AB");
			System.out.println("子女不可能有的血型:O");
		}else if("a".equalsIgnoreCase(fu)&&"o".equalsIgnoreCase(mu)){
			System.out.println("子女可能有的血型:A,O");
			System.out.println("子女不可能有的血型:B,AB");
		}else if("b".equalsIgnoreCase(fu)&&"b".equalsIgnoreCase(mu)){
			System.out.println("子女可能有的血型:B,O");
			System.out.println("子女不可能有的血型:A,AB");
		}else if("b".equalsIgnoreCase(fu)&&"o".equalsIgnoreCase(mu)){
			System.out.println("子女可能有的血型:A,B,AB");
			System.out.println("子女不可能有的血型:O");
		}else if("b".equalsIgnoreCase(fu)&&"ab".equalsIgnoreCase(mu)){
			System.out.println("子女可能有的血型:B,O");
			System.out.println("子女不可能有的血型:A,AB");
		}else if("ab".equalsIgnoreCase(fu)&&"o".equalsIgnoreCase(mu)){
			System.out.println("子女可能有的血型:A,B");
			System.out.println("子女不可能有的血型:O,AB");
		}else if("ab".equalsIgnoreCase(fu)&&"ab".equalsIgnoreCase(mu)){
			System.out.println("子女可能有的血型:A,B,AB");
			System.out.println("子女不可能有的血型:O");
		}else if("o".equalsIgnoreCase(fu)&&"o".equalsIgnoreCase(mu)){
			System.out.println("子女可能有的血型:O");
			System.out.println("子女不可能有的血型:A,B,AB");
		}
		
	}
	
}
