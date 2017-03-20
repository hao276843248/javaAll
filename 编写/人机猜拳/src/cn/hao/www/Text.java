package cn.hao.www;
import java.util.*;
public class Text {
	public static void main(String[] args) {
		System.out.println("猜拳游戏现在，开始准备好了吗？");
		System.out.println("========游戏规则=======");
		System.out.println("         "+"胜利加一分，否则不加分");
		System.out.println("         "+"当游戏结束时分高的为胜");
		System.out.println("====================");
		System.out.println("是否要开始游戏?");
		System.out.println("y/n");
		Scanner input=new Scanner(System.in);
		String a=input.next();
		hao hao=new hao();
		hao.c();
		while(a.equals("y")){
			System.out.println("asd");
			
		}
	}
}
