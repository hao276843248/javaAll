package cn.bdqn.ch06;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class DomTest {

	public static void main(String[] args) {
		try {
			//创建解析器工厂
			DocumentBuilderFactory dbf=DocumentBuilderFactory.newInstance();
			//获得Dom解析器
			DocumentBuilder builder=dbf.newDocumentBuilder();
			//获得代表整个XML文档的Document对象
			Document doc=builder.parse("info.xml");
			//获得根元素
			Element rootEl=doc.getDocumentElement();
			//获得属性
			String id=rootEl.getAttribute("id");
			System.out.println(id);
			//查看根元素名称
			System.out.println(rootEl.getNodeName());
			/*NodeList nl=rootEl.getElementsByTagName("name");
			Node node=nl.item(0);
			System.out.println(node.getTextContent());*/
			String name=rootEl.getElementsByTagName("name").item(0).getTextContent();
			String age=rootEl.getElementsByTagName("age").item(0).getTextContent();
			String gender=rootEl.getElementsByTagName("gender").item(0).getTextContent();
			String address=rootEl.getElementsByTagName("address").item(0).getTextContent();
			String education=rootEl.getElementsByTagName("education").item(0).getTextContent();
			Node tecsNode=rootEl.getElementsByTagName("tecs").item(0);
			
			System.out.println(name);
			System.out.println(age);
			System.out.println(gender);
			System.out.println(address);
			System.out.println(education);
			//遍历技能子节点
			NodeList childs=tecsNode.getChildNodes();
			for(int i=0;i<childs.getLength();i++){
				Node node=childs.item(i);
				//判断节点类型是否元素节点
				if(node.getNodeType()==Node.ELEMENT_NODE){
					System.out.println(node.getTextContent());
				}
			}

			System.out.println("解析完毕！");
		} catch (Exception e) {
			System.out.println("解析XML文件时发生错误");
		}
	}
	
}
