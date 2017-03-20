import java.util.ArrayList;
import java.util.Collections;
import java.util.List;



public class CollectionsTest {
	public static void main(String[] args) {
		List<String> list=new ArrayList<String>();
		list.add("asdasa");
		list.add("basxcs");
		list.add("csdas2");
		list.add("dwe3saa");
		list.add("vzxc3saa");
		list.add("zxrt3saa");
		
		
		System.out.println(Collections.max(list));
		System.out.println(Collections.min(list));
		System.out.println("------------------------");
		Collections.sort(list);
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		
		System.out.println("********************");
		Collections.reverse(list);
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}
}
