package cn.bdqn.collect.test;

import jodd.jerry.Jerry;
import jodd.lagarto.dom.Node;
import cn.bdqn.collect.util.HTMLHelper;

public class TestCollectContent {
	
	public static void main(String[] args)throws Exception{
		String target="http://www.boohee.com/shiwu/mifan_zheng";
		String html=HTMLHelper.getHTML(target,"UTF-8");
		
		Jerry jerry=Jerry.jerry(html);
		//��ȡԪ��
		Jerry dds=jerry.$(".content dd:gt(0)");
		for(int i=0;i<dds.size();i++){
			Node node=dds.get(i);
			//��õ�һ��spanԪ�ص��ı�����
			String name=node.getChildElement(0).getTextContent();
			//��õڶ���spanԪ�ص��ı�����
			String value=node.getChildElement(1).getTextContent();
			System.out.println(name+"\t"+value);
		}
		
	}

}









