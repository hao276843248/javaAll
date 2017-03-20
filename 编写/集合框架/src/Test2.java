import java.util.LinkedList;
import java.util.List;




public class Test2 {
	public static void main(String[] args) {
		LinkedList<Gou> gou=new LinkedList();
		gou.addFirst(new Gou("菲菲","拉布拉多"));
		gou.add(new Gou("亚亚","拉布拉多"));
		gou.add(new Gou("欧欧","雪纳瑞"));
		gou.addLast(new Gou("美美","雪纳瑞"));
		System.out.println(gou.getFirst().getName());
		System.out.println(gou.getLast().getName());
		gou.remove(0);
		gou.remove(2);
		
	
		System.out.println("删除后还剩"+gou.size());
		System.out.println("分别是");
		System.out.println(gou.get(0).getName());
		System.out.println(gou.get(1).getName());
		
	}
}
