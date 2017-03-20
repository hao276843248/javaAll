import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;


public class Test4 {
	public static void main(String[] args) {
		Set<Gou> set=new HashSet<Gou>();
		set.add(new Gou("腊肠", "腊肠"));
		set.add(new Gou("欧欧","雪纳瑞"));
		set.add(new Gou("亚亚","拉布拉多"));
		set.add(new Gou("菲菲","拉布拉多"));
		set.add(new Gou("美美","雪纳瑞"));
		
		System.out.println("共计有"+set.size()+"条");
		for (Object a:set) {
			Gou c=(Gou)a;
			System.out.println(c.getName()+"   "+c.getLei());
		}
		
		System.out.println("______________________________");
		Iterator<Gou> s=set.iterator();
		while(s.hasNext()){
			Gou c=(Gou)s.next();
			System.out.println(c.getName()+" "+c.getLei());
		}
	}
}	
