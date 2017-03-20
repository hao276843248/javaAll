import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Test {
	public static void main(String[] args) {
		List gou=new ArrayList();
		gou.add(new Gou("欧欧","雪纳瑞"));
		gou.add(new Gou("亚亚","拉布拉多"));
		gou.add(new Gou("菲菲","拉布拉多"));
		gou.add(new Gou("美美","雪纳瑞"));
		System.out.println("总共有"+gou.size()+"条狗"+"\n分别是");
		for(Object obj:gou){
			Gou a=(Gou)obj;
			System.out.println(a.getName()+"\t"+a.getLei());
		}
		Scanner input=new Scanner(System.in);
		
		System.out.println("删除前共有"+gou.size()+"条狗");
		System.out.println("请选择要删除第几个的狗狗:");
		int c=input.nextInt();
		gou.remove(c-1);
		
		
		System.out.println("删除后共有"+gou.size()+"条");
		for(Object obj:gou){
			Gou a=(Gou)obj;
			System.out.println(a.getName()+"\t"+a.getLei());
		}
		
		
		
	}
}
