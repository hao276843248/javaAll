import java.util.ArrayList;
import java.util.List;


public class LinkList {
	public static void main(String[] args) {
		List news=(List) new LinkList();
		NewsTitles title1=new NewsTitles(1, "医学","管理员");
		NewsTitles title2=new NewsTitles(2, "电脑","管理员");
		NewsTitles title3=new NewsTitles(3, "数码","管理员");
		news.add(title1);
		news.add(title3);
		news.add(title2);
		System.out.println("新闻标题总数量:"+news.size());
		
		for (int i = 0; i < news.size(); i++) {
			NewsTitles a=(NewsTitles)news.get(i);
			System.out.println(a.getId()+"-"+a.getNewsName()+","+a.getCreater());
		}
	}
}
