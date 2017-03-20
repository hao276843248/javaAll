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
		
		//解析HTML内容，获得Document对象
		Document doc=Jsoup.parse(html);
		
		
		Elements elements=doc.getElementsByClass("text-box");
		//查看提取到的元素数量
		System.out.println(elements.size());
		//遍历选中的元素
		for(int i=0;i<elements.size();i++){
			Element el=elements.get(i);
			//获得内部包含的超链接
			Element a=el.getElementsByTag("a").get(0);
			
			//提取title属性
			String title=a.attr("title");
			//提取href属性
			String href=a.attr("href");
			
			System.out.println(title+"\t"+href);
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
