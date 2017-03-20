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
			//��������������
			DocumentBuilderFactory dbf=DocumentBuilderFactory.newInstance();
			//���Dom������
			DocumentBuilder builder=dbf.newDocumentBuilder();
			//��ô�������XML�ĵ���Document����
			Document doc=builder.parse("info.xml");
			//��ø�Ԫ��
			Element rootEl=doc.getDocumentElement();
			//�������
			String id=rootEl.getAttribute("id");
			System.out.println(id);
			//�鿴��Ԫ������
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
			//���������ӽڵ�
			NodeList childs=tecsNode.getChildNodes();
			for(int i=0;i<childs.getLength();i++){
				Node node=childs.item(i);
				//�жϽڵ������Ƿ�Ԫ�ؽڵ�
				if(node.getNodeType()==Node.ELEMENT_NODE){
					System.out.println(node.getTextContent());
				}
			}

			System.out.println("������ϣ�");
		} catch (Exception e) {
			System.out.println("����XML�ļ�ʱ��������");
		}
	}
	
}
