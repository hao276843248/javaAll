package cn.bdqn.collect.test;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import cn.bdqn.collect.util.HTMLHelper;

public class TestJsoupCollect {
	
	public static void main(String[] args)throws Exception {
		String target="http://www.boohee.com/food/group/1?page=1";
		String html=HTMLHelper.getHTML(target,"UTF-8");		
		
		//����HTML���ݣ����Document����
		Document doc=Jsoup.parse(html);
		
		
		Elements elements=doc.getElementsByClass("text-box");
		//�鿴��ȡ����Ԫ������
		System.out.println(elements.size());
		//����ѡ�е�Ԫ��
		for(int i=0;i<elements.size();i++){
			Element el=elements.get(i);
			//����ڲ������ĳ�����
			Element a=el.getElementsByTag("a").get(0);
			
			//��ȡtitle����
			String title=a.attr("title");
			//��ȡhref����
			String href=a.attr("href");
			
			System.out.println(title+"\t"+href);
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
