import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;


public class Test4 {
	public static void main(String[] args) {
		Set<Gou> set=new HashSet<Gou>();
		set.add(new Gou("����", "����"));
		set.add(new Gou("ŷŷ","ѩ����"));
		set.add(new Gou("����","��������"));
		set.add(new Gou("�Ʒ�","��������"));
		set.add(new Gou("����","ѩ����"));
		
		System.out.println("������"+set.size()+"��");
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
