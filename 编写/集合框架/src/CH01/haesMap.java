package CH01;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
public class haesMap {
	public static void main(String[] args) {
		Map map=new HashMap();
		
		System.out.println("Map集合刚创建好是，元素数量="+map.size());
		
		System.out.println("是否是空集合"+map.isEmpty());
		
		map.put("apple", "苹果");
		map.put("banana", "香蕉");
		map.put("orange", "橘子");
		map.put("mongo", "芒果");
		map.put("apple1", "苹果2");
		
		System.out.println("Map集合，元素数量="+map.size());
		System.out.println("是否是空集合"+map.isEmpty());
		
		String chn=(String)map.get("banana");
		System.out.println(chn);
		//取键
		System.out.println("-----------");
		Set key=map.keySet();
		for(Object obj:key){
			String a=(String)obj;
			System.out.println(a);
		}
		//取值
		System.out.println("-----------");
		Collection v= map.values();
		for(Object obj:v){
			String a=(String)obj;
			System.out.println(a);
		}
		//取键值对：
		Set en=map.entrySet();
		for(Object obj:en){
			Map.Entry ener=(Map.Entry)obj;
			System.out.println(ener.getKey()+"----->"+ener.getValue());
		}
		
		
	}
}
