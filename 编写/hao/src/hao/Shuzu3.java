package hao;

import java.util.Scanner;

public class Shuzu3 {

	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		String[] a=new String[]{"京","津","沪","渝","冀","豫","鄂","湘","鲁","晋","粤","桂","川","滇","黔","甘","青","陕","琼","辽","吉","黑","浙","苏","皖","赣","闽","宁","蒙","新","藏","港","澳","台"};
		String[] b=new String[]{"北京","天津","上海","重庆","河北","河南","湖北","湖南","山东","山西","广东","广西","四川","云南","贵州","甘肃","青海","陕西","海南","辽宁","吉林","黑龙江","浙江","江苏","安徽","江西","福建","宁夏","内蒙古","新疆","西藏","香港","澳门","台湾"};
		String c;
		int d=0;
		do{
			System.out.println("输入地区全称(输入0结束)");
			c=input.next();
			if("0".equals(c)){
				break;
			}
			for(int i=0;i<b.length;i++){
				if(c.equals(b[i])){
					System.out.println(a[i]);
				}
				
			}
		}while(d<10);
	}
	
}
