package CH01;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
public class haesMap {
	public static void main(String[] args) {
		Map map=new HashMap();
		
		System.out.println("Map���ϸմ������ǣ�Ԫ������="+map.size());
		
		System.out.println("�Ƿ��ǿռ���"+map.isEmpty());
		
		map.put("apple", "ƻ��");
		map.put("banana", "�㽶");
		map.put("orange", "����");
		map.put("mongo", "â��");
		map.put("apple1", "ƻ��2");
		
		System.out.println("Map���ϣ�Ԫ������="+map.size());
		System.out.println("�Ƿ��ǿռ���"+map.isEmpty());
		
		String chn=(String)map.get("banana");
		System.out.println(chn);
		//ȡ��
		System.out.println("-----------");
		Set key=map.keySet();
		for(Object obj:key){
			String a=(String)obj;
			System.out.println(a);
		}
		//ȡֵ
		System.out.println("-----------");
		Collection v= map.values();
		for(Object obj:v){
			String a=(String)obj;
			System.out.println(a);
		}
		//ȡ��ֵ�ԣ�
		Set en=map.entrySet();
		for(Object obj:en){
			Map.Entry ener=(Map.Entry)obj;
			System.out.println(ener.getKey()+"----->"+ener.getValue());
		}
		
		
	}
}
