package cn.bdqn.a;


import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
public class DOMTest {
	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		
		try {
			int a=1;
			Integer ac=new Integer(1);
			String c=ac.toString();
			System.out.println(ac+"-"+c+"-"+a+"-"+ac.toHexString(012345));
			DocumentBuilderFactory dbf=DocumentBuilderFactory.newInstance();
			DocumentBuilder db=dbf.newDocumentBuilder();
			Document doc=db.parse("hao.xml");
			
			Element rootEl=doc.getDocumentElement();
			System.out.println(rootEl.getNodeName());
			
			String name=rootEl.getElementsByTagName("name").item(0).getTextContent();
			String age=rootEl.getElementsByTagName("age").item(0).getTextContent();
			String gender=rootEl.getElementsByTagName("gender").item(0).getTextContent();
			String address=rootEl.getElementsByTagName("address").item(0).getTextContent();
			String education=rootEl.getElementsByTagName("education").item(0).getTextContent();
			System.out.println(name+"-"+age+"-"+gender+"-"+address+"-"+education);
			Node tecsNode=rootEl.getElementsByTagName("tecs").item(0);
			
			NodeList childs=tecsNode.getChildNodes();
			for(int i=0;i<childs.getLength();i++){
				Node node=childs.item(i);
				//判断节点类型是否元素节点
				if(node.getNodeType()==Node.ELEMENT_NODE){
					System.out.println(node.getTextContent());
				}
			}
			
			
		} catch (Exception e){
			System.out.println("操作XML文件发生错误"+e.getMessage());
		}
		
	}
}	
