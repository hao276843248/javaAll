package cn.bdqn.collect.test;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import jodd.jerry.Jerry;
import jodd.lagarto.dom.Node;
import cn.bdqn.collect.util.HTMLHelper;

public class cao {
	
public static void main(String[] args) throws Exception {
	
	String h1="http://www.baidu.com";
	String jiexi=HTMLHelper.getHTML(h1,"UTF-8");
	System.out.println(jiexi);
	//解析HTML代码
	Jerry jie=Jerry.jerry(jiexi);
	//提取超链接元素
	Jerry link=jie.$(".content dd:gt(0)");
	for(int j=0;j<link.size();j++){
		Node node2=link.get(j);
		String nama=node2.getChildElement(0).getTextContent();
		String nasdString=node2.getChildElement(1).getTextContent();
		System.out.println(nama+"\t"+nasdString);
	}
}
}
