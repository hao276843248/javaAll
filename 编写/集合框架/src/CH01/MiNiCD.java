package CH01;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class MiNiCD {
	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		Map<String,String> dic=new HashMap<String, String>();
		dic.put("苹果", "APPLE");
		dic.put("腰果","cashew");
		dic.put("橘子","orange");
		dic.put("木瓜","pawpaw");
		dic.put("西瓜", "xasdasd");
	
		System.out.print("请输入中文单词：");
		String a=input.next();
		List<String> as=new ArrayList<String>();
		
		Set<String> key=dic.keySet();
		
		for (String ac:key) {
			if(ac.contains(a)){
				as.add(ac+"---"+dic.get(ac));
			}
		}
		if(as.size()==0){
			System.out.println("没有找到英文单词");
		}else{
			System.out.println("找到"+as.size()+"个英文单词");
			for (String str:as){
				System.out.println(str);
			}
		}	
	}
}
