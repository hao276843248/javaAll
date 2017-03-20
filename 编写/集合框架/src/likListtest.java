import java.util.LinkedList;


public class likListtest {
	public static void main(String[] args) {
		LinkedList news=new LinkedList();
		NewsTitles title1=new NewsTitles(1,"医学","管理员");
		NewsTitles title2=new NewsTitles(2,"娱乐","管理员");
		NewsTitles title3=new NewsTitles(3,"交通","管理员");
		
		news.add(title1);
		news.addFirst(title3);
		news.addLast(title2);
		news.add(title1);
		
		for (int i = 0; i < news.size(); i++) {
			NewsTitles a=(NewsTitles) news.get(i);
			System.out.println("第"+i+"条"+a.getId()+"--"+a.getNewsName()+"--"+a.getCreater());
		}
		
		System.out.println("新闻标题数"+news.size());
		
		NewsTitles first=(NewsTitles)news.getFirst();
		System.out.println("头条新闻"+first.getNewsName());
		
		NewsTitles last=(NewsTitles)news.getLast();
		System.out.println("末条新闻"+last.getNewsName());
		
		last=(NewsTitles)news.removeLast();
		System.out.println(last.getNewsName());
		
		System.out.println(news.size());
		
	}
}
