package CH01;

import java.util.ArrayList;
import java.util.List;

public class StrudentTest {
	public static void main(String[] args) {
		List<Student> students=new ArrayList<Student>();
		students.add(new Student(1,"����"));
		students.add(new Student(2,"��2"));
		students.add(new Student(4,"��1"));
		students.add(new Student(3,"��5"));
		students.add(new Student(1,"����"));
		students.add(new Student(1,"����"));
	
		/*for(Object obj:stu){
			System.out.println(obj);
		}
		//�ж�
		System.out.println("");
		//����Ҫ��ȡĿ����±�
		System.out.println(stu.indexOf(new Student(1,"����")));
		
		
		while(stu.remove(new Student(1,"����")))
		
		for(Object obj:stu){
			System.out.println(obj);
		}*/
	
		
		
		
		for(Object obj:students){
			System.out.println(obj);
		}
		
		students.remove(new Student(1,"����"));
		
		//�жϼ������Ƿ���ڱ��Ϊ1������Ϊ������ѧ������
		System.out.println(students.contains(new Student(1,"����")));
		//��ü����б��Ϊ1������Ϊ������ѧ���ĳ���λ��
		System.out.println(students.indexOf(new Student(1,"����")));
		
		
		System.out.println("-----------------------");
		
		while(students.remove(new Student(1,"����")));
		
		//��ü����б��Ϊ1������Ϊ������ѧ���ĳ���λ��
		System.out.println(students.indexOf(new Student(1,"����")));
		
		for(Object obj:students){
			System.out.println(obj);
		}
	}
}