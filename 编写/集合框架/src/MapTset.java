import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;


public class MapTset {
	public static void main(String[] args) {
		Map ca=new HashMap();
		ca.put(1, "中国");
		ca.put(2, "美国");
		ca.put(3,"俄罗斯");
		ca.put(4,"英国");
		int a=ca.size();
		System.out.println("国家总数量"+a);
		System.out.println("1对应的国家是:"+(String)ca.get(1));
		System.out.println(ca.containsKey(2));
		ca.remove(2);
		System.out.println(ca.containsKey(2));
		System.out.println(ca.keySet());//key的返回值Set；
		System.out.println(ca.values());//values的返回值collection；
		
		Set keys=ca.keySet();
		Iterator iter=keys.iterator();
		while(iter.hasNext()){
			int key=(Integer) iter.next();
			System.out.println(key+"-------"+ca.get(key));
		}
	}
}
