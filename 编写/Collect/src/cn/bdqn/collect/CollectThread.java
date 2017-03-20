package cn.bdqn.collect;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.Writer;

import jodd.jerry.Jerry;
import jodd.lagarto.dom.Node;
import cn.bdqn.collect.util.HTMLHelper;

//采集线程，采集一个分类下的所欲食品营养信息
public class CollectThread extends Thread{
	private static final String BASE_URL="http://www.boohee.com";
	private static final String URL_PATTERN="http://www.boohee.com/food/group/${groupId}?page=${page}";
	
	//分组范围
	private int beginGroup;
	private int endGroup;
	
	//采集页数
	private int pageCount;
	//保存路径
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
		//遍历分组范围
		for(int group=beginGroup;group<=endGroup;group++){
			//遍历页号范围
			for(int page=1;page<=pageCount;page++){
				try {
					//获得要抓取的列表页的URL
					String url=URL_PATTERN.replace("${groupId}", group+"");
					url=url.replace("${page}",page+"");
					//获得列表页的内容
					String html=HTMLHelper.getHTML(url,"UTF-8");
					//解析HTML代码
					Jerry jerry=Jerry.jerry(html);
					//提取超链接元素
					Jerry links=jerry.$(".text-box a");
					//获得选中元素的数量
					System.out.println(links.size());
					
					for(int i=0;i<links.size();i++){
						try {
							Node node=links.get(i);
							//提取title属性
							String title=node.getAttribute("title");
							//提取href属性
							String href=node.getAttribute("href");
							//提取正文内容，存入文本文件
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
	
	//提取正文数据
	private void collectContent(String title,String href)throws Exception{
		//将标题中的/替换成|
		if(title.contains("饺子")){
			title=title.replace("/", "");
		}
		//创建文件输出流
		Writer writer=new FileWriter(savePath+"\\"+title+".txt");
		//包装缓冲流
		BufferedWriter br=new BufferedWriter(writer);
		
		
		String url=BASE_URL+href;
		
		String html=HTMLHelper.getHTML(url,"UTF-8");
		
		Jerry jerry=Jerry.jerry(html);
		//提取元素
		Jerry dds=jerry.$(".content dd:gt(0)");
		for(int i=0;i<dds.size();i++){
			Node node=dds.get(i);
			//获得第一个span元素的文本内容
			String name=node.getChildElement(0).getTextContent();
			//获得第二个span元素的文本内容
			String value=node.getChildElement(1).getTextContent();
			br.write(name+":"+value);
			br.newLine();
		}
		//关闭流
		br.close();
		System.out.println(title+"数据采集完毕");
	}
	
	
	
	
	
	
	

}
