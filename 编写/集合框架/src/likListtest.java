import java.util.LinkedList;


public class likListtest {
	public static void main(String[] args) {
		LinkedList news=new LinkedList();
		NewsTitles title1=new NewsTitles(1,"ҽѧ","����Ա");
		NewsTitles title2=new NewsTitles(2,"����","����Ա");
		NewsTitles title3=new NewsTitles(3,"��ͨ","����Ա");
		
		news.add(title1);
		news.addFirst(title3);
		news.addLast(title2);
		news.add(title1);
		
		for (int i = 0; i < news.size(); i++) {
			NewsTitles a=(NewsTitles) news.get(i);
			System.out.println("��"+i+"��"+a.getId()+"--"+a.getNewsName()+"--"+a.getCreater());
		}
		
		System.out.println("���ű�����"+news.size());
		
		NewsTitles first=(NewsTitles)news.getFirst();
		System.out.println("ͷ������"+first.getNewsName());
		
		NewsTitles last=(NewsTitles)news.getLast();
		System.out.println("ĩ������"+last.getNewsName());
		
		last=(NewsTitles)news.removeLast();
		System.out.println(last.getNewsName());
		
		System.out.println(news.size());
		
	}
}
