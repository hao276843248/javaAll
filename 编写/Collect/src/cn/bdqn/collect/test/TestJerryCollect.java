package cn.bdqn.collect.test;

import jodd.jerry.Jerry;
import jodd.lagarto.dom.Node;
import cn.bdqn.collect.util.HTMLHelper;

public class TestJerryCollect {

	public static void main(String[] args)throws Exception {
		String target="http://www.boohee.com/food/group/1?page=1";
		String html=HTMLHelper.getHTML(target,"UTF-8");
		
		//����HTML����
		Jerry jerry=Jerry.jerry(html);
		//��ȡ������Ԫ��
		Jerry links=jerry.$(".text-box a");
		//���ѡ��Ԫ�ص�����
		System.out.println(links.size());
		for(int i=0;i<links.size();i++){
			Node node=links.get(i);
			//��ȡtitle����
			String title=node.getAttribute("title");
			//��ȡhref����
			String href=node.getAttribute("href");
			System.out.println(title+"\t"+href);
		}
		
	}
	
}







