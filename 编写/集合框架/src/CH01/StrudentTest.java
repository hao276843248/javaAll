package CH01;

import java.util.ArrayList;
import java.util.List;

public class StrudentTest {
	public static void main(String[] args) {
		List<Student> students=new ArrayList<Student>();
		students.add(new Student(1,"张三"));
		students.add(new Student(2,"张2"));
		students.add(new Student(4,"张1"));
		students.add(new Student(3,"张5"));
		students.add(new Student(1,"张三"));
		students.add(new Student(1,"张三"));
	
		/*for(Object obj:stu){
			System.out.println(obj);
		}
		//判断
		System.out.println("");
		//返回要获取目标的下标
		System.out.println(stu.indexOf(new Student(1,"张三")));
		
		
		while(stu.remove(new Student(1,"张三")))
		
		for(Object obj:stu){
			System.out.println(obj);
		}*/
	
		
		
		
		for(Object obj:students){
			System.out.println(obj);
		}
		
		students.remove(new Student(1,"张三"));
		
		//判断集合中是否存在编号为1，姓名为张三的学生对象
		System.out.println(students.contains(new Student(1,"张三")));
		//获得集合中编号为1，姓名为张三的学生的出现位置
		System.out.println(students.indexOf(new Student(1,"张三")));
		
		
		System.out.println("-----------------------");
		
		while(students.remove(new Student(1,"张三")));
		
		//获得集合中编号为1，姓名为张三的学生的出现位置
		System.out.println(students.indexOf(new Student(1,"张三")));
		
		for(Object obj:students){
			System.out.println(obj);
		}
	}
}