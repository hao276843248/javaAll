package cn.bdqn.collect;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.Writer;

import jodd.jerry.Jerry;
import jodd.lagarto.dom.Node;
import cn.bdqn.collect.util.HTMLHelper;

//�ɼ��̣߳��ɼ�һ�������µ�����ʳƷӪ����Ϣ
public class CollectThread extends Thread{
	private static final String BASE_URL="http://www.boohee.com";
	private static final String URL_PATTERN="http://www.boohee.com/food/group/${groupId}?page=${page}";
	
	//���鷶Χ
	private int beginGroup;
	private int endGroup;
	
	//�ɼ�ҳ��
	private int pageCount;
	//����·��
	private String savePath;
	

	public CollectThread(int beginGroup, int endGroup, int pageCount,
			String savePath) {
		super();
		this.beginGroup = beginGroup;
		this.endGroup = endGroup;
		this.pageCount = pageCount;
		this.savePath = savePath;
	}

	@Override
	public void run() {
		//�������鷶Χ
		for(int group=beginGroup;group<=endGroup;group++){
			//����ҳ�ŷ�Χ
			for(int page=1;page<=pageCount;page++){
				try {
					//���Ҫץȡ���б�ҳ��URL
					String url=URL_PATTERN.replace("${groupId}", group+"");
					url=url.replace("${page}",page+"");
					//����б�ҳ������
					String html=HTMLHelper.getHTML(url,"UTF-8");
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
							//��ȡ�������ݣ������ı��ļ�
							collectContent(title,href);
						} catch (Exception e) {						
							e.printStackTrace();
						}
					}
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	//��ȡ��������
	private void collectContent(String title,String href)throws Exception{
		//�������е�/�滻��|
		if(title.contains("����")){
			title=title.replace("/", "");
		}
		//�����ļ������
		Writer writer=new FileWriter(savePath+"\\"+title+".txt");
		//��װ������
		BufferedWriter br=new BufferedWriter(writer);
		
		
		String url=BASE_URL+href;
		
		String html=HTMLHelper.getHTML(url,"UTF-8");
		
		Jerry jerry=Jerry.jerry(html);
		//��ȡԪ��
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
