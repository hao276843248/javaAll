package cn.bdqn.collect.test;

import jodd.jerry.Jerry;
import jodd.lagarto.dom.Node;
import cn.bdqn.collect.util.HTMLHelper;

public class TestJerryCollect {

	public static void main(String[] args)throws Exception {
		String target="http://www.boohee.com/food/group/1?page=1";
		String html=HTMLHelper.getHTML(target,"UTF-8");
		
		//解析HTML代码
		Jerry jerry=Jerry.jerry(html);
		//提取超链接元素
		Jerry links=jerry.$(".text-box a");
		//获得选中元素的数量
		System.out.println(links.size());
		for(int i=0;i<links.size();i++){
			Node node=links.get(i);
			//提取title属性
			String title=node.getAttribute("title");
			//提取href属性
			String href=node.getAttribute("href");
			System.out.println(title+"\t"+href);
		}
		
	}
	
}







