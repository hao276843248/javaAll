import java.util.ArrayList;
import java.util.List;


public class LinkList {
	public static void main(String[] args) {
		List news=(List) new LinkList();
		NewsTitles title1=new NewsTitles(1, "ҽѧ","����Ա");
		NewsTitles title2=new NewsTitles(2, "����","����Ա");
		NewsTitles title3=new NewsTitles(3, "����","����Ա");
		news.add(title1);
		news.add(title3);
		news.add(title2);
		System.out.println("���ű���������:"+news.size());
		
		for (int i = 0; i < news.size(); i++) {
			NewsTitles a=(NewsTitles)news.get(i);
			System.out.println(a.getId()+"-"+a.getNewsName()+","+a.getCreater());
		}
	}
}
