import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;


public class SetTest {
	public static void main(String[] args) {
		Set news=new HashSet();
		NewsTitles title1=new NewsTitles(1,"医学","管理员");
		NewsTitles title2=new NewsTitles(2,"娱乐","管理员");
		NewsTitles title3=new NewsTitles(3,"交通","管理员");
		
		news.add(title1);
		news.add(title3);
		news.add(title2);
		news.add(title1);
		
		System.out.println("新闻标题数"+news.size());
		
		for(Object o:news){
			NewsTitles a=(NewsTitles)o;
			System.out.println(a.getId()+" "+a.getNewsName()+" "+a.getCreater());
		}
		
		System.out.println(news.size());
		
		Iterator itor=news.iterator();
		while(itor.hasNext()){
			NewsTitles a=(NewsTitles)itor.next();
			System.out.println(a.getId()+" "+a.getNewsName()+" "+a.getCreater());
		}
	}
	
}
