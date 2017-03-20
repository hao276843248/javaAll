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
		//创建字符输出流
		Writer writer=new FileWriter(savePath+"\\"+title);
		//包装缓冲流
		BufferedWriter br=new BufferedWriter(writer);
		String url=BASE_URL+href;
		
		String hrml=HTMLHelper.getHTML(url, "UTF-8");
		
		Jerry jerry=Jerry.jerry(hrml);
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
