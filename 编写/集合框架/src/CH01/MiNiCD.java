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
		dic.put("ƻ��", "APPLE");
		dic.put("����","cashew");
		dic.put("����","orange");
		dic.put("ľ��","pawpaw");
		dic.put("����", "xasdasd");
	
		System.out.print("���������ĵ��ʣ�");
		String a=input.next();
		List<String> as=new ArrayList<String>();
		
		Set<String> key=dic.keySet();
		
		for (String ac:key) {
			if(ac.contains(a)){
				as.add(ac+"---"+dic.get(ac));
			}
		}
		if(as.size()==0){
			System.out.println("û���ҵ�Ӣ�ĵ���");
		}else{
			System.out.println("�ҵ�"+as.size()+"��Ӣ�ĵ���");
			for (String str:as){
				System.out.println(str);
			}
		}	
	}
}
