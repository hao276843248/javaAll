import java.util.HashSet;
import java.util.Set;


public class Test3 {
	public static void main(String[] args) {
		Set set=new HashSet();
		
		String s1=new String("Java");
		String s2=s1;
		String s3="java";
		int ac=123;
		set.add(s1);
		set.add(ac);
		set.add(s2);
		set.add(s3);
		for(Object a:set){
			String c=(String)a;
			System.out.println(c);
		}
		System.out.println(set.size());
	}
}
