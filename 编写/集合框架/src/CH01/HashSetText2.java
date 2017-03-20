package CH01;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class HashSetText2 {
	public static void main(String[] args) {
		List<String> words=new ArrayList<String>();
		Scanner input=new Scanner(System.in);
		
		do{
			System.out.print("请输入单词");
			String word=input.next();
			words.add(word);
			System.out.print("是否还要继续录入（y/n）");
		}while(input.next().equalsIgnoreCase("Y"));
		
		for(Object obj:words){
			System.out.println(obj);
		}
		System.out.println();
		System.out.println("不重复的单词");
		Set<String> newWords=new HashSet<String>(words);
		
		for(Object obj:newWords){
			System.out.println(obj);
		}
	}
}
