package cn.bdqn.collect.test;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

import jodd.jerry.Jerry;
import jodd.lagarto.dom.Node;
import cn.bdqn.collect.util.HTMLHelper;

public class xiancengh {
	private static final String BASE_URL="http://www.boohee.com";
	private static final String URL_PATTERN="http://www.boohee.com/food/group/${groundId}?page=${pageCount}";
	
	private int groundId;
	private int pageCount;
	private String savePath;
	
	
	public void run(){
		for(int page=0;page<=pageCount;page++){
			try {
			String url=URL_PATTERN.replace("${groundId}",groundId+"");
			url.replace("${pageCount}", pageCount+"");
			String html;
			html = HTMLHelper.getHTML(url,"UTF-8");
			//����HTML����
			Jerry jerry=Jerry.jerry(html);
			//��ȡ������Ԫ��
			Jerry links=jerry.$(".text-box a");
			//���ѡ��Ԫ�ص�����
			System.out.println(links.size());
			
			for(int i=0;i<links.size();i++){
				try {
					Node node=links.get(i);
					//��ȡtitle����
					String title=node.getAttribute("title");
					//��ȡhref����
					String href=node.getAttribute("href");
					collectContent(title,href);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	
	private void collectContent(String title,String href) throws Exception{
		//�����ַ������
		Writer writer=new FileWriter(savePath+"\\"+title);
		//��װ������
		BufferedWriter br=new BufferedWriter(writer);
		String url=BASE_URL+href;
		
		String hrml=HTMLHelper.getHTML(url, "UTF-8");
		
		Jerry jerry=Jerry.jerry(hrml);
		Jerry dds=jerry.$(".content dd:gt(0)");
		for(int i=0;i<dds.size();i++){
			Node node=dds.get(i);
			//��õ�һ��spanԪ�ص��ı�����
			String name=node.getChildElement(0).getTextContent();
			//��õڶ���spanԪ�ص��ı�����
			String value=node.getChildElement(1).getTextContent();
			br.write(name+":"+value);
			br.newLine();
		}
		//�ر���
		br.close();
		System.out.println(title+"���ݲɼ����");
	}
}
