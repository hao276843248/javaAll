import java.util.LinkedList;
import java.util.List;




public class Test2 {
	public static void main(String[] args) {
		LinkedList<Gou> gou=new LinkedList();
		gou.addFirst(new Gou("�Ʒ�","��������"));
		gou.add(new Gou("����","��������"));
		gou.add(new Gou("ŷŷ","ѩ����"));
		gou.addLast(new Gou("����","ѩ����"));
		System.out.println(gou.getFirst().getName());
		System.out.println(gou.getLast().getName());
		gou.remove(0);
		gou.remove(2);
		
	
		System.out.println("ɾ����ʣ"+gou.size());
		System.out.println("�ֱ���");
		System.out.println(gou.get(0).getName());
		System.out.println(gou.get(1).getName());
		
	}
}
