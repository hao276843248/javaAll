package cn.bdqn.collect.test;


import cn.bdqn.collect.util.HTMLHelper;

public class TestGetHTML {

	public static void main(String[] args)throws Exception{
		String target="http://www.boohee.com/food/group/1?page=1";
		String html=HTMLHelper.getHTML(target,"UTF-8");	
		System.out.println(html);

		
	}
	
}
