import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;


public class MapTset {
	public static void main(String[] args) {
		Map ca=new HashMap();
		ca.put(1, "�й�");
		ca.put(2, "����");
		ca.put(3,"����˹");
		ca.put(4,"Ӣ��");
		int a=ca.size();
		System.out.println("����������"+a);
		System.out.println("1��Ӧ�Ĺ�����:"+(String)ca.get(1));
		System.out.println(ca.containsKey(2));
		ca.remove(2);
		System.out.println(ca.containsKey(2));
		System.out.println(ca.keySet());//key�ķ���ֵSet��
		System.out.println(ca.values());//values�ķ���ֵcollection��
		
		Set keys=ca.keySet();
		Iterator iter=keys.iterator();
		while(iter.hasNext()){
			int key=(Integer) iter.next();
			System.out.println(key+"-------"+ca.get(key));
		}
	}
}
