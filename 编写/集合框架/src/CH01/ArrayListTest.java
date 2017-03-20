package CH01;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ArrayListTest {
	public static void main(String[] args) {
		//创建ArrayList数组
		List<String> list=new ArrayList<String>();
		//通过size（）方法获得集合元素数量；
		System.out.println("集合刚创建好时，元素数量="+list.size());
		//通过add（）方法在集合末尾添加元素;
		String e="apple";
		list.add(e);
		System.out.println("集合添加后元素数量="+list.size());
		
		String str=(String)list.get(0);
		System.out.println(str);
		
		list.add("苹果");
		list.add("香蕉");
		list.add("梨");
		list.add("橘子");
		list.add("Mongo");
		
		//通过add()方法在集合中插入元素
		//插入元素后后面元素下标会变化
		
		list.add(2, "ri");
		list.set(3,"cacacs");
		list.remove("ri");
		
		//在集合中删除元素是下标重写下标超出范围发生异常
		list.remove(1);
		//清空list集合
		list.clear();
		System.out.println("清空后的集合元素数量"+list.size());
		//for循环遍历
		  for (int i = 0; i < list.size(); i++) {
			String value=(String)list.get(i);
			System.out.println("第"+(i+1)+"个元素"+value);
		}
		/*增强for循环
		for(String :list ){
			String value=(String)obj;
			System.out.println(value);
		}*/
		/*迭代循环输出
		Iterator it=list.iterator();
		while(it.hasNext()){
			String value=(String)it.next();
			System.out.println(value);
		}*/
		
	}
}
